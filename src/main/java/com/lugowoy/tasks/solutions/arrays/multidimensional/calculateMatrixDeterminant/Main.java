package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.Math.pow;

/**
 * Calculate the matrix determinant.
 *
 * <p>Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final String MSG_DETERMINANT_RESULT =
            "Matrix determinant : %.3f\n";

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_NEGATIVE_THOUSAND,
                HelperFiller.INT_POSITIVE_THOUSAND));

        System.out.println("Matrix :\n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> calculateDeterminantOfMatrix(matrix),
                                new OutputExecutionResultToConsole(),
                                MSG_DETERMINANT_RESULT,
                                new OutputExecutionTimeToConsole());

    }

    private static double calculateDeterminantOfMatrix(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        MatrixInts tmpMatrix;
        double resultMatrixDeterminant = 0;
        resultMatrixDeterminant = calculateDeterminantMatrixWithOneRow(matrix);
        resultMatrixDeterminant = calculateDeterminantMatrixWithTwoRows(matrix);
        for (int i = 0; i < matrix.getRows(); i++) {
            tmpMatrix = new MatrixInts(matrix.getRows() - 1,
                                       matrix.getColumns() - 1);
            for (int j = 1; j < matrix.getRows(); j++) {
                for (int k = 0; k < matrix.getColumns(); k++) {
                    if (k < i) {
                        tmpMatrix.setElement(j - 1, k, matrix.getElement(j, k));
                    } else if (k > i) {
                        tmpMatrix.setElement(j - 1, k - 1,
                                             matrix.getElement(j, k));
                    }
                }
            }
            resultMatrixDeterminant += matrix.getElement(0, i) * pow(-1, i)
                                       * calculateDeterminantOfMatrix(tmpMatrix);
        }
        return resultMatrixDeterminant;
    }

    private static double calculateDeterminantMatrixWithOneRow(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        double result = 0;
        if (matrix.getRows() == 1) {
            result = matrix.getElement(0, 0);
        }
        return result;
    }

    private static double calculateDeterminantMatrixWithTwoRows(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        double result = 0;
        if (matrix.getRows() == 2) {
            result = (matrix.getElement(0, 0) * matrix.getElement(1, 1)) - (
                    matrix.getElement(0, 1) * matrix.getElement(1, 0));
        }
        return result;
    }

}
