package com.igor.micronaut.udemy;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    EmbeddedApplication application;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Property(name = "hello.controller.path")
    private String path;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testHelloResponse() {
        String result = client.toBlocking().retrieve(path);
        Assertions.assertEquals("Hello World from Service!", result);
    }

    @Test
    void testDeHelloResponse() {
        String result = client.toBlocking().retrieve(path + "/de");
        Assertions.assertEquals("Hallo!", result);
    }

    @Test
    void testEnHelloResponse() {
        String result = client.toBlocking().retrieve(path + "/en");
        Assertions.assertEquals("Hello!", result);
    }

}
