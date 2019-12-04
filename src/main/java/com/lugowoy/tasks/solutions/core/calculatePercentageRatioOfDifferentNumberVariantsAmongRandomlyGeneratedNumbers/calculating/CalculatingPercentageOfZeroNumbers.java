package com.lugowoy.tasks.solutions.core.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfZeroNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfZeroNumbers(Array<T> array) {
        int amountOfZeroNumbers = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals(0)) {
                    amountOfZeroNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfZeroNumbers, array.size());
    }

}
