package com.dungken.DIContructorInjection.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.dungken.DIContructorInjection.application",
                "com.dungken.DIContructorInjection.rest",
                "com.dungken.DIContructorInjection.service"
        }
)

public class DiContructorInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiContructorInjectionApplication.class, args);
    }

}
