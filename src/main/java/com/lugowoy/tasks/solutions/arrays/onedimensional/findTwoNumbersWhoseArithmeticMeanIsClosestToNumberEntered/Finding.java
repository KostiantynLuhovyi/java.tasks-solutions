package com.lugowoy.tasks.solutions.arrays.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered;

import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 12.04.2017.
 */
public interface Finding<T, V> {

    void find(T t, V v);

    static void findTwoNumbersWhoseArithmeticMeanIsClosestToNumber(double numberEntered, ArrayDoubles array) {
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() > 1) {
                double diff = (array.get(0) + array.get(1)) / 2 - numberEntered;
                double firstNumber = array.get(0);
                double secondNumber = array.get(1);
                double temp;
                for (int i = 0; i < array.size(); i++) {
                    for (int j = i + 1; j < array.size(); j++) {
                        temp = (array.get(i) + array.get(j)) / 2 - numberEntered;
                        if (Math.abs(temp) < Math.abs(diff)) {
                            diff = temp;
                            firstNumber = array.get(i);
                            secondNumber = array.get(j);
                        }
                    }
                }
                System.out.println("Result numbers : " + firstNumber + " and " + secondNumber + " .");
            }
        }
    }

}
