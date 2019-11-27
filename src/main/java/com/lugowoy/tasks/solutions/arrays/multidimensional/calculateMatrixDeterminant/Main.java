package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.Executor;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MILLISECONDS;
import static java.lang.Math.pow;

/**
 * Calculate the matrix determinant.
 *
 * <p> Created by Konstantin Lugowoy on 31.10.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final String MSG_OUTPUT_RESULT = "Matrix determinant : %.3f";

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> calculateMatrixDeterminant(matrix), MSG_MILLISECONDS, MSG_OUTPUT_RESULT);

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
