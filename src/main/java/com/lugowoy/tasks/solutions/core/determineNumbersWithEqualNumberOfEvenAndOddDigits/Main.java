package com.lugowoy.tasks.solutions.core.determineNumbersWithEqualNumberOfEvenAndOddDigits;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Determine numbers with an equal number of even and odd digits.
 * <p>
 * Created by Konstantin Lugowoy on 06.09.2018
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, Integer.MAX_VALUE));

        System.out.println("Numbers : " + integerArray);

        Array<Integer> resultArray = determineNumbersWithEqualNumberOfEvenAndOddDigits(integerArray);
        System.out.print("Result numbers : ");
        if (resultArray.size() > 0) {
            System.out.print(resultArray);
            System.out.println();
        } else {
            System.out.println("No matching matched numbers.");
        }

    }

    private static Array<Integer> determineNumbersWithEqualNumberOfEvenAndOddDigits(Array<Integer> integerArray) {
        Array<Integer> resultArray = new Array<>(0);
        int counterEvenNumbers = 0, counterOddNumbers = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            int number = integerArray.get(i);
            while (number > 0) {
                int tmpNumber = number % 10;
                if (tmpNumber % 2 == 0) {
                    counterEvenNumbers++;
                } else {
                    counterOddNumbers++;
                }
                number /= 10;
            }
            if (counterEvenNumbers == counterOddNumbers) {
                resultArray.add(integerArray.get(i));
            }
        }
        return resultArray;
    }

}
