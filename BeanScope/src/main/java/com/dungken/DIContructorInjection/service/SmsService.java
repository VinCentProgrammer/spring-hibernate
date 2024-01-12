package com.dungken.DIContructorInjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    public SmsService() {
        System.out.println("Sms service: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Sms sending ...";
    }
}
