package com.magneto.cerebro.service;

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
    public Iterable<Dna> findAll(){
        return  dnaRepository.findAll();
    }
}
