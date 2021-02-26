package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 26.02.2021.
 */
@FunctionalInterface
public interface ShifterMatrix<T extends AbstractMatrix> {

    void shift(@NotNull final T t, final int numberToShiftMatrix);

}
