package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public class Calculator<T extends Number> {

    private Calculating<T> calculating;

    public int calculate(Array<T> array) {
        return this.calculating.calculate(array);
    }

    public Calculating<T> getCalculating() {
        return calculating;
    }

    public void setCalculating(Calculating<T> calculating) {
        this.calculating = calculating;
    }

}
