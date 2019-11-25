package com.lugowoy.tasks.transposeOfSquareMatrixRepresentedAsTwoDimensionalArray;

import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Transpose of a square matrix represented as a two-dimensional array.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final int LENGTH_ARRAY = 5;

    public static void main(String[] args) {

        int[][] array = new int[LENGTH_ARRAY][LENGTH_ARRAY];

        System.out.println("Matrix before transpose : ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = GeneratorRandomNumber.generateInt(0, 10);
                System.out.print(array[i][j] + (j != LENGTH_ARRAY - 1 ? " " : "\n"));
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }

        System.out.println("Matrix after transpose : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + (j != LENGTH_ARRAY - 1 ? " " : "\n"));
            }
        }

    }

}

