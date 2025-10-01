package com.example.designpatterns.behavioral.strategy;

public class QuickSort implements ISortStrategy {
    @Override
    public int[] sort(int[] data) {
        if (data == null) return null;
        int[] copy = data.clone();
        quicksort(copy, 0, copy.length - 1);
        return copy;
    }

    private void quicksort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quicksort(a, lo, p - 1);
        quicksort(a, p + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[(lo + hi) / 2];
        int i = lo, j = hi;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                int t = a[i]; a[i] = a[j]; a[j] = t;
                i++; j--;
            }
        }
        return i - 1;
    }
}
