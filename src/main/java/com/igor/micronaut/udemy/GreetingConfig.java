package com.igor.micronaut.udemy;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.config.greetings")
public class GreetingConfig {
    @Getter
    final String de;
    @Getter
    final String en;

    @ConfigurationInject
    public GreetingConfig(@NotBlank String de,@NotBlank String en) {
        this.de = de;
        this.en = en;
    }
}
