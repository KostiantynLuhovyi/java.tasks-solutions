package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsOfIndexesWhichAreDegreeOfTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given an array with the number of n elements.
 * Print those elements whose indices are degree of two (1, 2, 4, 8, 16, ...).
 * <p> Created by Konstantin Lugowoy on 01.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Integer[] integersArray = new FillingArrayRandomIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND);

        System.out.println("Original : ");
        Arrays.stream(integersArray).forEachOrdered(integer -> System.out.print(integer + " "));

        System.out.println("Result : ");
        output(integersArray);

    }

    private static void output(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            if (i > 1 && i % 2 == 0) System.out.println("Index : " + i + " = " + "value : " + integers[i]);
        }
    }

}
