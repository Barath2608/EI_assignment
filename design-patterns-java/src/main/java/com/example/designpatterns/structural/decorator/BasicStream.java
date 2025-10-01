package com.example.designpatterns.structural.decorator;

public class BasicStream implements IDataStream {
    @Override
    public String process(String input) {
        return input;
    }
}
