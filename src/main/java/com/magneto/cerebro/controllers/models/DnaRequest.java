package com.magneto.cerebro.controllers.models;

public class DnaRequest {
    private String[] dna;

    public DnaRequest(){}

    public DnaRequest(String[] dna)
    {
        dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
