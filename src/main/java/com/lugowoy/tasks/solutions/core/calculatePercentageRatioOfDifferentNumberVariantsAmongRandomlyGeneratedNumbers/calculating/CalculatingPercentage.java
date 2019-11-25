package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public interface CalculatingPercentage<T extends Number> {

    int calculatePercentageOfPositiveNumbers(Array<T> array);

    int calculatePercentageOfNegativeNumbers(Array<T> array);

    int calculatePercentageOfZeroNumbers(Array<T> array);

    int calculatePercentageOfEvenNumbers(Array<T> array);

    int calculatePercentageOfOddNumbers(Array<T> array);

    static int calculatePercentage(int amountForCalculate, int totalAmount) {
        return amountForCalculate * totalAmount / 100;
    }

}
