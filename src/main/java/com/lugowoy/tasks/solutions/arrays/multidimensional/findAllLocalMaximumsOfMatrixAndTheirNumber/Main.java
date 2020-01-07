package com.lugowoy.tasks.solutions.arrays.multidimensional.findAllLocalMaximumsOfMatrixAndTheirNumber;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Find all local maximums of the matrix and their number.
 * <p> Created by Konstantin Lugowoy on 26.11.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findAllLocalMaximumsOfMatrixAndTheirNumber(matrix);

    }

    private static void findAllLocalMaximumsOfMatrixAndTheirNumber(MatrixInts matrix) {
        int countLocalMaximum = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (isLocalMaximum(matrix, i, j)) {
                    System.out.println("The local maximum by the index of row " + i
                            + " and the index of column " + j
                            + " is equal to : " + matrix.getElement(i, j) + " .");
                    countLocalMaximum++;
                }
            }
        }
        if (countLocalMaximum == 0) {
            System.out.println("Local maximums not found.");
        } else {
            System.out.println("Found " + countLocalMaximum + " local maximums in the matrix");
        }
    }

    //todo optimize algorithm, because it is very complex implementation.
    private static boolean isLocalMaximum(MatrixInts matrix, int row, int column) {
        int countRowFrom = row - 1;
        int countRowFor = row + 1;
        int countColumnFrom = column - 1;
        int countColumnFor = column + 1;

        //upper left corner
        if ((row == 0) && (column == 0)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //top row of the matrix (corners)
        if ((row == 0) && (column > 0) && (column < matrix.getColumns() - 1)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //upper right corner
        if ((row == 0) && (column == matrix.getColumns() - 1)) {
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //first column (except corner)
        if ((column == 0) && (row > 0) && (row < matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //last column of matrix (except angular)
        if ((column == matrix.getColumns() - 1) && (row > 0) && (row < matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //bottom left corner
        if ((column == 0) && (row == matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //bottom line of the matrix (except angular)
        if ((column > 0) && (column < matrix.getColumns() - 1) && (row == matrix.getRows() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //bottom right corner
        if ((row == matrix.getRows() - 1) && (column == matrix.getColumns() - 1)) {
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }

        boolean result = true;
        for (int i = countRowFrom; i <= countRowFor; i++) {
            for (int j = countColumnFrom; j <= countColumnFor; j++) {
                if (i == row && j == column) {
                    //todo think about the implementation to get rid of the empty code block if ().
                } else if (matrix.getElement(i, j) >= matrix.getElement(row, column)) {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }

}
