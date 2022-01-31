package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsOfIndexesWhichAreDegreeOfTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * Given an array with the number of n elements.
 * Print those elements whose indices are degree of two (1, 2, 4, 8, 16, ...).
 *
 * <p> Created by Konstantin Lugowoy on 01.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                              ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        Integer[] integersArray = new FillingArrayRandomIntegers().fill(lengthArray,
                                                                        HelperFillerValues.INT_NEGATIVE_HUNDRED,
                                                                        HelperFillerValues.INT_POSITIVE_HUNDRED);

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
