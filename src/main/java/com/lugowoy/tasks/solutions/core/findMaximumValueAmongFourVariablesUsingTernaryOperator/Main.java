package com.lugowoy.tasks.solutions.core.findMaximumValueAmongFourVariablesUsingTernaryOperator;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Find the maximum value among the 4 variables using the ternary operator.
 * <p>
 * Created by Konstantin Lugowoy on 27.09.2017.
 */

public class Main {

    private static final int LENGTH_ARRAY = 4;
    private static final int MIN_BOUND = -20;
    private static final int MAX_BOUND = 20;

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(LENGTH_ARRAY, MIN_BOUND, MAX_BOUND));

        System.out.println("Original array : " + array);

        int resultValue = findMaximumValueAmongFourVariablesUsingTernaryOperator(array);

        System.out.println();
        System.out.println("Result : " + resultValue);

    }

    private static int findMaximumValueAmongFourVariablesUsingTernaryOperator(Array<Integer> array) {
        boolean checkValue;
        int resultValue = 0;
        int countCheckValue = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                checkValue = array.get(i) >= array.get(j);
                if (checkValue) {
                    resultValue = array.get(i);
                    countCheckValue++;
                } else {
                    resultValue = 0;
                    countCheckValue = 0;
                    break;
                }
            }
            if (countCheckValue == 4) {
                break;
            }
        }
        return resultValue;
    }

}
