package com.magneto.cerebro.utils;

public abstract class SequenceFinder {
    protected String[] array;
    protected int matchLength;

    public SequenceFinder(String[] array, int matchLength) {
        this.array = array;
        this.matchLength = matchLength;
    }

    public abstract boolean Find();

    protected boolean Find(String sequence) {
        int matchCount = 0;
        char currentChar = sequence.charAt(0);
        char nextChar;

        //@@ PREGUNTAR SI ENTRA EN EL STRING QUE QUEDA PARA NO SEGUIR ITERANDO.
        for (int colIndex = 0; colIndex < sequence.length(); colIndex++) {
            nextChar = sequence.charAt(colIndex);

            System.out.print(nextChar);

            if (currentChar == nextChar) {
                matchCount++;
            } else {
                currentChar = nextChar;
                matchCount = 1;
            }
/*
            if (matchCount == matchLength)
                return true;

 */
        }
        System.out.printf("\n");

        return false;
    }
}
