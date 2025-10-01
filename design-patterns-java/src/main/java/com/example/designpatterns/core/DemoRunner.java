package com.example.designpatterns.core;

import com.example.designpatterns.behavioral.ObserverDemo;
import com.example.designpatterns.behavioral.StrategyDemo;
import com.example.designpatterns.creational.FactoryDemo;
import com.example.designpatterns.creational.BuilderDemo;
import com.example.designpatterns.structural.AdapterDemo;
import com.example.designpatterns.structural.DecoratorDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoRunner.class);

    public void run(IDemo demo) {
        logger.info("Running demo: {}", demo.getName());
        try {
            demo.run();
        } catch (Exception e) {
            logger.error("Demo {} failed: {}", demo.getName(), e.getMessage(), e);
        }
    }

    public void runAllDemos() {
        run(new ObserverDemo());
        run(new StrategyDemo());
        run(new FactoryDemo());
        run(new BuilderDemo());
        run(new AdapterDemo());
        run(new DecoratorDemo());
    }
}
