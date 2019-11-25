package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.Array;

import static java.lang.Math.abs;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfOddNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfOddNumbers(Array<T> array) {
        int amountOfOddNumbers = 0;
        if (Checker.checkObjectOfArrayClassNonNull(array) && Checker.checkArrayNonNull(array.toArray())) {
            for (int i = 0; i < array.getLength(); i++) {
                double value = array.get(i).doubleValue();
                if (abs(value) % 2 != 0) {
                    amountOfOddNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfOddNumbers, array.getLength());
    }

}
