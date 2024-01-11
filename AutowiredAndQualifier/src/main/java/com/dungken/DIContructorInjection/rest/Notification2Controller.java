package com.dungken.DIContructorInjection.rest;

import com.dungken.DIContructorInjection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification2Controller {
    private MessageService emailService;
    private MessageService smsService;
    private MessageService zaloService;

    @Autowired
    public Notification2Controller(
            @Qualifier("emailService") MessageService emailService,
            @Qualifier("smsService") MessageService smsService,
            @Qualifier("zaloService") MessageService zaloService
    ) {
        this.emailService = emailService;
        this.zaloService = zaloService;
        this.smsService = smsService;
    }

    @GetMapping("email")
    public String email() {
        return this.emailService.sendMessage();
    }

    @GetMapping("sms")
    public String sms() {
        return this.smsService.sendMessage();
    }

    @GetMapping("zalo")
    public String zalo() {
        return this.zaloService.sendMessage();
    }
}
