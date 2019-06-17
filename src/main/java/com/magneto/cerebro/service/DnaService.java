package com.magneto.cerebro.service;

import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DnaService implements IDnaService {
    @Autowired
    private DnaRepository dnaRepository;

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
