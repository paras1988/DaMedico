package com.main;

import com.Verticles.Route2Verticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Route2Main {

    public static void main(String[] args) {

      /*  String zkHosts = System.getProperty("zookeeperHosts", "127.0.0.1");

        JsonObject zkConfig = new JsonObject();
        zkConfig.put("zookeeperHosts", zkHosts);
        zkConfig.put("rootPath", "io.vertx");
        zkConfig.put("retry", new JsonObject().put("initialSleepTime", 3000).put("maxTimes", 3));

        ClusterManager mgr = new ZookeeperClusterManager(zkConfig);*/
        VertxOptions vertxOptions = new VertxOptions();//.setClusterManager(mgr);
        vertxOptions.getEventBusOptions().setClustered(true);

        Vertx.clusteredVertx(vertxOptions, event -> {
            if (event.succeeded()) {
                event.result().deployVerticle(new Route2Verticle(), new DeploymentOptions());
            } else {
            }
        });

    }
}