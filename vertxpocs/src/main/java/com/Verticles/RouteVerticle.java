package com.Verticles;

import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.circuitbreaker.CircuitBreakerOptions;
import io.vertx.core.*;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.impl.ConcurrentHashSet;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;
import io.vertx.servicediscovery.types.HttpEndpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RouteVerticle extends AbstractVerticle {

    protected ServiceDiscovery discovery;
    protected CircuitBreaker circuitBreaker;
    protected Set<Record> registeredRecords = new ConcurrentHashSet<>();


    public static void main(String[] args) {
        Launcher.executeCommand("run", RouteVerticle.class.getName());
    }

    @Override
    public void start(Promise<Void> promise){

        discovery = ServiceDiscovery
                .create(vertx, new ServiceDiscoveryOptions());

        // init circuit breaker instance
        JsonObject cbOptions = new JsonObject();
        circuitBreaker = CircuitBreaker.create(cbOptions.getString("name", "circuit-breaker"), vertx,
                new CircuitBreakerOptions()
                        .setMaxFailures(cbOptions.getInteger("max-failures", 5))
                        .setTimeout(cbOptions.getLong("timeout", 300000L))
                        .setFallbackOnFailure(true)
                        .setResetTimeout(cbOptions.getLong("reset-timeout", 10000L)));




        System.out.println("RouteVerticle start");

        Router router = Router.router(vertx);
        router.get("/clean").handler(this::stop);
        router.get("/send").handler(this::send);
        router.get("/test").handler(this::test);

        vertx.createHttpServer().requestHandler(router::accept).listen(8080, "localhost",
                ar -> {
                    if (ar.succeeded()) {
                        publishApiGateway("localhost", 8080);
                        // publish log
                        promise.complete();
                    } else {
                        promise.fail(ar.cause());
                    }
                });

    }

    private void send(RoutingContext routingContext) {
        EventBus eventBus = vertx.eventBus();
        eventBus.request("TEST", "question from route verticle", handler -> {
            if (handler.succeeded()) {
                String str = handler.result().body().toString();
                System.out.println("RouteVerticle "+str);

            }
            else{
                System.out.println(handler.cause().getLocalizedMessage());
            }
        });
    }


    public void stop(RoutingContext routingContext) {

        // In current design, the publisher is responsible for removing the service
        List<Future> futures = new ArrayList<>();
        registeredRecords.forEach(record -> {
            Future<Void> cleanupFuture = Future.future();
            futures.add(cleanupFuture);
            discovery.unpublish(record.getRegistration(), cleanupFuture.completer());
        });

        discovery.getRecords(record -> true, ar -> {
            if(ar.succeeded()){
                ar.result().stream().forEach(ar2 -> {
                    System.out.println("unpub "+ar2.getName());
                    discovery.unpublish(ar2.getRegistration(),rr -> {

                    });
                });
            }
            else {
            }
        });

        if (futures.isEmpty()) {
            discovery.close();
        } else {
            CompositeFuture.all(futures)
                    .setHandler(ar -> {
                        discovery.close();
                        if (ar.failed()) {
                        } else {
                        }
                    });
        }
    }

    private void test(RoutingContext routingContext) {
        System.out.println("Inside dispatch request " + routingContext);
        HttpServerResponse response = routingContext.response();
        circuitBreaker.execute(promise -> {
            getAllEndpoints().future().setHandler(ar -> {
                if (ar.succeeded()) {
                    List<Record> records = ar.result();
                    System.out.println("getAllEndpoints result "+  records.stream().map(Record::getName)
                            .collect(Collectors.joining(",")));
                    try {
                        Thread.sleep(222);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    records.stream().forEach(ee -> {
                        ee.setType("http-endpoint");
                        List<Record> records1 = ar.result();
                        ServiceDiscovery.releaseServiceObject(discovery, discovery.getReference(ee).get());
                    });

                    response.putHeader("content-type", "application/json").end("hurray Endpoint wrking great.. :-)");
                    promise.complete("hurray Endpoint wrking great.. :-)");
                }
                else {
                    System.out.println(ar.cause());
                    response.putHeader("content-type", "application/json").end("NOPESS.. :-(");
                    promise.fail(ar.cause());
                }



            });
        }).setHandler(ar -> {
            if (ar.failed()) {
                badGateway(ar.cause(), routingContext);
            }
        });
    }

    private Promise<List<Record>> getAllEndpoints() {
        Promise<List<Record>> promise = Promise.promise();
        discovery.getRecords(record -> true, ar -> {
            if(ar.succeeded()){
                promise.complete(ar.result());
            }
            else {
                promise.fail(ar.cause());
            }
        });
        return promise;
    }

    private Future<Void> publish(Record record) {
        if (discovery == null) {
            try {
                start();
            } catch (Exception e) {
                throw new IllegalStateException("Cannot create discovery service");
            }
        }

        Future<Void> future = Future.future();
        // publish the service
        discovery.publish(record, ar -> {
            if (ar.succeeded()) {
                registeredRecords.add(record);
                System.out.println("Service <" + ar.result().getName() + "> published");
                future.complete();
            } else {
                future.fail(ar.cause());
            }
        });

        return future;
    }

    protected Future<Void> publishApiGateway(String host, int port) {
        Record record = HttpEndpoint.createRecord("RouteVerticle-gatweway", false, host, port, "/", null);
        return publish(record);
    }

    protected void badGateway(Throwable ex, RoutingContext context) {
        ex.printStackTrace();
        context.response().setStatusCode(502)
                .putHeader(CONTENT_TYPE, APPLICATION_JSON)
                .end(new JsonObject().put("error", "bad_gateway")
                        // .put("message", ex.getMessage())
                        .encodePrettily());
    }
    public static final String CONTENT_TYPE = "content-type";
    public static final String APPLICATION_JSON = "application/json";
}
