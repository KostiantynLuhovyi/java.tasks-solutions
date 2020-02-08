package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Rotation of the matrix by a certain number of degrees.
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        RotatorMatrix rotatorMatrix = RotatorIntegerMatrixClockwise::rotateMatrixTo90Degrees;

        Executor.execute(() -> rotatorMatrix.rotateMatrix(matrix), ExecutionResultOutputToConsole::outputExecutionResultToConsole,
                                                                    RESULT_MATRIX, ExecutionTimeOutputToConsole::outputExecutionTime);

    }

}
