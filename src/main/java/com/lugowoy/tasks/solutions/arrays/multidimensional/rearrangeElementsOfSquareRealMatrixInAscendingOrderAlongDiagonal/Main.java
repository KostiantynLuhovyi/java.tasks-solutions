package com.lugowoy.tasks.solutions.arrays.multidimensional.rearrangeElementsOfSquareRealMatrixInAscendingOrderAlongDiagonal;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;

/**
 * Rearrange the elements of a square real matrix in ascending order along the diagonal.
 * <p> Created by Konstantin Lugowoy on 29.11.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveDoubles filler = new FillingMatrixRandomPrimitiveDoubles();

        MatrixDoubles matrix = new MatrixDoubles(filler.fill(rows, columns, DOUBLE_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rearrangeElementsOfMatrixInAscendingOrderAlongDiagonal(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void rearrangeElementsOfMatrixInAscendingOrderAlongDiagonal(MatrixDoubles matrix) {
        int length = matrix.getRows();
        for (int n = 0; n < length; n++) {
            int row = 0, col = 0;
            double maxValue = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    double element = matrix.getElement(i, j);
                    if (i != j || i > n) {
                        if (element < maxValue) {
                            maxValue = element;
                            row = i;
                            col = j;
                        }
                    }
                }
                double tmp = matrix.getElement(n, n);
                matrix.setElement(n, n, matrix.getElement(row, col));
                matrix.setElement(row, col, tmp);
            }
        }
    }

}
