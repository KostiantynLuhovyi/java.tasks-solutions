package com.lugowoy.tasks.solutions.arrays.multidimensional.findNumberOfAllSaddlePointsOfMatrix;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Find the number of all saddle points of the matrix.
 * <p> Created by Konstantin Lugowoy on 07.11.2018.
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

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findSaddleNumbersOfMatrix(matrix);

    }

    private static void findSaddleNumbersOfMatrix(MatrixInts matrix) {
        int counterResult = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (isMinElementInRow(matrix, i, element) && isMaxElementInColumn(matrix, j, element)) {
                    System.out.println("Saddle value under the row index : " + i + " and column index :" + j + " equals : " + element);
                    counterResult++;
                }
            }
        }
        if (counterResult == 0) {
            System.out.println("Matrix does not contain saddle values.");
        }
    }

    private static boolean isMinElementInRow(MatrixInts matrix, int indexRow, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getColumns(); i++) {
            int element = matrix.getElement(indexRow, i);
            if (element < valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isMaxElementInColumn(MatrixInts matrix, int indexColumn, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getRows(); i++) {
            int element = matrix.getElement(i, indexColumn);
            if (element > valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

}
