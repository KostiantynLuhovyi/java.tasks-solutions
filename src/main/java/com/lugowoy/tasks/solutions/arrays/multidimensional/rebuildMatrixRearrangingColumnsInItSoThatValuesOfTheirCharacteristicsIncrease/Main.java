package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingColumnsInItSoThatValuesOfTheirCharacteristicsIncrease;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Rebuild the given matrix, rearranging the columns in it so that the values of
 * their characteristics increase.
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
                () -> rebuildMatrixBySortingColumnsAscendingCharacteristics(matrix),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts rebuildMatrixBySortingColumnsAscendingCharacteristics(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumColumnElement(matrix, j)
                        < calculateSumColumnElement(matrix, j + 1)) {
                    int[] tmp = matrix.getColumnToArray(
                            new int[matrix.getColumns()], j);
                    matrix.setColumnFromArray(matrix.getColumnToArray(
                            new int[matrix.getColumns()], j + 1), j);
                    matrix.setColumnFromArray(tmp, j + 1);
                }
            }
        }
        return matrix;
    }

    private static int calculateSumColumnElement(@NotNull final MatrixInts matrix,
                                                 final int indexColumn) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int result = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            result = result + Math.abs(matrix.getElement(i, indexColumn));
        }
        return result;
    }

}
