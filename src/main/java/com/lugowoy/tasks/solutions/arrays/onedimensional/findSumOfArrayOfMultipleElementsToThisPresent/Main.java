package com.lugowoy.tasks.solutions.arrays.onedimensional.findSumOfArrayOfMultipleElementsToThisPresent;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Given an array of numbers. Find the sum of the elements that are multiples of to this K.
 * <p> Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Result fill arrays randomly integers : ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        System.out.println("Enter K number : ");
        int K = new ReadingConsole().readInt();

        int resultOfSumNumbersOfMultipleElement = (FINDING_SUM_ELEMENTS.calculateSumOfElements(array, K));

        System.out.println("Result : " + resultOfSumNumbersOfMultipleElement);

    }

    private static final Finding FINDING_SUM_ELEMENTS = (array, k) -> {
        int sumElements = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % k == 0) {
                    sumElements += array.get(i);
                }
            }
        }
        return sumElements;
    };

}
