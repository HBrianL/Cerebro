package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;

public class ObliqueRightSequenceFinder extends ObliqueSequenceFinder {
    public ObliqueRightSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        int firstColIndex = this.getColsCount() - 1;

        for (int i = this.matchLength; i < (this.getRowsCount() + this.getColsCount()) - (this.matchLength - 1); i++) {
            int indexPosition = (this.getRowsCount() + this.getColsCount()) - i; //Me fijo si ya iteró todas las filas;
            int startCol = Math.min(firstColIndex, indexPosition - 1); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(i, indexPosition);

            MatchCounter matchCounter = new MatchCounter();

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(this.getRowsCount(), i) - charItor - 1;
                int colIndex = startCol - charItor;

                char currentChar = array[rowIndex].charAt(colIndex);

                matchCounter.Count(currentChar);

                if (matchCounter.IsMatchEnd(this.matchLength)) {
                    System.out.print("FINDER - Secuencia encontrada en ObliqueRightSequenceFinder.");
                    System.out.print("\n");
                    return true;
                }
            }
        }

        return false;
    }
}
