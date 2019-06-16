package com.magneto.cerebro.utils.sequenceFinder.builder;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderManager;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderManagerBuilder;

public class SequenceFinderBuildDirector {
    private ISequenceFinderManagerBuilder builder;

    public SequenceFinderBuildDirector(ISequenceFinderManagerBuilder builder) {
        this.builder = builder;
    }

    public SequenceFinderManager construct(String[] array, int matchLength) {
         return builder.setArray(array).setMatchLength(matchLength).build();
    }
}
