package com.magneto.cerebro.utils;

public class MatchCounter {
    private int count = 0;
    private int matchs = 0;
    private Object current;
    private int matchLength;

    public MatchCounter(int matchLength) {
        this.matchLength = matchLength;
    }

    public int getMatchs() {
        return matchs;
    }

    private boolean isMatchEnd(int matchEnd) {
        return count == matchEnd;
    }

    public void reset() {
        count = 0;
    }

    public void count(Object next) {
        if (current == next) {
            count++;
            if (isMatchEnd(matchLength)) {
                matchs++;
            }
        } else {
            current = next;
            count = 1;
        }
    }
}
