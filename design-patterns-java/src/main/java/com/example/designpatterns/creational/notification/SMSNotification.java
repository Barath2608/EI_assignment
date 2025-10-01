package com.example.designpatterns.creational.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSNotification implements INotification {
    private static final Logger logger = LoggerFactory.getLogger(SMSNotification.class);

    @Override
    public void send(String message) {
        logger.info("[SMSNotification] Sent: {}", message);
    }
}
