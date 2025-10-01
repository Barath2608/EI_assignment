package com.example.designpatterns;

import com.example.designpatterns.behavioral.ObserverDemo;
import com.example.designpatterns.behavioral.StrategyDemo;
import com.example.designpatterns.creational.FactoryDemo;
import com.example.designpatterns.creational.BuilderDemo;
import com.example.designpatterns.structural.AdapterDemo;
import com.example.designpatterns.structural.DecoratorDemo;
import com.example.designpatterns.core.DemoRunner;
import com.example.designpatterns.core.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.Scanner;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application starting...");
        Config cfg = loadConfig();

        DemoRunner runner = new DemoRunner();

        if (cfg.getMode().equalsIgnoreCase("interactive")) {
            try (Scanner scanner = new Scanner(System.in)) {
                boolean exit = false;
                while (!exit) {
                    System.out.println("\nSelect demo to run:");
                    System.out.println("1) Observer (Behavioral)");
                    System.out.println("2) Strategy (Behavioral)");
                    System.out.println("3) Factory (Creational)");
                    System.out.println("4) Builder (Creational)");
                    System.out.println("5) Adapter (Structural)");
                    System.out.println("6) Decorator (Structural)");
                    System.out.println("7) Run All");
                    System.out.println("0) Exit");
                    System.out.print("Choice: ");
                    String choice = scanner.nextLine().trim();
                    switch (choice) {
                        case "1": runner.run(new ObserverDemo()); break;
                        case "2": runner.run(new StrategyDemo()); break;
                        case "3": runner.run(new FactoryDemo()); break;
                        case "4": runner.run(new BuilderDemo()); break;
                        case "5": runner.run(new AdapterDemo()); break;
                        case "6": runner.run(new DecoratorDemo()); break;
                        case "7": 
                            runner.run(new ObserverDemo());
                            runner.run(new StrategyDemo());
                            runner.run(new FactoryDemo());
                            runner.run(new BuilderDemo());
                            runner.run(new AdapterDemo());
                            runner.run(new DecoratorDemo());
                            break;
                        case "0": exit = true; break;
                        default: System.out.println("Unknown choice."); break;
                    }
                }
            } catch (Exception e) {
                logger.error("Interactive mode error: {}", e.getMessage(), e);
            }
        } else {
            logger.info("Running in daemon mode for {} iterations at {}ms intervals", cfg.getIterations(), cfg.getIntervalMs());
            ScheduledExecutorService svc = Executors.newSingleThreadScheduledExecutor();
            final int[] counter = {0};
            svc.scheduleAtFixedRate(() -> {
                try {
                    logger.info("Daemon iteration {}", counter[0]+1);
                    runner.runAllDemos();
                } catch (Exception e) {
                    logger.error("Error during daemon run: {}", e.getMessage(), e);
                }
                counter[0]++;
                if (cfg.getIterations() > 0 && counter[0] >= cfg.getIterations()) {
                    logger.info("Completed iterations; shutting down daemon.");
                    svc.shutdown();
                }
            }, 0, cfg.getIntervalMs(), TimeUnit.MILLISECONDS);
            try {
                svc.awaitTermination(cfg.getIterations() * cfg.getIntervalMs() + 5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                logger.warn("Daemon interrupted.");
                Thread.currentThread().interrupt();
            }
        }

        logger.info("Application stopping.");
    }

    private static Config loadConfig() {
        Properties p = new Properties();
        try (InputStream in = Main.class.getResourceAsStream("/config.properties")) {
            p.load(in);
        } catch (Exception e) {
            logger.warn("Failed to load config; using defaults.");
        }
        return Config.fromProperties(p);
    }
}
