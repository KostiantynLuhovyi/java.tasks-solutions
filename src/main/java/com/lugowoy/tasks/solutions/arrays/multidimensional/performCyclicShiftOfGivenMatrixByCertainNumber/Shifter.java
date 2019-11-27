package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.matrices.MatrixInts;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

@FunctionalInterface
public interface Shifter<T> {

    void shift(MatrixInts matrix, int numberToShiftMatrix);

}
