package com.example.designpatterns.creational;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.creational.builder.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class BuilderDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(BuilderDemo.class);

    @Override
    public void run() {
        logger.info("--- Builder Demo Start ---");
        ReportBuilder builder = new ReportBuilder();
        builder.reset();
        builder.setTitle("Monthly - Minimal");
        builder.setSections(Arrays.asList());
        builder.setFooter("Generated minimal");
        logger.info("Minimal report: {}", builder.getResult());

        builder.reset();
        builder.setTitle("Yearly - Full");
        builder.setSections(Arrays.asList("Section1","Section2"));
        builder.setFooter("Generated full");
        logger.info("Full report: {}", builder.getResult());
        logger.info("--- Builder Demo End ---");
    }

    @Override
    public String getName() { return "Builder (Creational)"; }
}
