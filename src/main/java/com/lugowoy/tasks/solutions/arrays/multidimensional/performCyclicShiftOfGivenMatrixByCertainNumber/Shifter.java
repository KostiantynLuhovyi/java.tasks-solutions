package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */
@FunctionalInterface
public interface Shifter<T> {

    void shift(@NotNull final MatrixInts matrix, final int numberToShiftMatrix);

}
