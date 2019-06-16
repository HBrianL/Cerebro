package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

abstract class XYSequenceFinder extends SequenceFinder {
    XYSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    boolean Find(String sequence) {
        MatchCounter matchCounter = new MatchCounter();

        for (int colIndex = 0; colIndex < sequence.length(); colIndex++) {

            matchCounter.Count(sequence.charAt(colIndex));

            if (matchCounter.IsMatchEnd(this.matchLength))
                return true;
        }

        return false;
    }
}
