package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public class ObliqueRightSequenceFinder extends SequenceFinder {
    public ObliqueRightSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        int rowsCount = this.array.length;
        int colsCount = this.array[0].length();
        int firstColIndex = colsCount - 1;

        for (int i = this.matchLength; i < (rowsCount + colsCount) - (this.matchLength - 1); i++) {
            int indexPosition = (rowsCount + colsCount) - i; //Me fijo si ya iteró todas las filas;
            int startCol = Math.min(firstColIndex, indexPosition - 1); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Me fijo dónde termina la diagonal hacia arriba. Si llegó al máximo de columnas siempre termina en la última.
            int finalCol = Math.max(0, Math.min(firstColIndex, startCol - i));

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(i, indexPosition);

            int matchCount = 0;
            char oldChar = array[0].charAt(0);
            char currentChar = oldChar;

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(rowsCount, i) - charItor - 1;
                int colIndex = startCol - charItor;

                currentChar = array[rowIndex].charAt(colIndex);

                System.out.print(currentChar);

                if (oldChar == currentChar)
                    matchCount++;
                else {
                    oldChar = currentChar;
                    matchCount = 1;
                }

                if (matchCount == matchLength) {
                    System.out.print("Encontrado en ObliqueRightSequenceFinder!!");
                    return true;
                }
            }
            //}
            System.out.printf("\n");
        }
        System.out.print("==============");

        return false;
    }
}
