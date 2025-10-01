package com.example.designpatterns.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(LoggerObserver.class);

    @Override
    public void update(int temperature) {
        logger.info("[LoggerObserver] Temp={}", temperature);
    }
}
