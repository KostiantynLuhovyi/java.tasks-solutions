package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Rotation of the matrix by a certain number of degrees.
 *
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        RotatorMatrix rotatorMatrix
                = RotatorMatrixIntegerClockwise::rotateMatrixTo90Degrees;

        Helper.EXECUTOR.execute(() -> rotatorMatrix.rotateMatrix(matrix),
                                new OutputExecutionResultToConsole(),
                                Helper.RESULT_MATRIX,
                                new OutputExecutionTimeToConsole());

    }

}
