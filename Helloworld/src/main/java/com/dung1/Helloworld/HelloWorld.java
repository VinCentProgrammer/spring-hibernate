package com.dung1.Helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/h2")
    public String index2() {
        return "Xin chào!";
    }
}
