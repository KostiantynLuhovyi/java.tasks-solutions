package com.lugowoy.tasks.solutions.arrays.multidimensional.sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn;

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
 * Sort the rows of matrix in descending order of values of the elements of k-th
 * column.
 *
 * <p>Created by Konstantin Lugowoy on 26.10.2018.
 */
public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) throws Exception {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, BOUND));

        int indexRowToSort = enterIndexRowToSort(rows);

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(
                () -> sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn(
                        matrix, indexRowToSort),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn(
            @NotNull final MatrixInts matrix, final int indexRowToSort) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int[][] ints = matrix.toMatrix(
                new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i][indexRowToSort] < ints[j][indexRowToSort]) {
                    for (int k = 0; k < ints.length; k++) {
                        int temp = ints[i][k];
                        ints[i][k] = ints[j][k];
                        ints[j][k] = temp;
                    }
                }
            }
        }
        matrix.setMatrix(ints);
        return matrix;
    }

    private static int enterIndexRowToSort(int rows) {
        int resultIndexRow;
        System.out.println("Enter the row number to sort : ");
        ReaderConsole reader = new ReaderConsole();
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
