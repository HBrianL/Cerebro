package com.magneto.cerebro.service;

import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.repository.DnaRepository;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderBuilder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuildDirector;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class DnaService implements IDnaService {
    @Autowired
    private DnaRepository dnaRepository;

    @Override
    public boolean isMutant(String[] dna) {
        ISequenceFinderBuilder builder = new SequenceFinderBuilder();
        SequenceFinderBuildDirector director = new SequenceFinderBuildDirector(builder);

        SequenceFinder sequenceFinder = director.construct(dna, 4);
        int founds = sequenceFinder.foundSequences();

        System.out.print("FOUNDS - " + founds);
        System.out.print("\n");
        return (founds > 1);
    }

    @Override
    public void addDna(Dna dna) {
        Dna d = dnaRepository.findByDna(dna.getDna());

        if (d == null)
            dnaRepository.save(dna);
    }

    @Override
    public DnaStatsResponse getStats() {
        Iterable<Dna> dnas = dnaRepository.findAll();
        DnaStatsResponse stats = new DnaStatsResponse();

        for (Dna dna : dnas) {
            if (dna.getIsMutant())
                stats.setCount_mutant_dna(stats.getCount_mutant_dna() + 1);
            else
                stats.setCount_human_dna(stats.getCount_human_dna() + 1);
        }

        return stats;
    }
}
