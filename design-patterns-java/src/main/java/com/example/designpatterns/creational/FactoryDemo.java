package com.example.designpatterns.creational;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.creational.notification.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(FactoryDemo.class);

    public static class NotificationFactory {
        public INotification create(String type) {
            if (type == null) return null;
            switch(type.toLowerCase()) {
                case "email": return new EmailNotification();
                case "sms": return new SMSNotification();
                default: return null;
            }
        }
    }

    @Override
    public void run() {
        logger.info("--- Factory Demo Start ---");
        NotificationFactory factory = new NotificationFactory();
        INotification e = factory.create("email");
        if (e != null) e.send("Hello via Email");
        INotification s = factory.create("sms");
        if (s != null) s.send("Hello via SMS");
        INotification unknown = factory.create("push");
        if (unknown == null) logger.warn("Factory returned null for unknown type");
        logger.info("--- Factory Demo End ---");
    }

    @Override
    public String getName() { return "Factory (Creational)"; }
}
