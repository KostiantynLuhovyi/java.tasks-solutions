package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixRearrangingColumnsInItSoThatValuesOfTheirCharacteristicsDecrease;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Rebuild the given matrix, rearranging the columns in it so that the values of their characteristics decrease.
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

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rebuildMatrixBySortingColumnDescendingCharacteristics(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void rebuildMatrixBySortingColumnDescendingCharacteristics(MatrixInts matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumColumnElement(matrix, j) > calculateSumColumnElement(matrix, j + 1)) {
                    int[] tmp = matrix.getColumnToArray(new int[matrix.getColumns()], j);
                    matrix.setColumnFromArray(matrix.getColumnToArray(new int[matrix.getColumns()], j + 1), j);
                    matrix.setColumnFromArray(tmp, j + 1);
                }
            }
        }
    }

    private static int calculateSumColumnElement(MatrixInts matrix, int indexColumn) {
        int result = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            result = result + Math.abs(matrix.getElement(i, indexColumn));
        }
        return result;
    }

}
