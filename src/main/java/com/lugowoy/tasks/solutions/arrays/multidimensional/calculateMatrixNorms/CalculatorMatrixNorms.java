package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
@FunctionalInterface
public interface CalculatorMatrixNorms {

    double calculate(@NotNull final MatrixDoubles matrix);

    static double calculateNormMatrixColumns(@NotNull final MatrixDoubles matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        double resultNormColumns = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += Math.abs(matrix.getElement(i, j));
            }
            resultNormColumns = Math.max(resultNormColumns, sum);
        }
        return resultNormColumns;
    }

    static double calculateNormMatrixRows(@NotNull final MatrixDoubles matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        double resultRowsNorm = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += Math.abs(matrix.getElement(j, i));
            }
            resultRowsNorm = Math.max(resultRowsNorm, sum);
        }
        return resultRowsNorm;
    }

}
