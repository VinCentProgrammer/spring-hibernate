package com.dungken.JavaCodeConfigurationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyUtil {
    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
