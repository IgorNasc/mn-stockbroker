package com.igor.micronaut.udemy;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.config.greetings")
public class GreetingConfig {
    final String de;
    final String en;

    @ConfigurationInject
    public GreetingConfig(@NotBlank String de,@NotBlank String en) {
        this.de = de;
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public String getEn() {
        return en;
    }
}
