package com.magneto.cerebro.utils;

public class Ratio {
    private int arg1;
    private int arg2;

    public Ratio(int arg1, int arg2)
    {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public double calculate() {
        int total = arg1 + arg2;
        int diff = arg1 - arg2;
        double ratio = (double) diff / total;
        return Math.round(ratio * 10) / 10.0;
    }
}
