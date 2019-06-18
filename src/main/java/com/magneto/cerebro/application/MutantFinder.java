package com.magneto.cerebro.application;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderBuilder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuildDirector;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuilder;

public class MutantFinder {

    public static boolean isMutant(String[] dna) {
        ISequenceFinderBuilder builder = new SequenceFinderBuilder();
        SequenceFinderBuildDirector director = new SequenceFinderBuildDirector(builder);

        SequenceFinder sequenceFinder = director.construct(dna, 4);
        int founds = sequenceFinder.foundSequences();

        System.out.print("FOUNDS - " + founds);
        System.out.print("\n");

        return founds > 1;
    }
}
