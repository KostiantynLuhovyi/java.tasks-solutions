package com.lugowoy.tasks.solutions.arrays.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given two ordered arrays A and B.
 * Form from the elements of these arrays an ordered array C.
 *
 * <p>Created by Konstantin Lugowoy on 30.05.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts firstArray = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        Arrays.sort(firstArray.toArray(new int[firstArray.size()]));

        ArrayInts secondArray = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        Arrays.sort(secondArray.toArray(new int[secondArray.size()]));

        System.out.println("Original first array : " + firstArray);
        System.out.println();

        System.out.println("Original second array : " + secondArray);
        System.out.println();

        Merging<ArrayInts> merging = Merging::mergeArrays;
        ArrayInts resultArray = merging.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);
        System.out.println();

    }

}
