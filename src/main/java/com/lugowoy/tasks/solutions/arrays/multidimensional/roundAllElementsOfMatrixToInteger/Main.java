package com.lugowoy.tasks.solutions.arrays.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Round all elements of the matrix to an integer.
 * <p> Created by Konstantin Lugowoy on 07.11.2018.
 */
public class Main {

    private static final double BOUND = 20.0;

    public static void main(String[] args) {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixDoubles matrix = new MatrixDoubles(Helper.FILLING_MATRIX_DOUBLES.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        MatrixInts integerMatrix = new MatrixInts(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                integerMatrix.setElement(i, j, (int) Math.round(matrix.getElement(i, j)));
            }
        }

        System.out.println("Result matrix : ");
        System.out.println(integerMatrix);

    }

}
