package com.dungken.DIContructorInjection.rest;

import com.dungken.DIContructorInjection.service.EmailService;
import com.dungken.DIContructorInjection.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageInterface email;

    /* Contructor injection*/
    @Autowired
    public NotificationController(EmailService email) {
        this.email = email;
    }

    @GetMapping("/send-mail")
    public String sendMail() {
        return this.email.sendMessage();
    }
}
