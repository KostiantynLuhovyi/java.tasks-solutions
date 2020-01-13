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
 * <p> Created by Konstantin Lugowoy on 30.05.2017.
 */
public class Main {

    private static FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        int[] firstInts = filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND);
        Arrays.sort(firstInts);
        ArrayInts firstArray = new ArrayInts(firstInts);
        System.out.println("First array : " + firstArray);

        int[] secondInts = filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND);
        Arrays.sort(secondInts);
        ArrayInts secondArray = new ArrayInts(secondInts);
        System.out.println("Second array : " + secondArray);

        Merging<ArrayInts> merging = Merging::mergeArrays;
        ArrayInts resultArray = merging.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);

    }

}
