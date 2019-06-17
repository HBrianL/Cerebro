package com.magneto.cerebro.service;

import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;

public interface IDnaService {
    void addDna(Dna dna);

    DnaStatsResponse getStats();
}
