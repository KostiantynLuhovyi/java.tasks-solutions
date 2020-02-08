package com.lugowoy.tasks.solutions.arrays.multidimensional.sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Sort the columns in descending order of values of the elements of k-th row.
 * <p> Created by Konstantin Lugowoy on 27.10.2018.
 */

public class Main {

    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, UPPER_BOUND));

        int indexColumnToSort = enterIndexColumnToSort(matrix.getColumns());

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(matrix, indexColumnToSort),
                                   ExecutionResultOutputToConsole::outputExecutionResultToConsole, Helper.RESULT_MATRIX,
                                   ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(MatrixInts matrix, int indexColumnToSort) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length - 1; j++) {
                if (ints[indexColumnToSort][j + 1] > ints[indexColumnToSort][j]) {
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

    private static int enterIndexColumnToSort(int rows) {
        int resultIndexRow;
        System.out.println("Enter the column number to sort : ");
        Reader reader = new Reader(new ReadingConsole());
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
