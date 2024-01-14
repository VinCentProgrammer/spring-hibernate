package com.dungken.SpringRestfullAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {


    @GetMapping("/hello/en")
    public String helloEn() {
        return "Hello English!";
    }

    @GetMapping("hello/vi")
    public String helloVi() {
        return "Xin chào Việt Nam!";
    }
}
