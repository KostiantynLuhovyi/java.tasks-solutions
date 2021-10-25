package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByDeletingRowsAndColumnsWithZeros;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 22.10.2021.
 */
@FunctionalInterface
public interface CompressorMatrix<T extends AbstractMatrix> {

    void compress(@NotNull final T tMatrix);

    static void compressMatrixRemovingRowsAndColumnsWithZeros(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        compressMatrixByRows(matrix);
        compressMatrixByColumns(matrix);
    }

    static void compressMatrixByRows(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        DeterminantMatrixIndices<MatrixInts> determinant =
                DeterminantMatrixIndices::determineIndexRowWithZeros;
        for (int i = 0; i < matrix.getRows(); i++) {
            int indexRowZeros = determinant.determine(matrix, i);
            if (indexRowZeros != -1) {
                matrix.compressRow(indexRowZeros);
                --i;
            }
        }
    }

    static void compressMatrixByColumns(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        DeterminantMatrixIndices<MatrixInts> determinant =
                DeterminantMatrixIndices::determineIndexColumnWithZeros;
        for (int i = 0; i < matrix.getColumns(); i++) {
            int indexColumnZeros = determinant.determine(matrix, i);
            if (indexColumnZeros != -1) {
                matrix.compressColumn(indexColumnZeros);
                --i;
            }
        }
    }

}
