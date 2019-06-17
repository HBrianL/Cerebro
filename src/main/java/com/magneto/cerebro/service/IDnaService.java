package com.magneto.cerebro.service;

import com.magneto.cerebro.domain.Dna;

public interface IDnaService {
    boolean isMutant(String[] dna);

    void addDna(Dna dna);
}
