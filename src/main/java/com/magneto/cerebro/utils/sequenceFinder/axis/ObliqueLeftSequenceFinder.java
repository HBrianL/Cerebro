package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.MatchCounter;

public class ObliqueLeftSequenceFinder extends AxisSequenceFinder {
    public ObliqueLeftSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public int founds() {
        int firstColIndex = 0;
        int startRow = this.getMatchLength();
        int endIteration = ((this.rowsCount() + this.colsCount()) - startRow) - 1;

        MatchCounter matchCounter = new MatchCounter(this.getMatchLength());

        for (int i = startRow; i < endIteration; i++) {
            int indexPosition = (i - this.rowsCount()); //Me fijo si ya iteró todas las filas;
            int startCol = Math.max(firstColIndex, indexPosition); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Me fijo dónde termina la diagonal hacia arriba. Si llegó al máximo de columnas siempre termina en la última.
            int finalCol = (this.colsCount() - startCol);

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(Math.min(i, finalCol), this.rowsCount());

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(this.rowsCount(), i) - charItor - 1;
                int colIndex = startCol + charItor;

                char currentChar = this.getArray()[rowIndex].charAt(colIndex);

                matchCounter.count(currentChar);
            }

            matchCounter.reset();
        }

        System.out.print("FINDER - " + matchCounter.getMatchs() + " encontrados en ObliqueLeftSequenceFinder.");
        System.out.print("\n");

        return matchCounter.getMatchs();
    }
}
