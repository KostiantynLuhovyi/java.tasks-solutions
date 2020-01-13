package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 12-Feb-17.
 */
@FunctionalInterface
public interface Filling {

    ArrayInts fillArray(ArrayInts array);

}
