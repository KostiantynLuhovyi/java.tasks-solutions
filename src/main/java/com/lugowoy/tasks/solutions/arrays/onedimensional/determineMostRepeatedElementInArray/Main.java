package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.tasks.solutions.Helper;

/**
 * In the array of integers with the number of elements n, find the most repeated number.
 * If there are several such numbers, then determine the smallest of them.
 * <p> Created by Konstantin Lugowoy on 22.03.2017.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        DETERMINANT.determine(array);

    }

    private static final Determinant<Integer> DETERMINANT = array -> {
        int count, countMax = 0, value = 1, num = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() > 2) {
                for (int i = 0; i < array.size(); i++) {
                    count = 1;
                    for (int j = i + 1; j < array.size(); j++) {
                        if (array.get(i) == (array.get(j))) {
                            value = array.get(j);
                            count++;
                        } else if (count > countMax) {
                            countMax = count;
                            if (value <= array.get(i)) {
                                num = i;
                            }
                        }
                    }
                }
            }
        }
        if (countMax == 1) {
            System.out.println("No repetitive elements in the array.");
        } else {
            System.out.println("Element " + array.get(num) + ", repeated " + countMax);
        }
    };

}
