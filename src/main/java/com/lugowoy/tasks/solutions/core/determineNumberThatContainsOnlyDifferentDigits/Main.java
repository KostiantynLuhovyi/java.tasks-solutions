package com.lugowoy.tasks.determineNumberThatContainsOnlyDifferentDigits;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerLengthArray;
import com.lugowoy.helper.other.LengthReader;

import java.util.Objects;

/**
 * Determine a number consisting only of different digits. Print the first found number.
 * <p>
 * Created by Konstantin Lugowoy on 12.09.2018
 */

public class Main {

    private static final int BOUND = 100_000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomInteger().fill(lengthOfArray, BOUND));

        System.out.println("Numbers in an array : " + integerArray);

        System.out.print("Result : ");
        int resultNumber = determineNumberThatContainsOnlyDifferentDigits(integerArray);
        if (resultNumber == 0) {
            System.out.print("No numbers corresponding to the condition");
        } else {
            System.out.println(resultNumber);
        }

    }

    private static int determineNumberThatContainsOnlyDifferentDigits(Array<Integer> integerArray) {
        int resultNumber = 0;
        int counterDifferentDigit = 0;
        int[] ints;
        if (Objects.nonNull(integerArray) && CheckerLengthArray.checkLengthArray(integerArray)) {
            for (int i = 0; i < integerArray.getLength(); i++) {
                int number = integerArray.get(i);
                ints = getIntNumbersOfNumber(number);
                for (int j = 0; j < ints.length; j++) {
                    for (int k = 0; k < ints.length; k++) {
                        if (j != k) {
                            if (ints[j] == ints[k]) {
                                counterDifferentDigit++;
                                if (counterDifferentDigit >= 2) {
                                    break;
                                }
                            } else {
                                resultNumber = number;
                            }
                        }
                    }
                }
                if (counterDifferentDigit >= 2) {
                    counterDifferentDigit = 0;
                    resultNumber = 0;
                } else {
                    break;
                }
            }
        } else {
            System.err.println("Incorrect arguments.");
        }
        return resultNumber;
    }

    private static int[] getIntNumbersOfNumber(int number) {
        int[] numbers = new int[String.valueOf(number).length()];
        int index = numbers.length - 1;
        while (number > 0) {
            numbers[index] = number % 10;
            number /= 10;
            index--;
        }
        return numbers;
    }

}
