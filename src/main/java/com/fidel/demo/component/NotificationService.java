package com.fidel.demo.component;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    
    public void sendNotification(String message) {
        System.out.println("Enviando notificación: " + message);
    }
}