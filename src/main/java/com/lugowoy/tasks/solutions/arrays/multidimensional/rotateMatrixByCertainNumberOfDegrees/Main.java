package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Rotation of the matrix by a certain number of degrees.
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
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

        RotatorMatrix rotatorMatrix = RotatorIntegerMatrixClockwise::rotateMatrixTo90Degrees;
        rotatorMatrix.rotateMatrix(matrix);

        System.out.println("Result to rotate matrix clockwise to 90 degrees : ");
        System.out.println(matrix);

    }

}
