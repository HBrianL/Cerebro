package com.magneto.cerebro.domain;

import javax.persistence.*;

@Entity
public class Dna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "dna")
    private String dna;
    @Column(name = "isMutant")
    private boolean isMutant;

    public Long getId() {
        return id;
    }

    public String getDna() {
        return dna;
    }

    public boolean getIsMutant() {
        return isMutant;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public void setIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
    }
}
