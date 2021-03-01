package com.lugowoy.tasks.solutions.arrays.multidimensional.transposeSquareMatrix;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;

/**
 * Transpose square matrix.
 *
 * <p>Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    public static void main(String[] args) {

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();
        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(),
                AbstractMatrix.DEFAULT_ROWS, AbstractMatrix.DEFAULT_COLUMNS,
                HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(() -> {
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = i + 1; j < matrix.getColumns(); j++) {
                    int tmp = matrix.getElement(i, j);
                    matrix.setElement(i, j, matrix.getElement(j, i));
                    matrix.setElement(j, i, tmp);
                }
            }

            System.out.println("Transpose matrix : ");
            System.out.println(matrix);
        }, new OutputExecutionTimeToConsole());

    }

}
