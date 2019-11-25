package com.lugowoy.tasks.printFilledMatrix5x5FromTopToBottom;

import com.lugowoy.helper.filling.array.numbers.FillingArrayAscendingInteger;
import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 14.09.2018.
 */

public class Main {

    private static final int END_BOUND = 25;
    private static final int START_BOUND = 1;

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];

        final int quadMatrixLength = matrix.length * matrix.length;
        Array<Integer> integerArray = new Array<>(new FillingArrayAscendingInteger().fill(quadMatrixLength, START_BOUND, END_BOUND));

        int indexElement = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = integerArray.get(indexElement);
                indexElement++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%3s", matrix[i][j]);
            }
            System.out.println();
        }

    }

}
