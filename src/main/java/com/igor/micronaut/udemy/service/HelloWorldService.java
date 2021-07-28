package com.igor.micronaut.udemy.service;

import com.igor.micronaut.udemy.Application;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class HelloWorldService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldService.class);

    @Property(name = "hello.service.greeting")
    private String greeting;

    @EventListener
    public void onStartup(StartupEvent startupEvent) {
        LOG.debug("Startup: {}", HelloWorldService.class.getSimpleName());
    }

    public String sayHello() {
        return greeting;
    }
}
