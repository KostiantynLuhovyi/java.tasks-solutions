package com.lugowoy.tasks.solutions.arrays.onedimensional.countOfPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given an array of integer numbers, whose dimension is N. Counting how much it negative, positive and zero elements.
 *
 * Created by Konstantin Lugowoy on 13-Feb-17.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Numbers : " + array);

        System.out.println();

        Counting<Integer> counting = Counting::countNegativeNumber;
        System.out.println("Negative number : " + counting.count(array));

        counting = Counting::countZero;
        System.out.println("Zero : " + counting.count(array));

        counting = Counting::countPositiveNumber;
        System.out.println("Positive number : " + counting.count(array));
    }

}
