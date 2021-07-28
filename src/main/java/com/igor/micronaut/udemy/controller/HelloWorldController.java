package com.igor.micronaut.udemy.controller;

import com.igor.micronaut.udemy.GreetingConfig;
import com.igor.micronaut.udemy.service.HelloWorldService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;
    private final GreetingConfig config;

    public HelloWorldController(HelloWorldService helloWorldService, GreetingConfig config) {
        this.helloWorldService = helloWorldService;
        this.config = config;
    }

    @Get("/")
    public String index() {
        return helloWorldService.sayHello();
    }

    @Get("/de")
    public String greetingDe() {
        return config.getDe();
    }

    @Get("/en")
    public String greetingEn() {
        return config.getEn();
    }
}
