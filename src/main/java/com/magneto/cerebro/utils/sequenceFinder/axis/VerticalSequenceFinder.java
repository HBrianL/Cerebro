package com.magneto.cerebro.utils.sequenceFinder.axis;

import com.magneto.cerebro.utils.sequenceFinder.SequenceFinder;

public class VerticalSequenceFinder extends SequenceFinder {
    public VerticalSequenceFinder(String[] array, int matchLength) {
        super(array, matchLength);
    }

    @Override
    public boolean Find() {
        int colCant = array[0].length();
        char currentChar = array[0].charAt(0);
        char nextChar;
        int matchCount = 0;

//        for (int colIndex = 0; colIndex < colCant; colIndex++)
//        {
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            if (this.Find(array[rowIndex])) {
                System.out.print("Encontrado en VerticalSequenceFinder!!");
                return true;
            }
           /* nextChar = array[rowIndex].charAt(colIndex);
            if (currentChar != nextChar) {
                currentChar = nextChar;
                matchCount = 1;
            } else
                matchCount++;

            if (matchCount == matchLength)
                return true;*/
        }
        //}

        return false;
    }
}
