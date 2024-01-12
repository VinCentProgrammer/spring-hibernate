package com.dungken.DIContructorInjection.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailService implements MessageService {
    public EmailService() {
        System.out.println("Email service: " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending ...";
    }
}
