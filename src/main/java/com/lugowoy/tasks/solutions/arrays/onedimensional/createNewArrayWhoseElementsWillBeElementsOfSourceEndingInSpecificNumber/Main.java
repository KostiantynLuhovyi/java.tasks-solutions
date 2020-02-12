package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber;

import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Create a new array whose elements will be elements of the source code ending in a certain number.
 * <p> Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final int START_BOUND = -10000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter specific ending number : ");
        int specificEndingNumber = new ReadingConsole().readInt();

        ArrayInts resultArray = selectElementsEndingSpecificValue(array, specificEndingNumber);

        if (resultArray.size() != 0) {
            System.out.println("New array : " + resultArray);
            System.out.println();
        } else {
            System.out.println("No values were found with the specified ending.");
        }

    }

    private static ArrayInts selectElementsEndingSpecificValue(ArrayInts array, int specificEndingValue) {
        ArrayInts resultArray = new ArrayInts(0);
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (Math.abs(array.get(i)) % 10 == specificEndingValue) {
                    resultArray.add(array.get(i));
                }
            }
        }
        return resultArray;
    }

}
