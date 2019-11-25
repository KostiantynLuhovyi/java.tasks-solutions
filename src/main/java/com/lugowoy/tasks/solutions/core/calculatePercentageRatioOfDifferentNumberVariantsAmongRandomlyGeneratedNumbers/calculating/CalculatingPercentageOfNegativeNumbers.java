package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfNegativeNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfNegativeNumbers(Array<T> array) {
        int amountOfNegativeNumbers = 0;
        if (Checker.checkObjectOfArrayClassNonNull(array) && Checker.checkArrayNonNull(array.toArray())) {
            for (int i = 0; i < array.getLength(); i++) {
                double value = array.get(i).doubleValue();
                if (value < 0) {
                    amountOfNegativeNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfNegativeNumbers, array.getLength());
    }

}
