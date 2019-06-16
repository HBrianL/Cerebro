package com.magneto.cerebro.utils.sequenceFinder;

public abstract class SequenceFinderBase {
    private String[] array;
    private int matchLength;

    public SequenceFinderBase(String[] array, int matchLength) {
        this.array = array;
        this.matchLength = matchLength;
    }

    protected abstract int founds();

    protected String[] getArray() {
        return array;
    }

    protected int getMatchLength() {
        return matchLength;
    }

    protected int rowsCount(){
        return array.length;
    }

    protected int colsCount()
    {
        return array[0].length();
    }
}
