package com.lugowoy.tasks.solutions.arrays.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;

/**
 * Round all elements of the matrix to an integer.
 *
 * <p>Created by Konstantin Lugowoy on 07.11.2018.
 */
public class Main {

    private static final double BOUND = 20.0;

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixDoubles matrix = new MatrixDoubles(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFillerValues.DOUBLE_ZERO, BOUND));

        System.out.println("Original matrix : \n" + matrix + "\n");

        new Executor().execute(() -> {
            MatrixInts integerMatrix = new MatrixInts(matrix.getRows(),
                                                      matrix.getColumns());
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    integerMatrix.setElement(i, j, (int) Math
                            .round(matrix.getElement(i, j)));
                }
            }
            System.out.println("Result matrix : \n");
            System.out.println(integerMatrix);
        }, new OutputExecutionTimeToConsole());

    }

}
