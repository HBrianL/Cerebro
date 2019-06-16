package com.magneto.cerebro.utils.sequenceFinder.builder;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderManager;

public interface ISequenceFinderManagerBuilder {
    SequenceFinderManager build();

    ISequenceFinderManagerBuilder setArray(String[] array);
    ISequenceFinderManagerBuilder setMatchLength(int matchLength);
}
