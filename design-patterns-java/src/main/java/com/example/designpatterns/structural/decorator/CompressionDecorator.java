package com.example.designpatterns.structural.decorator;

public class CompressionDecorator implements IDataStream {
    private final IDataStream wrapped;
    public CompressionDecorator(IDataStream wrapped) { this.wrapped = wrapped; }

    @Override
    public String process(String input) {
        String compressed = input.replaceAll("[aeiouAEIOU]", "");
        return wrapped.process(compressed);
    }
}
