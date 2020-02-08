package com.lugowoy.tasks.solutions.arrays.multidimensional.convertRowsOfMatrixSoThatElementsEqualToZeroLocatedAfterAllOthers;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Convert the rows of the matrix so that the elements equal to zero are located after all the others.
 * <p> Created by Konstantin Lugowoy on 06.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> convertRowsOfMatrixSoThatZeroElementsLocatedAfterOther(matrix),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts convertRowsOfMatrixSoThatZeroElementsLocatedAfterOther(MatrixInts matrix) {
        int indexElementOfRow = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            int[] tmp = new int[matrix.getRows()];
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element != 0) {
                    tmp[indexElementOfRow] = element;
                } else {
                    continue;
                }
                indexElementOfRow++;
            }
            matrix.setRowFromArray(tmp, i);
            indexElementOfRow = 0;
        }
        return matrix;
    }

}
