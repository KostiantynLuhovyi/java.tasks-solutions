package com.lugowoy.tasks.solutions.arrays.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * Given an array of integers.
 * Find in this array element N minimum and maximum element M. Get in ascending order of all the integers from the interval (N; M),
 * which are not included in this array.
 * <p> Created by Konstantin Lugowoy on 11.04.2017.
 */
public class Main {

    private static final int START_BOUND = -50;
    private static final int END_BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read();

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Finding<Integer, ArrayInts> finding = Finding::findMaxNumber;
        int maxNumberInTheArray = finding.find(array);
        System.out.println("Max number in the array : " + maxNumberInTheArray);

        finding = Finding::findMinNumber;
        int minNumberInTheArray = finding.find(array);
        System.out.println("Min number in the array : " + minNumberInTheArray);

        ArrayInts arraySorted = new ArrayInts(array.toArray(new int[array.size()]));

        Arrays.sort(arraySorted.toArray(new int[arraySorted.size()]));

        for (int j = minNumberInTheArray + 1; j < maxNumberInTheArray; j++) {
            if (!(Arrays.binarySearch(array.toArray(new int[array.size()]), j) > 0)) {
                System.out.print(j + " ");
            }
        }

    }

}
