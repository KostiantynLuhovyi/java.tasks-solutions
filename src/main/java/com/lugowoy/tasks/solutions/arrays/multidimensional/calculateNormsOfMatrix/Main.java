package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateNormsOfMatrix;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Calculate norms of the matrix.
 *
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    private static final String MSG_RESULT_ROWS_NORM = "Norm of rows : %.3f";
    private static final String MSG_RESULT_COLUMNS_NORM = "Norm of columns : %.3f";

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixDoubles matrix = new MatrixDoubles(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFiller.DOUBLE_NEGATIVE_TEN,
                HelperFiller.DOUBLE_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> {
            CalculatorMatrixNorms calculatorMatrixNorms =
                    CalculatorMatrixNorms::calculateMatrixRowsNorm;
            double normMatrixRows = calculatorMatrixNorms.calculateMatrixNorm(
                    matrix);

            calculatorMatrixNorms =
                    CalculatorMatrixNorms::calculateMatrixColumnsNorm;
            double normMatrixColumns =
                    calculatorMatrixNorms.calculateMatrixNorm(matrix);

            System.out.printf(MSG_RESULT_ROWS_NORM, normMatrixRows);
            System.out.println();
            System.out.printf(MSG_RESULT_COLUMNS_NORM, normMatrixColumns);
        }, new OutputExecutionTimeToConsole());

    }

}
