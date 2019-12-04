package com.lugowoy.tasks.solutions.core.findNumberOfDigitsInWhichGoInOrderOfStrictAscending;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Find the number of digits in which go in the order of strict ascending.
 * If such numbers are somewhat to display the first.
 * <p>
 * Created by Konstantin Lugowoy on 06.09.2018
 */

public class Main {

    private static final int BOUND = 1000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, BOUND));

        System.out.println("Numbers : " + integerArray);

        int resultNumber = findNumberOfDigitsInWhichGoInOrderOfStrictAscending(integerArray);
        if (resultNumber == 0) {
            System.out.println("No matching matched number.");
        } else {
            System.out.print("Result number : " + resultNumber);
        }
    }

    private static int findNumberOfDigitsInWhichGoInOrderOfStrictAscending(Array<Integer> integerArray) {
        int resultNumber = 0;
        boolean checkResult = false;
        int i = 0;
        while (i < integerArray.size()) {
            int number = integerArray.get(i);
            resultNumber = number;
            while (number != 0) {
                int tmpFirst = number % 10;
                int tmpSecond = number % 100 / 10;
                if (tmpFirst >= tmpSecond) {
                    number /= 10;
                    checkResult = true;
                } else {
                    resultNumber = 0;
                    checkResult = false;
                    break;
                }
            }
            if (checkResult) break;
            i++;
        }
        return resultNumber;
    }

}
