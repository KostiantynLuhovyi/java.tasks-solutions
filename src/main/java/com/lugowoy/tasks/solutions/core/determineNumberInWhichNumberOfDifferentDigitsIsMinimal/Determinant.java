package com.lugowoy.tasks.solutions.core.determineNumberInWhichNumberOfDifferentDigitsIsMinimal;

import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 03.09.2018
 */

@FunctionalInterface
public interface Determinant {

    int determineNumber(Array<Integer> integerArray);

    static int determineNumberInWhichNumberOfDifferentDigitsIsMinimal(Array<Integer> integerArray) {
        int resultNumber = 0;
        int counter = 0, generalCounter = Integer.MAX_VALUE;
        for (int i = 0; i < integerArray.size(); i++) {
            int[] ints = getPrimitiveIntegerArrayOfNumber(integerArray.get(i));
            for (int j = 0; j < ints.length; j++) {
                for (int k = 0; k < ints.length; k++) {
                    if (ints[j] == ints[k]) {
                        counter++;
                    }
                }
            }
            if (counter < generalCounter) {
                generalCounter = counter;
                resultNumber = integerArray.get(i);
            }
            counter = 0;
        }
        return resultNumber;
    }

    private static int[] getPrimitiveIntegerArrayOfNumber(int number) {
        int[] resultArray = new int[String.valueOf(number).length()];
        int index = resultArray.length - 1;
        while (number > 0) {
            resultArray[index] = number % 10;
            number /= 10;
            index--;
        }
        return resultArray;
    }

}
