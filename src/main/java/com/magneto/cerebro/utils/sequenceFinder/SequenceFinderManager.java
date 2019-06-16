package com.magneto.cerebro.utils.sequenceFinder;

import java.util.ArrayList;

public class SequenceFinderManager {
    private ArrayList<SequenceFinder> finders;

    public SequenceFinderManager(ArrayList<SequenceFinder> finders) {
        this.finders = finders;
    }

    public int foundSequences() {
        int count = 0;
        for (SequenceFinder finder : finders) {
            if (finder.Find())
                count++;
        }
        System.out.print("FINDER - End");
        System.out.print("\n");
        return count;
    }
}
