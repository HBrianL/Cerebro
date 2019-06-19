package com.magneto.cerebro.utils.sequenceFinder;

import com.magneto.cerebro.utils.sequenceFinder.axis.AxisSequenceFinder;

import java.util.ArrayList;

public class SequenceFinder {
    private ArrayList<AxisSequenceFinder> finders;

    public SequenceFinder(ArrayList<AxisSequenceFinder> finders) {
        this.finders = finders;
    }

    public int foundSequences() {
        int count = 0;
        for (AxisSequenceFinder finder : finders) {
            count += finder.founds();
        }
        System.out.print("FINDER - End");
        System.out.print("\n");
        return count;
    }
}
