package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

abstract class ObliqueSequenceFinder extends SequenceFinder {
    private int rowsCount;
    private int colsCount;

    ObliqueSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);

        this.rowsCount = this.array.length;
        this.colsCount = this.array[0].length();
    }

    int getColsCount() {
        return colsCount;
    }

    int getRowsCount() {
        return rowsCount;
    }
}
