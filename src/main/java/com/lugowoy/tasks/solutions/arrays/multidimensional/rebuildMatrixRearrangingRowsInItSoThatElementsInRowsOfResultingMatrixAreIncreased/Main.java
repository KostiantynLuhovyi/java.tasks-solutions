package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingRowsInItSoThatElementsInRowsOfResultingMatrixAreIncreased;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.lugowoy.tasks.solutions.helper.Helper.RESULT_MATRIX;

/**
 * Rebuild the matrix, rearranging the rows in it so that the elements in the
 * rows of the resulting matrix are increased.
 *
 * <p>Created by Konstantin Lugowoy on 23.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, HelperFiller.INT_POSITIVE_HUNDRED));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> rebuildMatrix(matrix),
                                new OutputExecutionResultToConsole(), RESULT_MATRIX,
                                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts rebuildMatrix(@NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int[][] matrixSort = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (sumLine(matrixSort, j) > sumLine(matrixSort, j + 1)) {
                    swap(matrixSort, j);
                }
            }
        }
        matrix.setMatrix(matrixSort);
        return matrix;
    }

    private static void swap(int[][] matrixSort, int indexColumn) {
        int[] tmp = matrixSort[indexColumn];
        matrixSort[indexColumn] = matrixSort[indexColumn + 1];
        matrixSort[indexColumn + 1] = tmp;
    }

    private static int sumLine(int[][] matrix, int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result = result + matrix[indexRow][i];
        }
        return result;
    }

}
