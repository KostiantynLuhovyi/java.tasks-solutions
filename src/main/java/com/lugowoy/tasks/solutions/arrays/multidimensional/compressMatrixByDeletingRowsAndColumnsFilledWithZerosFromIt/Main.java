package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByDeletingRowsAndColumnsFilledWithZerosFromIt;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Compress the matrix by deleting rows and columns filled with zeros from it.
 * <p> Created by Konstantin Lugowoy on 01.11.2018.
 */
public class Main {

    private static final int UPPER_BOUND = 1;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, UPPER_BOUND));

        System.out.println(matrix);

        Executor.execute(() -> compressMatrix(matrix), ExecutionResultOutputToConsole::outputExecutionResultToConsole,
                                                       RESULT_MATRIX, ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts compressMatrix(MatrixInts matrix) {
        //todo Consider the solution to this problem using one cycle.
        for (int i = 0; i < matrix.getRows(); i++) {
            int indexRowZeros = getIndexRowFilledZeros(matrix, i);
            if (indexRowZeros != -1) {
                matrix.compressRow(indexRowZeros);
                --i;
            }
        }
        for (int i = 0; i < matrix.getColumns(); i++) {
            int indexColumnZeros = getIndexColumnFilledZeros(matrix, i);
            if (indexColumnZeros != -1) {
                matrix.compressColumn(indexColumnZeros);
                --i;
            }
        }
        return matrix;
    }

    private static int getIndexColumnFilledZeros(MatrixInts matrix, int indexRow) {
        int resultIndexRow = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            if (matrix.getElement(indexRow, i) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getColumns()) {
            resultIndexRow = indexRow;
        }
        return resultIndexRow;
    }

    private static int getIndexRowFilledZeros(MatrixInts matrix, int indexColumn) {
        int resultIndexColumn = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, indexColumn) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getRows()) {
            resultIndexColumn = indexColumn;
        }
        return resultIndexColumn;
    }

}
