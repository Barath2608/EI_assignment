package com.example.designpatterns.structural.decorator;

import java.util.Base64;

public class EncryptionDecorator implements IDataStream {
    private final IDataStream wrapped;
    public EncryptionDecorator(IDataStream wrapped) { this.wrapped = wrapped; }

    @Override
    public String process(String input) {
        String inner = wrapped.process(input);
        return Base64.getEncoder().encodeToString(inner.getBytes());
    }
}
