package com.example.designpatterns.structural;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.structural.decorator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoratorDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(DecoratorDemo.class);

    @Override
    public void run() {
        logger.info("--- Decorator Demo Start ---");
        IDataStream base = new BasicStream();
        IDataStream compressed = new CompressionDecorator(base);
        IDataStream encrypted = new EncryptionDecorator(compressed);
        String original = "Hello, design patterns!";
        String processed = encrypted.process(original);
        logger.info("Processed data: {}", processed);
        logger.info("--- Decorator Demo End ---");
    }

    @Override
    public String getName() { return "Decorator (Structural)"; }
}
