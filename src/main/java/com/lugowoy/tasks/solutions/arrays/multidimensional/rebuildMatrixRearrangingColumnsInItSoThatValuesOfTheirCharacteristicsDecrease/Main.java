package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingColumnsInItSoThatValuesOfTheirCharacteristicsDecrease;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Rebuild the given matrix, rearranging the columns in it so that the values of their characteristics decrease.
 * <p> Created by Konstantin Lugowoy on 26.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> rebuildMatrixBySortingColumnDescendingCharacteristics(matrix),
                                   ExecutionResultOutputToConsole::outputExecutionResultToConsole, Helper.RESULT_MATRIX,
                                   ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts rebuildMatrixBySortingColumnDescendingCharacteristics(MatrixInts matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumColumnElement(matrix, j) > calculateSumColumnElement(matrix, j + 1)) {
                    int[] tmp = matrix.getColumnToArray(new int[matrix.getColumns()], j);
                    matrix.setColumnFromArray(matrix.getColumnToArray(new int[matrix.getColumns()], j + 1), j);
                    matrix.setColumnFromArray(tmp, j + 1);
                }
            }
        }
        return matrix;
    }

    private static int calculateSumColumnElement(MatrixInts matrix, int indexColumn) {
        int result = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            result = result + Math.abs(matrix.getElement(i, indexColumn));
        }
        return result;
    }

}
