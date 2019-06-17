package com.magneto.cerebro.service;

import com.magneto.cerebro.domain.Dna;

public interface IDnaService {
    void addDna(Dna dna);
    Iterable<Dna> findAll();
}
