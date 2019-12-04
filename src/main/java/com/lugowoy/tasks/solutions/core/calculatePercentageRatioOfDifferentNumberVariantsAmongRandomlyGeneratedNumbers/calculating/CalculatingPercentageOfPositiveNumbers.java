package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfPositiveNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfPositiveNumbers(Array<T> array) {
        int amountOfPositiveNumbers = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                double value = array.get(i).doubleValue();
                if (value > 0) {
                    amountOfPositiveNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfPositiveNumbers, array.size());
    }

}
