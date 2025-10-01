package com.example.designpatterns.behavioral.strategy;

public class BubbleSort implements ISortStrategy {
    @Override
    public int[] sort(int[] data) {
        if (data == null) return null;
        int[] a = data.clone();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int t = a[j]; a[j] = a[j+1]; a[j+1] = t;
                }
            }
        }
        return a;
    }
}
