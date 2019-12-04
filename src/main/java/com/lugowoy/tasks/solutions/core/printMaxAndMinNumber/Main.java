package com.lugowoy.tasks.solutions.core.printMaxAndMinNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Print max and min value number.
 * <p>
 * Created by Konstantin Lugowoy on 12.07.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray));

        System.out.println("Original number : " + array);
        System.out.println();

        int indexMaxElement = getIndexMaxNumber(array);
        int indexMinElement = getIndexMinNumber(array);

        System.out.println("Max element : " + array.get(indexMaxElement));
        System.out.println("Min element : " + array.get(indexMinElement));

    }

    private static int getIndexMaxNumber(Array<Integer> array) {
        int value = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > value) {
                value = array.get(i);
                index = i;
            }
        }
        return index;
    }

    private static int getIndexMinNumber(Array<Integer> array) {
        int value = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < value) {
                value = array.get(i);
                index = i;
            }
        }
        return index;
    }

}
