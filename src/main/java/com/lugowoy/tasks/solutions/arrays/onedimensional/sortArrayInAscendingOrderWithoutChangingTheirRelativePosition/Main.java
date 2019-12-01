package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * In a one-dimensional array, rearrange the elements so that negative elements are first located, then zero, and then positive.
 * The relative arrangement of the elements does not change.
 *
 * <p> Created by Konstantin Lugowoy on 14.05.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);

        Sorting sorting = Sorting::sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition;
        sorting.sort(array);

        System.out.println();
        System.out.println("After sorting : " + array);

    }

}
