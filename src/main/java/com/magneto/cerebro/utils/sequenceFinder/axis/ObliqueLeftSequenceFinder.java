package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;

public class ObliqueLeftSequenceFinder extends ObliqueSequenceFinder {
    public ObliqueLeftSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        int firstColIndex = 0;

        for (int i = this.matchLength; i < (this.getRowsCount() + this.getColsCount()) - (this.matchLength - 1); i++) {
            int indexPosition = (i - this.getRowsCount()); //Me fijo si ya iteró todas las filas;
            int startCol = Math.max(firstColIndex, indexPosition); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Me fijo dónde termina la diagonal hacia arriba. Si llegó al máximo de columnas siempre termina en la última.
            int finalCol = (this.getColsCount() - startCol);

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(Math.min(i, finalCol), this.getRowsCount());

            MatchCounter matchCounter = new MatchCounter();

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(this.getRowsCount(), i) - charItor - 1;
                int colIndex = startCol + charItor;

                char currentChar = array[rowIndex].charAt(colIndex);

                matchCounter.Count(currentChar);

                if (matchCounter.IsMatchEnd(this.matchLength)) {
                    System.out.print("FINDER - Secuencia encontrada en ObliqueLeftSequenceFinder.");
                    System.out.print("\n");
                    return true;
                }
            }
        }

        return false;
    }
}
