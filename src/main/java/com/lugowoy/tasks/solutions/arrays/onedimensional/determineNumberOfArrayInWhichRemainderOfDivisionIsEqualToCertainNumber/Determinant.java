package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 14-Feb-17.
 */

@FunctionalInterface
public interface Determinant {

    void determinate(ArrayInts array, int numberToModulo, int resultModulo);

}
