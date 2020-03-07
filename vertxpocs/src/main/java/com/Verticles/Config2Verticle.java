package com.Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.eventbus.EventBus;

public class Config2Verticle extends AbstractVerticle {


    public static void main(String[] args) {
        Launcher.executeCommand("run", Config2Verticle.class.getName());
    }

    @Override
    public void start(){
        System.out.println("Config2Verticle start");
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("TEST", message -> {
            Object body = message.body();
            System.out.println("ConfigVerticle "+ body);
            message.reply("Hello Msg from config2Verticle event bus");
        });
    }
}
