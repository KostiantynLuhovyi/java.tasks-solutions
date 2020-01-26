package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsIncludedInInterval;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.*;

/**
 * Given a sequence of integer numbers a1, a2, ..., an. Output elements of it that belong to the interval [c, d].
 * <p> Created by Konstantin Lugowoy on 06.03.2017.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Integer[] integers = new FillingArrayRandomIntegers().fill(lengthOfArray, INT_ZERO, INT_UPPER_BOUND);

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

