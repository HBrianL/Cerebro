package com.magneto.cerebro.utils.sequenceFinder.axis;

public abstract class AxisSequenceFinder {
    private String[] array;
    private int matchLength;

    AxisSequenceFinder(String[] array, int matchLength) {
        this.array = array;
        this.matchLength = matchLength;
    }

    public abstract int founds();

    String[] getArray() {
        return array;
    }

    int getMatchLength() {
        return matchLength;
    }

    int rowsCount() {
        return array.length;
    }

    int colsCount() {
        if (array.length > 0)
            return array[0].length();

        return 0;
    }
}
