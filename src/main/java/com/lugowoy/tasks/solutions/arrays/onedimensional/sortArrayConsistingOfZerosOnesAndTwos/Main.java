package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * In the array, each element is 0, 1, 2.
 * Rearrange the elements of the array so that all zeros are first, then all the ones, and finally all the deuces.
 * <p> Created by Konstantin Lugowoy on 17.06.2017.
 */
public class Main {

    private static final int BOUND = 2;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);

        Sorting<ArrayInts> sorting = Sorting::sortArray;
        sorting.sort(array);

        System.out.println("After sort " + array);

    }

}
