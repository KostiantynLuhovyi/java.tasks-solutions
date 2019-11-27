package com.lugowoy.tasks.solutions.arrays.multidimensional.sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Sort the columns in descending order of values of the elements of k-th row.
 * <p>
 * Created by Konstantin Lugowoy on 27.10.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, UPPER_BOUND));

        int indexColumnToSort = enterIndexColumnToSort(matrix.getColumns());

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(matrix, indexColumnToSort);

        System.out.println("Result : ");
        System.out.println(matrix);

    }

    private static void sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(MatrixInts matrix, int indexColumnToSort) {
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
