package com.magneto.cerebro.domain;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderBuilder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuildDirector;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuilder;

public class DnaService implements IDnaService {
    @Override
    public boolean isMutant(String[] dna) {
        ISequenceFinderBuilder builder = new SequenceFinderBuilder();
        SequenceFinderBuildDirector director = new SequenceFinderBuildDirector(builder);

        SequenceFinder manager = director.construct(dna, 4);
        int founds = manager.foundSequences();

        System.out.print("FOUNDS - " + founds);
        System.out.print("\n");
        return (founds > 1);
    }
}
