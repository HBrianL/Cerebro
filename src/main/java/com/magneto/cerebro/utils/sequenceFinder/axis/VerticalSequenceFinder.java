package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public class VerticalSequenceFinder extends XYSequenceFinder {
    public VerticalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        for (String sequence : array) {
            if (this.Find(sequence)) {
                System.out.print("FINDER - Secuencia encontrada en VerticalSequenceFinder.");
                System.out.print("\n");
                return true;
            }
        }

        return false;
    }
}
