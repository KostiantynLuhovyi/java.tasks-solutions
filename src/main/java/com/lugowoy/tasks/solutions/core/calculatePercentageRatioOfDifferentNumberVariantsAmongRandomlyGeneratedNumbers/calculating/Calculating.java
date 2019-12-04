package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

@FunctionalInterface
public interface Calculating<T extends Number> {

    int calculate(Array<T> array);

}
