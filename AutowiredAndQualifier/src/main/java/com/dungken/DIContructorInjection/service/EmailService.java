package com.dungken.DIContructorInjection.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    @Override
    public String sendMessage() {
        return "Email sending ...";
    }
}
