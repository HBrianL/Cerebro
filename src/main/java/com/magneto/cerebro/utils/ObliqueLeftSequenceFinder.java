package com.magneto.cerebro.utils;


public class ObliqueLeftSequenceFinder extends SequenceFinder {
    public ObliqueLeftSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        int rowsCount = this.array.length;
        int colsCount = this.array[0].length();
        int firstColIndex = 0;

        for (int i = this.matchLength; i < (rowsCount + colsCount) - (this.matchLength - 1); i++) {
            int indexPosition = (i - rowsCount); //Me fijo si ya iteró todas las filas;
            int startCol = Math.max(firstColIndex, indexPosition); // Si se pasa del maximo de filas, utilizo la posición del iterador.

            //Me fijo dónde termina la diagonal hacia arriba. Si llegó al máximo de columnas siempre termina en la última.
            int finalCol = (colsCount - startCol);

            //Longitud de la diagonal contra los límites.
            int charItorLength = Math.min(Math.min(i, finalCol), rowsCount);

            int matchCount = 0;
            char oldChar = array[0].charAt(0);
            char currentChar = oldChar;

            for (int charItor = 0; charItor < charItorLength; charItor++) {
                //Si llegó al final de las filas, a partir de ahí tomo el índice de las columnas.
                int rowIndex = Math.min(rowsCount, i) - charItor - 1;
                int colIndex = startCol + charItor;

                currentChar = array[rowIndex].charAt(colIndex);

                System.out.print(currentChar);

                if (oldChar == currentChar)
                    matchCount++;
                else {
                    oldChar = array[rowIndex].charAt(startCol + charItor);
                    matchCount = 1;
                }

                if (matchCount == matchLength)
                    return true;
            }

            System.out.printf("\n");
        }

        return false;
    }
}
