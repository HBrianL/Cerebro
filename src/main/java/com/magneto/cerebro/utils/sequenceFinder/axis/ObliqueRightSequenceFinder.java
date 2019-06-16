package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderBase;

public class ObliqueRightSequenceFinder extends SequenceFinderBase {
    public ObliqueRightSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public int founds() {
        int firstColIndex = this.colsCount() - 1;
        MatchCounter matchCounter = new MatchCounter(this.getMatchLength());

        for (int i = this.getMatchLength(); i < (this.rowsCount() + this.colsCount()) - (this.getMatchLength() - 1); i++) {
            int indexPosition = (this.rowsCount() + this.colsCount()) - i; //Me fijo si ya iteró todas las filas;
            int startCol = Math.min(firstColIndex, indexPosition - 1); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(i, indexPosition);

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(this.rowsCount(), i) - charItor - 1;
                int colIndex = startCol - charItor;

                char currentChar = this.getArray()[rowIndex].charAt(colIndex);

                matchCounter.count(currentChar);
            }

            matchCounter.reset();
        }

        System.out.print("FINDER - " + matchCounter.getMatchs() + " encontrados en ObliqueRightSequenceFinder.");
        System.out.print("\n");

        return matchCounter.getMatchs();
    }
}
