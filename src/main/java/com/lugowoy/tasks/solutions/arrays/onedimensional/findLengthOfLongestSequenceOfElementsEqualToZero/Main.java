package com.lugowoy.tasks.solutions.arrays.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given an array A. Find the length of the longest sequence of consecutive array elements equal to zero.
 *
 * <p> Created by Konstantin Lugowoy on 18.06.2017.
 */

public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);
        System.out.println();

        Finding finding = Finding::findLengthOfLongestSequenceOfElementsEqualToZero;
        int resultZeroElementsToCount = finding.find(array);

        System.out.println("The longest sequence of consecutive array elements equal to zero is equal to " + resultZeroElementsToCount);

    }

}
