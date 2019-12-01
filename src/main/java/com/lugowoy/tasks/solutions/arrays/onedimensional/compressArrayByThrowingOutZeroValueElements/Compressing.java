package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByThrowingOutZeroValueElements;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/** Created by Konstantin Lugowoy on 16.03.2017. */

@FunctionalInterface
public interface Compressing<T> {

    void compress(ArrayInts array);

}
