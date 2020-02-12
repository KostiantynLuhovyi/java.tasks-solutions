package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a one-dimensional array of numbers, among the elements of which are the same.
 * Create a new array from the various elements of the original array.
 * <p> Created by Konstantin Lugowoy on 29.05.2017.
 */
public class Main {

    private static final DeterminantUniqueness DETERMINANT = DeterminantUniqueness::determineTheUniqueElementsOfTheOriginalArray;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);

        ArrayInts newArrayFromTheUniqueElements = DETERMINANT.determineUniqueness(array);

        System.out.println("New array from the unique elements : " + newArrayFromTheUniqueElements);

    }

}
