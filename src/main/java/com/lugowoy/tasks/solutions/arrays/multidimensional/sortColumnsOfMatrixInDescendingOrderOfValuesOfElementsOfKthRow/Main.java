package com.lugowoy.tasks.solutions.arrays.multidimensional.sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Sort the columns in descending order of values of the elements of k-th row.
 *
 * <p>Created by Konstantin Lugowoy on 27.10.2018.
 */

public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, BOUND));

        int indexColumnToSort = enterIndexColumnToSort(matrix.getColumns());

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(
                () -> sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(
                        matrix, indexColumnToSort),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(
            @NotNull final MatrixInts matrix, final int indexColumnToSort) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length - 1; j++) {
                if (ints[indexColumnToSort][j + 1]
                        > ints[indexColumnToSort][j]) {
                    for (int k = 0; k < ints[i].length; k++) {
                        int tmp = ints[k][j];
                        ints[k][j] = ints[k][j + 1];
                        ints[k][j + 1] = tmp;
                    }
                }
            }
        }
        matrix.setMatrix(ints);
        return matrix;
    }

    private static int enterIndexColumnToSort(final int rows) {
        int resultIndexRow;
        ReaderConsole reader = new ReaderConsole();
        System.out.println("Enter the column number to sort : ");
        while (true) {
            resultIndexRow = reader.readInt();
            if (resultIndexRow >= 0 && resultIndexRow <= rows) {
                break;
            } else {
                System.out.println("Incorrect number. Re-enter : ");
            }
        }
        return resultIndexRow;
    }

}
