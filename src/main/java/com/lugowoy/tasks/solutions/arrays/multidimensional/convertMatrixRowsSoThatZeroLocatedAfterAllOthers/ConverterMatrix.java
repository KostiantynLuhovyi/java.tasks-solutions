package com.lugowoy.tasks.solutions.arrays.multidimensional.convertMatrixRowsSoThatZeroLocatedAfterAllOthers;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 25.10.2021.
 */
@FunctionalInterface
public interface ConverterMatrix<T extends AbstractMatrix> {

    void convert(@NotNull final T tMatrix);

    static void convertMatrixSoThatRowsWithZerosAreAtEnd(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int indexRowElement = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            int[] tmp = new int[matrix.getRows()];
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element != 0) {
                    tmp[indexRowElement] = element;
                } else {
                    continue;
                }
                indexRowElement++;
            }
            matrix.setRowFromArray(tmp, i);
            indexRowElement = 0;
        }
    }

}
