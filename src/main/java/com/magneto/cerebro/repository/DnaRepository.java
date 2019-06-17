package com.magneto.cerebro.repository;

import com.magneto.cerebro.domain.Dna;
import org.springframework.data.repository.CrudRepository;

public interface DnaRepository extends CrudRepository<Dna, Long> {
    Dna findByDna(String dna);
}
