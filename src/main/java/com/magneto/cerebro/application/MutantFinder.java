package com.magneto.cerebro.application;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderBuilder;

public class MutantFinder {
    private String[] dna;
    private ISequenceFinderBuilder builder;

    public MutantFinder(String[] dna, ISequenceFinderBuilder builder) {
        this.dna = dna;
        this.builder = builder;
    }

    public boolean hasValidNitroBase(String validNitroBases) {
        boolean contains;
        for (String sequence : dna) {
            for (char nitroBase : sequence.toCharArray()) {
                contains = validNitroBases.indexOf(nitroBase) != -1;
                if (!contains)
                    return false;
            }
        }
        return true;
    }

    public boolean hasValidDnaLength() {
        if (dna.length == 0)
            return false;

        int length = dna[0].length();
        for (String sequence : dna) {
            if (sequence.length() != length)
                return false;
        }

        return true;
    }

    public boolean isMutant(int matchLength) {
        SequenceFinder sequenceFinder = this.builder.setArray(this.dna).setMatchLength(matchLength).build();
        int founds = sequenceFinder.foundSequences();

        System.out.print("FOUNDS - " + founds);
        System.out.print("\n");

        return founds > 1;
    }
}
