package com.lugowoy.tasks.solutions.arrays.multidimensional.sortRowsInAscendingOrderOfKthColumnElements;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Sort the rows in ascending order of values of the elements of k-th column.
 *
 * <p>Created by Konstantin Lugowoy on 26.10.2018.
 */
public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_ZERO, BOUND));

        int indexRowToSort = enterIndexRowToSort(rows);

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(
                () -> sortRowsOfMatrixInAscendingOrderOfValuesOfElementsOfKthColumn(
                        matrix, indexRowToSort),
                new OutputExecutionResultToConsole(),
                OutputExecutionResultToConsole.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts sortRowsOfMatrixInAscendingOrderOfValuesOfElementsOfKthColumn(
            @NotNull final MatrixInts matrix, final int indexRowToSort) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int[][] ints = matrix.toMatrix(
                new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i][indexRowToSort] > ints[j][indexRowToSort]) {
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
