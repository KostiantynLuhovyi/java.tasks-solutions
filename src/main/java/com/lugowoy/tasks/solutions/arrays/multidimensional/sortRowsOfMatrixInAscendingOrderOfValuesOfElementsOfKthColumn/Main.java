package com.lugowoy.tasks.solutions.arrays.multidimensional.sortRowsOfMatrixInAscendingOrderOfValuesOfElementsOfKthColumn;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Sort the rows in ascending order of values of the elements of k-th column.
 * <p> Created by Konstantin Lugowoy on 26.10.2018.
 */
public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, BOUND));

        int indexRowToSort = enterIndexRowToSort(rows);

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> sortRowsOfMatrixInAscendingOrderOfValuesOfElementsOfKthColumn(matrix, indexRowToSort),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts sortRowsOfMatrixInAscendingOrderOfValuesOfElementsOfKthColumn(MatrixInts matrix, int indexRowToSort) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
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
