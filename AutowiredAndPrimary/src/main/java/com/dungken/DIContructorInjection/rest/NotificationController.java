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

    /* Contructor injection*/
    @Autowired
    public NotificationController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/send-mail")
    public String sendMail() {
        return this.service.sendMessage();
    }
}
