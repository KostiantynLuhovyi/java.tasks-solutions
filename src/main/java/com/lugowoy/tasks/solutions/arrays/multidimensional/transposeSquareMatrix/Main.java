package com.lugowoy.tasks.solutions.arrays.multidimensional.transposeSquareMatrix;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.models.matrices.AbstractMatrix.DEFAULT_COLUMNS;
import static com.lugowoy.helper.models.matrices.AbstractMatrix.DEFAULT_ROWS;

/**
 * Transpose square matrix.
 * <p>
 * Created by Konstantin Lugowoy on 29.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(DEFAULT_ROWS, DEFAULT_COLUMNS, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = i + 1; j < matrix.getColumns(); j++) {
                int tmp = matrix.getElement(i, j);
                matrix.setElement(i, j, matrix.getElement(j, i));
                matrix.setElement(j, i, tmp);
            }
        }

        System.out.println("Transpose matrix : ");
        System.out.println(matrix);

    }

}
