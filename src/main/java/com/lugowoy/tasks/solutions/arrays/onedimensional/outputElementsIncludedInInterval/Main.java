package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsIncludedInInterval;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

import java.util.Arrays;

/**
 * Given a sequence of integer numbers a1, a2, ..., an. Output elements of it that belong to the interval [c, d].
 *
 * <p>Created by Konstantin Lugowoy on 06.03.2017.
 */
public class Main {

    private static final ReaderConsole READER = new ReaderConsole();

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        Integer[] integers = new FillingArrayRandomIntegers().fill(lengthArray,
                                                                   HelperFillerValues.INT_ZERO,
                                                                   HelperFillerValues.INT_POSITIVE_HUNDRED);

        System.out.println("Original sequence : ");
        Arrays.stream(integers).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Enter the value of the start of the segment : ");
        int startOfInterval = READER.readInt();
        System.out.println("Enter the value of the finish of the segment : ");
        int finishOfInterval = READER.readInt();

        System.out.println("Elements entering the sequence of numbers from a segment : ");
        Arrays.stream(integers).forEachOrdered(integer -> {
            if ((integer > startOfInterval) && (integer < finishOfInterval)) {
                System.out.print(integer + " ");
            }
        });

    }

}

