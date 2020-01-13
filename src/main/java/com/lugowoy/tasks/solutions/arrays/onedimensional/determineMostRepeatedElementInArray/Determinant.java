package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 22.03.2017.
 */
@FunctionalInterface
public interface Determinant<T> {

    void determine(ArrayInts array);

}
