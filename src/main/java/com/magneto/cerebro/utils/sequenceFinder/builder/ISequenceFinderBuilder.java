package com.magneto.cerebro.utils.sequenceFinder.builder;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public interface ISequenceFinderBuilder {
    SequenceFinder build();

    ISequenceFinderBuilder setArray(String[] array);
    ISequenceFinderBuilder setMatchLength(int matchLength);
}
