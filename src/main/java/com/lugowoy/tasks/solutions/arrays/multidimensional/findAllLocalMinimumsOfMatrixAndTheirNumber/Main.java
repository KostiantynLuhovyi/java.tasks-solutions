package com.lugowoy.tasks.solutions.arrays.multidimensional.findAllLocalMinimumsOfMatrixAndTheirNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Find all local minimums of the matrix and their number.
 *
 * <p>Created by Konstantin Lugowoy on 23.11.2018.
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
                HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(() -> findAllLocalMinimums(matrix),
                               new OutputExecutionTimeToConsole());

    }

    private static void findAllLocalMinimums(@NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int countLocalMinimum = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    System.out.println(
                            "The local minimum by the index of row " + i
                            + " and the index of column " + j
                            + " is equal to : " + matrix.getElement(i, j)
                            + " .");
                    countLocalMinimum++;
                }
            }
        }
        if (countLocalMinimum == 0) {
            System.out.println("Local minimums not found.");
        } else {
            System.out.println("Found " + countLocalMinimum
                               + " local minimals in the matrix");
        }
    }

    //todo optimize algorithm, because it is very complex implementation.
    private static boolean isLocalMinimum(@NotNull final MatrixInts matrix,
                                          final int row, final int column) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int countRowFrom = row - 1;
        int countRowFor = row + 1;
        int countColumnFrom = column - 1;
        int countColumnFor = column + 1;

        //upper left corner
        if ((row == 0) && (column == 0)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //top row of the matrix (corners)
        if ((row == 0) && (column > 0) && (column < matrix.getColumns() - 1)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //upper right corner
        if ((row == 0) && (column == matrix.getColumns() - 1)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //first column (except corner)
        if ((column == 0) && (row > 0) && (row < matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //last column of matrix (except angular)
        if ((column == matrix.getColumns() - 1) && (row > 0) && (row <
                                                                 matrix.getRows()
                                                                 - 1)) {
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //bottom left corner
        if ((column == 0) && (row == matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //bottom line of the matrix (except angular)
        if ((column > 0) && (column < matrix.getColumns() - 1) && (row ==
                                                                   matrix.getRows()
                                                                   - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //bottom right corner
        if ((row == matrix.getRows() - 1) && (column
                                              == matrix.getColumns() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }

        boolean result = true;
        for (int i = countRowFrom; i <= countRowFor; i++) {
            for (int j = countColumnFrom; j <= countColumnFor; j++) {
                if (i == row && j == column) {
                    //todo think about the implementation to get rid of the empty code block if ().
                } else if (matrix.getElement(i, j) < matrix.getElement(row,
                                                                       column)) {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }

}
