package com.dungken.DIContructorInjection.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    @PostConstruct
    public void init() {
        System.out.println("1. Doan code nay duoc run ngay sau khi khoi tao: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void init2() {
        System.out.println("2. Doan code nay duoc run ngay sau khi khoi tao: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("1. Doan code nay duoc run truoc khi huy: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy2() {
        System.out.println("2. Doan code nay duoc run truoc khi huy: " + getClass().getSimpleName());
    }

    public EmailService() {
        System.out.println("Email service: " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending ...";
    }
}
