package com.magneto.cerebro.utils.sequenceFinder;

import java.util.ArrayList;

public class SequenceFinder {
    private ArrayList<SequenceFinderBase> finders;

    public SequenceFinder(ArrayList<SequenceFinderBase> finders) {
        this.finders = finders;
    }

    public int foundSequences() {
        int count = 0;
        for (SequenceFinderBase finder : finders) {
            count += finder.founds();
        }
        System.out.print("FINDER - End");
        System.out.print("\n");
        return count;
    }
}
