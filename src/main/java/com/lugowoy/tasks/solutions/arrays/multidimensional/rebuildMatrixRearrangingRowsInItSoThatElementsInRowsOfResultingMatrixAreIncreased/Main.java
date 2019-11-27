package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingRowsInItSoThatElementsInRowsOfResultingMatrixAreIncreased;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Rebuild the matrix, rearranging the rows in it so that the elements in the rows of the resulting matrix are increased.
 * <p>
 * Created by Konstantin Lugowoy on 23.11.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rebuildMatrix(matrix);

        System.out.println("Result of rebuilding the matrix : ");
        System.out.println(matrix);

    }

    private static void swap(int[][] matrixSort, int indexColumn) {
        int[] tmp = matrixSort[indexColumn];
        matrixSort[indexColumn] = matrixSort[indexColumn + 1];
        matrixSort[indexColumn + 1] = tmp;
    }

    private static void rebuildMatrix(MatrixInts matrix) {
        int[][] matrixSort = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (sumLine(matrixSort, j) > sumLine(matrixSort, j + 1)) {
                    swap(matrixSort, j);
                }
            }
        }
        matrix.setMatrix(matrixSort);
    }

    private static int sumLine(int[][] matrix, int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result = result + matrix[indexRow][i];
        }
        return result;
    }

}
