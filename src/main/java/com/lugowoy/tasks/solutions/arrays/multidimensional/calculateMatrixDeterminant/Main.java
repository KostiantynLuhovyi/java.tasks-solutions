package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static java.lang.Math.pow;

/**
 * Calculate the matrix determinant.
 * <p> Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final String MSG_OUTPUT_RESULT = "Matrix determinant : %.3f\n";

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println(matrix);
        System.out.println();

        Executor.execute(() -> calculateMatrixDeterminant(matrix),
                                      ExecutionResultOutputToConsole::outputExecutionResultToConsole, MSG_OUTPUT_RESULT,
                                      ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static double calculateMatrixDeterminant(MatrixInts matrix) {
        MatrixInts tmpMatrix;
        double resultMatrixDeterminant = 0;
        if (matrix.getRows() == 1) {
            resultMatrixDeterminant = matrix.getElement(0, 0);
            return resultMatrixDeterminant;
        }
        if (matrix.getRows() == 2) {
            resultMatrixDeterminant = (matrix.getElement(0, 0) * matrix.getElement(1, 1))
                                            - (matrix.getElement(0, 1) * matrix.getElement(1, 0));
            return resultMatrixDeterminant;
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            tmpMatrix = new MatrixInts(matrix.getRows() - 1, matrix.getColumns() - 1);
            for (int j = 1; j < matrix.getRows(); j++) {
                for (int k = 0; k < matrix.getColumns(); k++) {
                    if (k < i) {
                        tmpMatrix.setElement(j - 1, k, matrix.getElement(j, k));
                    } else if (k > i) {
                        tmpMatrix.setElement(j - 1, k - 1, matrix.getElement(j, k));
                    }
                }
            }
            resultMatrixDeterminant += matrix.getElement(0, i) * pow(-1, i) * calculateMatrixDeterminant(tmpMatrix);
        }
        return resultMatrixDeterminant;
    }

}
