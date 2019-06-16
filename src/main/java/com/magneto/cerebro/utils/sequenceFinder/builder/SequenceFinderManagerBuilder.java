package com.magneto.cerebro.utils.sequenceFinder.builder;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderManager;
import com.magneto.cerebro.utils.sequenceFinder.axis.HorizontalSequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.axis.ObliqueLeftSequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.axis.VerticalSequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.axis.ObliqueRightSequenceFinder;

import java.util.ArrayList;

public class SequenceFinderManagerBuilder implements ISequenceFinderManagerBuilder {
    private String[] array;
    private int matchLength;

    @Override
    public SequenceFinderManager build() {
        ArrayList<SequenceFinder> finders = new ArrayList<>();
        finders.add(new HorizontalSequenceFinder(array, matchLength));
        finders.add(new VerticalSequenceFinder(array, matchLength));
        finders.add(new ObliqueLeftSequenceFinder(array, matchLength));
        finders.add(new ObliqueRightSequenceFinder(array, matchLength));
        return new SequenceFinderManager(finders);
    }

    @Override
    public ISequenceFinderManagerBuilder setArray(String[] array) {
        this.array = array;
        return this;
    }

    @Override
    public ISequenceFinderManagerBuilder setMatchLength(int matchLength) {
        this.matchLength = matchLength;
        return this;
    }
}
