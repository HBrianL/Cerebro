package com.magneto.cerebro.utils;

public class MatchCounter {
    private int count = 0;
    private Object current;

    public void Count(Object next) {
        if (current == next) {
            count++;
        } else {
            current = next;
            count = 1;
        }
    }

    public boolean IsMatchEnd(int matchEnd) {
        return count == matchEnd;
    }

}
