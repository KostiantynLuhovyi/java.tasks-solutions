package com.lugowoy.tasks.solutions.arrays.multidimensional.removeFromMatrixAllRowsAndColumnsContainingMaximumElement;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Find the maximum element(s) in the matrix and remove from the matrix all the rows and columns containing it.
 * <p> Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);


        IndexMaximumMatrixElement indexMax = new IndexMaximumMatrixElement(matrix);
        indexMax.setIndexesMatrixRowAndColumn();

        removeFromMatrixAllRowsAndColumnsContainingMaximumElement(matrix, indexMax.indexMaxElementMatrixRow,
                                                                          indexMax.indexMaxElementMatrixColumn);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void removeFromMatrixAllRowsAndColumnsContainingMaximumElement(MatrixInts matrix, int indexMatrixRow,
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
