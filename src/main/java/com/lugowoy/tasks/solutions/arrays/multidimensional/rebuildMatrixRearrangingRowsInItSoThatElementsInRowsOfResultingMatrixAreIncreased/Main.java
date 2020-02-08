package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingRowsInItSoThatElementsInRowsOfResultingMatrixAreIncreased;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Rebuild the matrix, rearranging the rows in it so that the elements in the rows of the resulting matrix are increased.
 * <p> Created by Konstantin Lugowoy on 23.11.2018.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> rebuildMatrix(matrix), ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                                      ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts rebuildMatrix(MatrixInts matrix) {
        int[][] matrixSort = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (sumLine(matrixSort, j) > sumLine(matrixSort, j + 1)) {
                    swap(matrixSort, j);
                }
            }
        }
        matrix.setMatrix(matrixSort);
        return matrix;
    }

    private static void swap(int[][] matrixSort, int indexColumn) {
        int[] tmp = matrixSort[indexColumn];
        matrixSort[indexColumn] = matrixSort[indexColumn + 1];
        matrixSort[indexColumn + 1] = tmp;
    }

    private static int sumLine(int[][] matrix, int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result = result + matrix[indexRow][i];
        }
        return result;
    }

}
