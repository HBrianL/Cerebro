package com.magneto.cerebro.controllers.models;

import java.text.DecimalFormat;

public class DnaStatsResponse {
    private int count_mutant_dna;
    private int count_human_dna;

    public int getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public int getCount_human_dna() {
        return count_human_dna;
    }

    public double getRatio() {
        int total = count_human_dna + count_mutant_dna;
        int diff = count_human_dna - count_mutant_dna;
        double ratio = (double) diff / total;
        return Math.round(ratio * 10) / 10.0;
    }

    public void setCount_mutant_dna(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public void setCount_human_dna(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }
}
