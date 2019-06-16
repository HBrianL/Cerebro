package com.magneto.cerebro.domain;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderManagerBuilder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuildDirector;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderManagerBuilder;

public class DnaService implements IDnaService {
    @Override
    public boolean isMutant(String[] dna) {
        ISequenceFinderManagerBuilder builder = new SequenceFinderManagerBuilder();
        SequenceFinderBuildDirector director = new SequenceFinderBuildDirector(builder);

        SequenceFinder manager = director.construct(dna, 4);
        int founds = manager.foundSequences();

        System.out.print("FOUNDS - " + founds);
        System.out.print("\n");
        return (founds > 1);
    }
}
