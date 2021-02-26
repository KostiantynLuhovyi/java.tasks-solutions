package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumBetweenFirstAndSecondPositiveElementsInRows;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 19.02.2021.
 */
public class FinderMatrixElements {

    public FinderMatrixElements() {
    }

    public int indexFirstPositiveMatrixElementInRow(
            @NotNull final MatrixInts matrix, final int indexRow) {
        Objects.requireNonNull(matrix, "Matrix is null");
        CheckerMatrix.checkRows(indexRow, Capacity.LOWER.get(), matrix.getRows());
        int index = 0;
        while (index < matrix.getColumns()) {
            int firstPositiveElement = matrix.getElement(indexRow, index);
            if (firstPositiveElement > 0) {
                break;
            }
            index++;
        }
        return index;
    }

    public int indexSecondPositiveMatrixElementInRow(
            @NotNull final MatrixInts matrix, final int indexRow) {
        Objects.requireNonNull(matrix, "Matrix is null");
        CheckerMatrix.checkRows(indexRow, Capacity.LOWER.get(), matrix.getRows());
        int indexPositiveElement = 0;
        int index = 0;
        while (index < matrix.getColumns()) {
            int secondPositiveElement = matrix.getElement(indexRow, index);
            if (secondPositiveElement > 0) {
                indexPositiveElement++;
                if (indexPositiveElement == 2) {
                    break;
                }
            }
            index++;
        }
        return index;
    }

}
