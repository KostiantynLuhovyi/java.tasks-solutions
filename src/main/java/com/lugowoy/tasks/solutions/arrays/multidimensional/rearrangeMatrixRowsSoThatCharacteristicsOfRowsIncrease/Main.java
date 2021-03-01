package com.lugowoy.tasks.solutions.arrays.multidimensional.rearrangeMatrixRowsSoThatCharacteristicsOfRowsIncrease;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Rebuild the given matrix, rearranging the rows in it so that the values of
 * their characteristics increase.
 *
 * <p>Created by Konstantin Lugowoy on 27.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(
                () -> rebuildMatrixBySortingRowsAscendingCharacteristics(matrix),
                new OutputExecutionResultToConsole(),
                OutputExecutionResultToConsole.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts rebuildMatrixBySortingRowsAscendingCharacteristics(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumRowElement(matrix, j) < calculateSumRowElement(
                        matrix, j + 1)) {
                    int[] tmp = matrix.getRowToArray(new int[matrix.getRows()],
                                                     j);
                    matrix.setRowFromArray(
                            matrix.getRowToArray(new int[matrix.getRows()],
                                                 j + 1), j);
                    matrix.setRowFromArray(tmp, j + 1);
                }
            }
        }
        return matrix;
    }

    private static int calculateSumRowElement(@NotNull final MatrixInts matrix,
                                              final int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            result = result + Math.abs(matrix.getElement(indexRow, i));
        }
        return result;
    }

}
