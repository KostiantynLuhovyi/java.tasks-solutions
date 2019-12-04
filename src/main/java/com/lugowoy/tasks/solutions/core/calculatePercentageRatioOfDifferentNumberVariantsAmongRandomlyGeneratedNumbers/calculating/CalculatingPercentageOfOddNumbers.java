package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static java.lang.Math.abs;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfOddNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfOddNumbers(Array<T> array) {
        int amountOfOddNumbers = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                double value = array.get(i).doubleValue();
                if (abs(value) % 2 != 0) {
                    amountOfOddNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfOddNumbers, array.size());
    }

}
