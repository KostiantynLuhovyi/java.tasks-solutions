package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public class CalculatorPercentage<T extends Number> implements CalculatingPercentageOfPositiveNumbers<T>, CalculatingPercentageOfNegativeNumbers<T>,
        CalculatingPercentageOfZeroNumbers<T>, CalculatingPercentageOfEvenNumbers<T>, CalculatingPercentageOfOddNumbers<T> {

    public CalculatorPercentage() {
    }

}
