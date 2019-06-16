package com.magneto.cerebro.utils.sequenceFinder;

public abstract class SequenceFinder {
    protected String[] array;
    protected int matchLength;

    public SequenceFinder(String[] array, int matchLength) {
        this.array = array;
        this.matchLength = matchLength;
    }

    public abstract boolean Find();
}
