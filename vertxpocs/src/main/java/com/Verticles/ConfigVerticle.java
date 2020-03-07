package com.Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.eventbus.EventBus;

public class ConfigVerticle extends AbstractVerticle {


    public static void main(String[] args) {
        Launcher.executeCommand("run", ConfigVerticle.class.getName());
    }

    @Override
    public void start(){
        System.out.println("ConfigVerticle start");
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("TEST", message -> {
            Object body = message.body();
            System.out.println("ConfigVerticle "+ body);
            message.reply("Hello Msg from configVerticle event bus");
        });
    }
}
