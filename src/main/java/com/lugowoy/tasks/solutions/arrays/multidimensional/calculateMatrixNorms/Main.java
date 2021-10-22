package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;

/**
 * Calculate matrix norms.
 *
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    private static final String MSG_RESULT_ROWS_NORM = "Norm of rows : %.3f";
    private static final String MSG_RESULT_COLUMNS_NORM = "Norm of columns : %.3f";

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();

        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixDoubles matrix = new MatrixDoubles(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFillerValues.DOUBLE_NEGATIVE_TEN,
                HelperFillerValues.DOUBLE_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(() -> {
            CalculatorMatrixNorms calculatorMatrixNorms =
                    CalculatorMatrixNorms::calculateNormMatrixRows;
            double normMatrixRows = calculatorMatrixNorms.calculate(matrix);

            calculatorMatrixNorms = CalculatorMatrixNorms::calculateNormMatrixColumns;
            double normMatrixColumns = calculatorMatrixNorms.calculate(matrix);

            System.out.printf(MSG_RESULT_ROWS_NORM, normMatrixRows);
            System.out.println();
            System.out.printf(MSG_RESULT_COLUMNS_NORM, normMatrixColumns);
        }, new OutputExecutionTimeToConsole());

    }

}
