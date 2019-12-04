package com.lugowoy.tasks.solutions.core.findNumbersThatContainOnlyEvenNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.ArrayList;

/**
 * Find numbers that contain only even numbers.
 * <p>
 * Created by Konstantin Lugowoy on 06.09.2018
 */

public class Main {

    private static final int BOUND = 100000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, BOUND));

        System.out.println("Numbers : " + integerArray);

        ArrayList<Integer> resultNumbers = findNumbersThatContainOnlyEvenNumbers(integerArray);

        if (resultNumbers.size() > 0) {
            System.out.println("Result numbers : " + resultNumbers);
        } else {
            System.out.println("Numbers matching the condition is not found.");
        }
    }

    private static ArrayList<Integer> findNumbersThatContainOnlyEvenNumbers(Array<Integer> integerArray) {
        ArrayList<Integer> resultNumbers = new ArrayList<>();
        for (int i = 0; i < integerArray.size(); i++) {
            int number = integerArray.get(i);
            resultNumbers.add(number);
            while (number > 0) {
                int digitOfNumber = getDigitOfNumber(number);
                if (digitOfNumber % 2 == 0) {
                    resultNumbers.remove(integerArray.get(i));
                    break;
                }
                number /= 10;
            }
        }
        return resultNumbers;
    }

    private static int getDigitOfNumber(int number) {
        return number % 10;
    }

}
