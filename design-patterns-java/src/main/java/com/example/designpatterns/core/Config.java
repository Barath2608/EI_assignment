package com.example.designpatterns.core;

import java.util.Properties;

public class Config {
    private final String mode;
    private final int iterations;
    private final long intervalMs;

    public Config(String mode, int iterations, long intervalMs) {
        this.mode = mode;
        this.iterations = iterations;
        this.intervalMs = intervalMs;
    }

    public String getMode() { return mode; }
    public int getIterations() { return iterations; }
    public long getIntervalMs() { return intervalMs; }

    public static Config fromProperties(Properties p) {
        String mode = p.getProperty("mode", "interactive");
        int iterations =  Integer.parseInt(p.getProperty("iterations", "5"));
        long intervalMs = Long.parseLong(p.getProperty("intervalMs", "2000"));
        return new Config(mode, iterations, intervalMs);
    }
}
