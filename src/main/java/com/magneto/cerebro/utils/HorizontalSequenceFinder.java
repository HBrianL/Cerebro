package com.magneto.cerebro.utils;

public class HorizontalSequenceFinder extends SequenceFinder {

    public HorizontalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        for (String sequence : array) {
            if (this.Find(sequence))
                return true;
        }
        return false;
    }

}
