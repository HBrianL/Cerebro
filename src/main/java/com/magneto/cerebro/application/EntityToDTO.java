package com.magneto.cerebro.application;

import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;

public class EntityToDTO {
    public static DnaStatsResponse dnaToDnaStatsResponse(Iterable<Dna> dnas)
    {
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
