package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */
public interface RotatorIntegerMatrixClockwise {

    static MatrixInts rotateMatrixTo90Degrees(MatrixInts matrix) {
        int[][] tmpMatrix = new int[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++)
            for (int j = 0; j < matrix.getColumns(); j++) {
                tmpMatrix[matrix.getColumns() - 1 - j][i] = matrix.getElement(i, j);
            }
        matrix.setMatrix(tmpMatrix);
        return matrix;
    }

    static void rotateMatrixTo180Degrees(MatrixInts matrix) {
        rotateMatrixTo90Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo270Degrees(MatrixInts matrix) {
        rotateMatrixTo180Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo360Degrees(MatrixInts matrix) {
        rotateMatrixTo270Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

}
