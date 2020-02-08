package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingRowsInItSoThatValuesOfTheirCharacteristicsDecrease;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Rebuild the given matrix, rearranging the rows in it so that the values of their characteristics decrease.
 * <p> Created by Konstantin Lugowoy on 27.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> rebuildMatrixBySortingRowsDescendingCharacteristics(matrix),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts rebuildMatrixBySortingRowsDescendingCharacteristics(MatrixInts matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumRowElement(matrix, j) > calculateSumRowElement(matrix, j + 1)) {
                    int[] tmp = matrix.getRowToArray(new int[matrix.getRows()], j);
                    matrix.setRowFromArray(matrix.getRowToArray(new int[matrix.getRows()], j + 1), j);
                    matrix.setRowFromArray(tmp, j + 1);
                }
            }
        }
        return matrix;
    }

    private static int calculateSumRowElement(MatrixInts matrix, int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            result = result + Math.abs(matrix.getElement(indexRow, i));
        }
        return result;
    }

}
