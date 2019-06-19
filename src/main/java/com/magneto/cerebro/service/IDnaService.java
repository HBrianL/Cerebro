package com.magneto.cerebro.service;

import com.magneto.cerebro.domain.Dna;

public interface IDnaService {
    Dna createDna(String dna, boolean isMutant);

    void addDna(Dna dna);

    Iterable<Dna> findAll();
}
