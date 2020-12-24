package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */
public class ShifterMatrixPrimitiveInteger {

    public static void shiftMatrixToRight(@NotNull final MatrixInts matrix,
                                          final int numberToShiftMatrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
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

    public static void shiftMatrixToLeft(@NotNull final MatrixInts matrix,
                                         final int numberToShiftMatrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
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

    public static void shiftMatrixToUp(@NotNull final MatrixInts matrix,
                                       final int numberToShiftMatrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
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

    public static void shiftMatrixToDown(@NotNull final MatrixInts matrix,
                                         final int numberToShiftMatrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
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
