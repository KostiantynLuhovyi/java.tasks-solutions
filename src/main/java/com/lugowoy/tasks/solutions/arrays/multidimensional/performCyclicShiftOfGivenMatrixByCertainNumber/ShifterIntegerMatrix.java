package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

public class ShifterIntegerMatrix {

    public static void shiftMatrixToRight(MatrixInts matrix, int numberToShiftMatrix) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < ints.length; j++) {
                int tmpBuffer = ints[j][ints.length - 1];
                for (k = ints.length - 1; k > 0; k--) {
                    ints[j][k] = ints[j][k - 1];
                }
                ints[j][k] = tmpBuffer;
            }
        }
        matrix.setMatrix(ints);
    }

    public static void shiftMatrixToLeft(MatrixInts matrix, int numberToShiftMatrix) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < ints.length; j++) {
                int tmpBuffer = ints[j][0];
                for (k = 0; k < ints.length - 1; k++) {
                    ints[j][k] = ints[j][k + 1];
                }
                ints[j][k] = tmpBuffer;
            }
        }
        matrix.setMatrix(ints);
    }

    public static void shiftMatrixToUp(MatrixInts matrix, int numberToShiftMatrix) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < ints.length; j++) {
                int tmpBuffer = ints[0][j];
                for (k = 0; k < ints.length - 1; k++) {
                    ints[k][j] = ints[k + 1][j];
                }
                ints[k][j] = tmpBuffer;
            }
        }
        matrix.setMatrix(ints);
    }

    public static void shiftMatrixToDown(MatrixInts matrix, int numberToShiftMatrix) {
        int[][] ints = matrix.toMatrix(new int[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < ints.length; j++) {
                int tmpBuffer = ints[ints.length - 1][j];
                for (k = ints.length - 1; k > 0; k--) {
                    ints[k][j] = ints[k - 1][j];
                }
                ints[k][j] = tmpBuffer;
            }
        }
        matrix.setMatrix(ints);
    }

}
