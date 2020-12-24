package com.lugowoy.tasks.solutions.arrays.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Round all elements of the matrix to an integer.
 *
 * <p>Created by Konstantin Lugowoy on 07.11.2018.
 */
public class Main {

    private static final double BOUND = 20.0;

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixDoubles matrix = new MatrixDoubles(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFiller.DOUBLE_ZERO, BOUND));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> {
            MatrixInts integerMatrix = new MatrixInts(matrix.getRows(), matrix.getColumns());
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    integerMatrix.setElement(i, j, (int) Math.round(matrix.getElement(i, j)));
                }
            }
            System.out.println("Result matrix : \n");
            System.out.println(integerMatrix);
        }, new OutputExecutionTimeToConsole());

    }

}
