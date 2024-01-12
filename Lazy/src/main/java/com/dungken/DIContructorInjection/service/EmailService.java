package com.dungken.DIContructorInjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    public EmailService() {
        System.out.println("Email service: " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending ...";
    }
}
