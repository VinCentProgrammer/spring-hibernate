package com.dungken.DIContructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageInterface email;

//    @Autowired
//    public NotificationController(EmailService email) {
//        this.email = email;
//    }

    @Autowired
    public void setEmail(EmailService email) {
        this.email = email;
    }

    @GetMapping("/send-mail")
    public String sendMail() {
        return this.email.sendMessage();
    }
}
