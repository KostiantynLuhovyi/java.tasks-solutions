package com.lugowoy.tasks.solutions.arrays.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given an array with the number of elements of N.
 * Form two arrays: the first include elements of the original array with even numbers, and in the second - with odd numbers.
 *
 * <p> Created by Konstantin Lugowoy on 16.03.2017.
 */

public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts originalArray = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + originalArray);
        System.out.println();

        Selecting<ArrayInts> selecting = Selecting::selectArray;

        ArrayInts evenNumbersArray = selecting.select(originalArray, Selecting.STATUS_EVEN_NUMBERS);
        ArrayInts oddNumbersArray = selecting.select(originalArray, Selecting.STATUS_ODD_NUMBERS);

        System.out.println("Even number array created based on the original array : " + evenNumbersArray);
        System.out.println();

        System.out.println("Odd number array created based on the original array : " + oddNumbersArray);

    }

}
