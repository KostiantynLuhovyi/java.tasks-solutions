package com.lugowoy.tasks.solutions.arrays.onedimensional.interchangeElementsStandingOnOddAndEvenPositionsInArray;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;

import java.util.Arrays;

/**
 * The specified one-dimensional array interchange the adjacent elements standing on even places,
 * with standing on the odd elements.
 *
 * <p> Created by Konstantin Lugowoy on 22-Feb-17.
 */

public class Main {

    private static final int LENGTH_ARRAY = 20;

    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        numbers.setNumbers(new FillingArrayRandomPrimitiveIntegers().fill(LENGTH_ARRAY,
                                                                          HelperFillerValues.INT_ZERO,
                                                                          HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        INTERCHANGING.interchange(numbers);

        System.out.println("Array after exchange of places of elements of even and odd positions : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

    }

    private static final Interchanging INTERCHANGING = numbers -> {
        for (int i = 1; i < numbers.getNumbers().length; i++) {
            if (i % 2 == 0) {
                int tmp = numbers.getNumbers()[i];
                numbers.getNumbers()[i] = numbers.getNumbers()[i + 1];
                numbers.getNumbers()[i + 1] = tmp;
            }
        }
    };
}
