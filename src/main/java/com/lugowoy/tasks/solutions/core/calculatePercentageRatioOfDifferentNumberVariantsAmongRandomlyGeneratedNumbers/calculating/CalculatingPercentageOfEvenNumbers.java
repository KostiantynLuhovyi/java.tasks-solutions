package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfEvenNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfEvenNumbers(Array<T> array) {
        int amountOfEvenNumbers = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                double value = array.get(i).doubleValue();
                if (Math.abs(value) % 2 == 0) {
                    amountOfEvenNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfEvenNumbers, array.size());
    }

}
