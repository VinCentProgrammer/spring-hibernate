package com.dungken.DIContructorInjection.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageService{
    public ZaloService() {
        System.out.println("Zalo service: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Zalo sending ...";
    }
}
