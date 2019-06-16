package com.magneto.cerebro.utils.sequenceFinder.builder;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public interface ISequenceFinderManagerBuilder {
    SequenceFinder build();

    ISequenceFinderManagerBuilder setArray(String[] array);
    ISequenceFinderManagerBuilder setMatchLength(int matchLength);
}
