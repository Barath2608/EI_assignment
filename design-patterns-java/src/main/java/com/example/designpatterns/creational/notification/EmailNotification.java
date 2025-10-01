package com.example.designpatterns.creational.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotification implements INotification {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Override
    public void send(String message) {
        logger.info("[EmailNotification] Sent: {}", message);
    }
}
