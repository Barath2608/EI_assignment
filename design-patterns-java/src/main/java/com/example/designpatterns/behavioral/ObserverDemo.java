package com.example.designpatterns.behavioral;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.behavioral.observer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(ObserverDemo.class);

    @Override
    public void run() {
        logger.info("--- Observer Demo Start ---");
        WeatherStation station = new WeatherStation();
        station.register(new ConsoleObserver());
        station.register(new LoggerObserver());
        station.setTemperature(25);
        station.setTemperature(27);
        station.unregister(new ConsoleObserver()); // no-op (different instance) - demonstrates safety
        station.setTemperature(22);
        logger.info("--- Observer Demo End ---");
    }

    @Override
    public String getName() { return "Observer (Behavioral)"; }
}
