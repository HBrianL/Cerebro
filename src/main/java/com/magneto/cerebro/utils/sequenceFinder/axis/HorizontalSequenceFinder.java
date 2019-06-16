package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderBase;

public class HorizontalSequenceFinder extends SequenceFinderBase {

    public HorizontalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public int founds() {
        MatchCounter matchCounter = new MatchCounter(this.getMatchLength());
        for (String sequence : this.getArray()) {
            for (int colIndex = 0; colIndex < sequence.length(); colIndex++) {

                matchCounter.count(sequence.charAt(colIndex));
            }
            matchCounter.reset();
        }
        System.out.print("FINDER - " + matchCounter.getMatchs() + " encontrados en HorizontalSequenceFinder.");
        System.out.print("\n");
        return matchCounter.getMatchs();
    }
}
