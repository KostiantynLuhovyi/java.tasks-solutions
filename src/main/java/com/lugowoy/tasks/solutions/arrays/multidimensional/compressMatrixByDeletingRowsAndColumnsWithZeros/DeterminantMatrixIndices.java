package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByDeletingRowsAndColumnsWithZeros;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 22.10.2021.
 */
@FunctionalInterface
public interface DeterminantMatrixIndices<T extends AbstractMatrix> {

    int determine(@NotNull final T tMatrix, final int index);

    static int determineIndexColumnWithZeros(@NotNull final MatrixInts matrix,
                                                     final int indexRow) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        int resultIndexRow = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            if (matrix.getElement(indexRow, i) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getColumns()) {
            resultIndexRow = indexRow;
        }
        return resultIndexRow;
    }

    static int determineIndexRowWithZeros(@NotNull final MatrixInts matrix,
                                                  final int indexColumn) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int resultIndexColumn = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, indexColumn) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getRows()) {
            resultIndexColumn = indexColumn;
        }
        return resultIndexColumn;
    }

}
