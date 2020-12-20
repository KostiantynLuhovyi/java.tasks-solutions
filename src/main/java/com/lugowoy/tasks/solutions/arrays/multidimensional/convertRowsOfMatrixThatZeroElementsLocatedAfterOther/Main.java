package com.lugowoy.tasks.solutions.arrays.multidimensional.convertRowsOfMatrixThatZeroElementsLocatedAfterOther;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Convert the rows of the matrix so that the elements equal to zero are located
 * after all the others.
 *
 * <p>Created by Konstantin Lugowoy on 06.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Original matrix :\n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> convertRowsOfMatrixThatZeroLocatedAfterOther(matrix),
                                new OutputExecutionResultToConsole(),
                                Helper.RESULT_MATRIX,
                                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts convertRowsOfMatrixThatZeroLocatedAfterOther(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int indexElementOfRow = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            int[] tmp = new int[matrix.getRows()];
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element != 0) {
                    tmp[indexElementOfRow] = element;
                } else {
                    continue;
                }
                indexElementOfRow++;
            }
            matrix.setRowFromArray(tmp, i);
            indexElementOfRow = 0;
        }
        return matrix;
    }

}
