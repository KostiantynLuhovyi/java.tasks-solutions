package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumBetweenFirstAndSecondPositiveElementsInRows;

import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 19.02.2021.
 */
public class CalculatorMatrixElements {

    public CalculatorMatrixElements() {
    }

    public int calculateSumBetweenFirstAndSecondPositiveElementsInRow(
            @NotNull final MatrixInts matrix, final int indexRow,
            final int indexFirstPositive, final int indexSecondPositive) {
        Objects.requireNonNull(matrix, "Matrix is null");
        CheckerMatrix.checkRows(indexRow, Capacity.LOWER.get(), matrix.getRows());
        CheckerIndex.checkInRange(indexFirstPositive, matrix.getColumns());
        CheckerIndex.checkInRange(indexSecondPositive, matrix.getColumns());
        int resultSum = 0;
        for (int i = indexFirstPositive; i <= indexSecondPositive; i++) {
            resultSum += matrix.getElement(indexRow, i);
        }
        return resultSum;
    }

}
