package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderBase;

public class VerticalSequenceFinder extends SequenceFinderBase {
    public VerticalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public int founds() {
        MatchCounter matchCounter = new MatchCounter(this.getMatchLength());

        for (int col = 0; col < this.colsCount(); col++) {
            for (int row = 0; row < this.rowsCount(); row++) {
                matchCounter.count(this.getArray()[row].charAt(col));
            }
            matchCounter.reset();
        }
        System.out.print("FINDER - " + matchCounter.getMatchs() + " encontrados en VerticalSequenceFinder.");
        System.out.print("\n");

        return matchCounter.getMatchs();
    }
}
