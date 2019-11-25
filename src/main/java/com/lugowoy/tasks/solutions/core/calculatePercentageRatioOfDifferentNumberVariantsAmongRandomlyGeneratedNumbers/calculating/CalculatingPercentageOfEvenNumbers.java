package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.Array;

import static java.lang.Math.abs;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentageOfEvenNumbers<T extends Number> extends CalculatingPercentage<T> {

    @Override
    default int calculatePercentageOfEvenNumbers(Array<T> array) {
        int amountOfEvenNumbers = 0;
        if (Checker.checkObjectOfArrayClassNonNull(array) && Checker.checkArrayNonNull(array.toArray())) {
            for (int i = 0; i < array.getLength(); i++) {
                double value = array.get(i).doubleValue();
                if (abs(value) % 2 == 0) {
                    amountOfEvenNumbers++;
                }
            }
        }
        return CalculatingPercentage.calculatePercentage(amountOfEvenNumbers, array.getLength());
    }

}
