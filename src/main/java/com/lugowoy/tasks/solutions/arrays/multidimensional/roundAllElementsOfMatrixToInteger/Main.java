package com.lugowoy.tasks.solutions.arrays.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Round all elements of the matrix to an integer.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final double BOUND = 20.0;

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveDoubles filler = new FillingMatrixRandomPrimitiveDoubles();

        MatrixDoubles matrix = new MatrixDoubles(filler.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        MatrixInts integerMatrix = new MatrixInts(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                integerMatrix.setElement(i, j, (int) Math.round(matrix.getElement(i, j)));
            }
        }

        System.out.println("Result matrix : ");
        System.out.println(integerMatrix);

    }

}
