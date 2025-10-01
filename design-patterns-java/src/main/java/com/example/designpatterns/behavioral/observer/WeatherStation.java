package com.example.designpatterns.behavioral.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation {
    private final List<IObserver> observers = new CopyOnWriteArrayList<>();

    public void register(IObserver o) {
        if (o == null) throw new IllegalArgumentException("Observer cannot be null");
        observers.add(o);
    }

    public void unregister(IObserver o) {
        observers.remove(o);
    }

    public void setTemperature(int t) {
        for (IObserver o : observers) {
            try {
                o.update(t);
            } catch (Exception ignored) {
                // resilient: continue notifying others
            }
        }
    }
}
