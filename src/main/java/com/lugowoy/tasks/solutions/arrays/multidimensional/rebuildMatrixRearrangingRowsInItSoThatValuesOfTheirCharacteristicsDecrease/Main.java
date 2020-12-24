package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingRowsInItSoThatValuesOfTheirCharacteristicsDecrease;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Rebuild the given matrix, rearranging the rows in it so that the values of
 * their characteristics decrease.
 *
 * <p>Created by Konstantin Lugowoy on 27.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(
                () -> rebuildMatrixBySortingRowsDescendingCharacteristics(matrix),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts rebuildMatrixBySortingRowsDescendingCharacteristics(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumRowElement(matrix, j)
                        > calculateSumRowElement(matrix, j + 1)) {
                    int[] tmp = matrix.getRowToArray(new int[matrix.getRows()], j);
                    matrix.setRowFromArray(matrix.getRowToArray(
                            new int[matrix.getRows()], j + 1), j);
                    matrix.setRowFromArray(tmp, j + 1);
                }
            }
        }
        return matrix;
    }

    private static int calculateSumRowElement(@NotNull final MatrixInts matrix,
                                              final int indexRow) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int result = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            result = result + Math.abs(matrix.getElement(indexRow, i));
        }
        return result;
    }

}
