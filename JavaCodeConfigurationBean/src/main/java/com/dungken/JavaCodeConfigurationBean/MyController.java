package com.dungken.JavaCodeConfigurationBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private Calculator calculator;
    @Autowired
    public MyController(@Qualifier("calculator") Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("square")
    public String square(@RequestParam("value") double x) {
        return "SQRT(" + x + ") = " + calculator.square(x);
    }

    @GetMapping("pow")
    public String power(@RequestParam("value") double x) {
        return x + "^2 = " + calculator.power(x);
    }
}
