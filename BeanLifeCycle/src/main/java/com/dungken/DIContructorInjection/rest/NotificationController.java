package com.dungken.DIContructorInjection.rest;

import com.dungken.DIContructorInjection.service.EmailService;
import com.dungken.DIContructorInjection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageService service;
    private MessageService service_2;

    /* Contructor injection*/
    @Autowired
    public NotificationController(
            @Qualifier("emailService") MessageService service,
            @Qualifier("emailService") MessageService service_2) {
        this.service = service;
        this.service_2 = service_2;
    }

    @GetMapping("/send-mail")
    public String sendMail() {
        return this.service.sendMessage();
    }

    @GetMapping("/check")
    public String check() {
        return "Check singleton or prototype: " + (this.service == this.service_2);
    }

    @GetMapping("/check2")
    public String check2() {
        if(this.service == this.service_2) {
            return "SINGLETON";
        } else {
            return "PROTOTYPE";
        }
    }
}
