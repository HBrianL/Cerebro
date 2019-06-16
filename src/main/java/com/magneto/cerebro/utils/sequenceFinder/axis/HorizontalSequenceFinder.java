package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public class HorizontalSequenceFinder extends SequenceFinder {

    public HorizontalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        for (String sequence : array) {
            if (this.Find(sequence)) {
                System.out.print("Encontrado en HorizontalSequenceFinder!!");
                return true;
            }
        }
        return false;
    }

}
