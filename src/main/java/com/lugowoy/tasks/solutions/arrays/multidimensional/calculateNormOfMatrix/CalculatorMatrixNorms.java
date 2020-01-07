package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateNormOfMatrix;

import com.lugowoy.helper.models.matrices.MatrixDoubles;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

@FunctionalInterface
public interface CalculatorMatrixNorms {

    double calculateMatrixNorm(MatrixDoubles matrix);

    static double calculateMatrixColumnsNorm(MatrixDoubles matrix) {
        double resultNorm = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += Math.abs(matrix.getElement(i, j));
            }
            resultNorm = Math.max(resultNorm, sum);
        }
        return resultNorm;
    }

    static double calculateMatrixRowsNorm(MatrixDoubles matrix) {
        double resultNorm = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += Math.abs(matrix.getElement(j, i));
            }
            resultNorm = Math.max(resultNorm, sum);
        }
        return resultNorm;
    }

}
