package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface Calculating {

    int calculate(ArrayInts array, int indexMinElement, int indexMaxElement);

}
