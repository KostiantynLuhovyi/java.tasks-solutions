package com.lugowoy.tasks.solutions.core.printShortestNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Find the shortest number. Print the found number and their length.
 * <p>
 * Created by Konstantin Lugowoy on 08.08.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, Integer.MAX_VALUE));

        System.out.println("Numbers in an array : " + integerArray);

        printShortestNumber(DeterminantShortestNumber::determineShortestNumberOfNumbers, integerArray);

    }

    private static void printShortestNumber(DeterminantShortestNumber<Integer> determinantShortestNumber, Array<Integer> integerArray) {
        int defaultDigitToCount = 0;
        int resultNumber = determinantShortestNumber.determine(integerArray);
        System.out.println("Result number " + resultNumber);
        System.out.println("Length of the number : " + DeterminantShortestNumber.countDigitOfNumber(defaultDigitToCount, Math.abs(resultNumber)));
    }

}
