package com.lugowoy.tasks.solutions.arrays.multidimensional.rearrangeElementsOfSquareRealMatrixInDescendingOrderAlongDiagonal;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

import static com.lugowoy.tasks.solutions.helper.Helper.RESULT_MATRIX;

/**
 * Rearrange the elements of a square real matrix in descending order along the
 * diagonal.
 *
 * <p>Created by Konstantin Lugowoy on 28.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixDoubles matrix = new MatrixDoubles(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFiller.DOUBLE_ZERO, HelperFiller.DOUBLE_POSITIVE_TEN));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Helper.EXECUTOR.execute(
                () -> rearrangeMatrixInDescendingOrderAlongDiagonal(matrix),
                new OutputExecutionResultToConsole(), RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixDoubles rearrangeMatrixInDescendingOrderAlongDiagonal(
            @NotNull final MatrixDoubles matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
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
                matrix.setElement(matrix.getElement(row, col), n, n);
                matrix.setElement(tmp, row, col);
            }
        }
        return matrix;
    }

}