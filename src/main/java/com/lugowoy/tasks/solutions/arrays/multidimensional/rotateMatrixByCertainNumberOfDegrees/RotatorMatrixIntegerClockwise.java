package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */
public interface RotatorMatrixIntegerClockwise {

    static MatrixInts rotateMatrixTo90Degrees(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        int[][] tmpMatrix = new int[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++)
            for (int j = 0; j < matrix.getColumns(); j++) {
                tmpMatrix[matrix.getColumns() - 1 - j][i] = matrix.getElement(i, j);
            }
        matrix.setMatrix(tmpMatrix);
        return matrix;
    }

    static void rotateMatrixTo180Degrees(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        rotateMatrixTo90Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo270Degrees(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        rotateMatrixTo180Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo360Degrees(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        rotateMatrixTo270Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

}
