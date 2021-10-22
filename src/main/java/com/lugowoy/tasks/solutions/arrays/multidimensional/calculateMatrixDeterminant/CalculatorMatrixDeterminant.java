package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.Math.pow;

/**
 * <p>Created by Konstantin Lugowoy on 22.10.2021.
 */
@FunctionalInterface
public interface CalculatorMatrixDeterminant<T extends Number, M extends AbstractMatrix> {

    T calculate(@NotNull final M matrix);

    static double calculateDeterminantMatrix(@NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        MatrixInts tmpMatrix;
        double resultDeterminant = 0;
        resultDeterminant = calculateDeterminantMatrixWithOneRow(matrix);
        resultDeterminant = calculateDeterminantMatrixWithTwoRows(matrix);
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
            resultDeterminant += matrix.getElement(0, i) * pow(-1, i)
                                 * calculateDeterminantMatrix(tmpMatrix);
        }
        return resultDeterminant;
    }

    private static double calculateDeterminantMatrixWithOneRow(@NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        double result = 0;
        if (matrix.getRows() == 1) {
            result = matrix.getElement(0, 0);
        }
        return result;
    }

    private static double calculateDeterminantMatrixWithTwoRows(@NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        double result = 0;
        if (matrix.getRows() == 2) {
            result = (matrix.getElement(0, 0) * matrix.getElement(1, 1))
                     - (matrix.getElement(0, 1) * matrix.getElement(1, 0));
        }
        return result;
    }

}
