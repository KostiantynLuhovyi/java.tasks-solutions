package com.lugowoy.tasks.solutions.arrays.multidimensional.removeFromMatrixAllRowsAndColumnsContainingMaximumElement;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Find the maximum element(s) in the matrix and remove from the matrix all the rows and columns containing it.
 * <p> Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);


        IndexMaximumMatrixElement indexMax = new IndexMaximumMatrixElement(matrix);
        indexMax.setIndexesMatrixRowAndColumn();

        Executor.execute(() -> removeFromMatrixAllRowsAndColumnsContainingMaximumElement(matrix, indexMax.indexMaxElementMatrixRow,
                                                                                                 indexMax.indexMaxElementMatrixColumn),
                               ExecutionResultOutputToConsole::outputExecutionResultToConsole, Helper.RESULT_MATRIX,
                               ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixInts removeFromMatrixAllRowsAndColumnsContainingMaximumElement(MatrixInts matrix, int indexMatrixRow,
                                                                                                     int indexMatrixColumn) {
        int[][] tmpInts = new int[matrix.getRows() - 1][matrix.getColumns() - 1];
        int row = 0;
        for (int i = 0; i < matrix.getRows() - 1; i++) {
            if (i > indexMatrixRow - 1) {
                row = 1;
            }
            int column = 0;
            for (int j = 0; j < matrix.getColumns() - 1; j++) {
                if (j > indexMatrixColumn - 1) {
                    column = 1;
                }
                tmpInts[i][j] = matrix.getElement(i + row, j + column);
            }
        }
        matrix.setMatrix(tmpInts);
        return matrix;
    }

    private static class IndexMaximumMatrixElement {

        private MatrixInts matrix;

        private int indexMaxElementMatrixRow;
        private int indexMaxElementMatrixColumn;

        private IndexMaximumMatrixElement(MatrixInts matrix) {
            this.matrix = matrix;
        }

        private void setIndexesMatrixRowAndColumn() {
            int resultMaxElement = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int elementOfMatrix = matrix.getElement(i, j);
                    if (elementOfMatrix > resultMaxElement) {
                        this.indexMaxElementMatrixRow = i;
                        this.indexMaxElementMatrixColumn = j;
                        resultMaxElement = elementOfMatrix;
                    }
                }
            }
        }

    }

}
