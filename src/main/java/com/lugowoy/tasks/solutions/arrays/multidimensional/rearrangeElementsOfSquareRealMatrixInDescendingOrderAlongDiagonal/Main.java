package com.lugowoy.tasks.solutions.arrays.multidimensional.rearrangeElementsOfSquareRealMatrixInDescendingOrderAlongDiagonal;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Rearrange the elements of a square real matrix in descending order along the diagonal.
 * <p> Created by Konstantin Lugowoy on 28.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        FillingMatrixRandomPrimitiveDoubles filler = new FillingMatrixRandomPrimitiveDoubles();

        MatrixDoubles matrix = new MatrixDoubles(filler.fill(rows, columns, DOUBLE_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> rearrangeElementsOfMatrixInDescendingOrderAlongDiagonal(matrix),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static AbstractMatrix rearrangeElementsOfMatrixInDescendingOrderAlongDiagonal(MatrixDoubles matrix) {
        int length = matrix.getRows();
        for (int n = 0; n < length; n++) {
            int row = 0, col = 0;
            double maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    double element = matrix.getElement(i, j);
                    if (i != j || i > n) {
                        if (element > maxValue) {
                            maxValue = element;
                            row = i;
                            col = j;
                        }
                    }
                }
                double tmp = matrix.getElement(n, n);
                matrix.setElement(n, n, matrix.getElement(row, col));
                matrix.setElement(row, col, tmp);
            }
        }
        return matrix;
    }

}