package com.example.designpatterns.behavioral.observer;

public class ConsoleObserver implements IObserver {
    @Override
    public void update(int temperature) {
        System.out.println("[ConsoleObserver] Temperature: " + temperature);
    }
}
