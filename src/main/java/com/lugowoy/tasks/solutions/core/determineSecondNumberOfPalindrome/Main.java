package com.lugowoy.tasks.determineSecondNumberOfPalindrome;

import com.lugowoy.helper.filling.array.numbers.FillingArrayReadInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerLengthArray;
import com.lugowoy.helper.other.LengthReader;

import java.util.Objects;

/**
 * Determine the number of the palindrome. If it is not the only one, then take the second one.
 * <p>
 * Created by Konstantin Lugowoy on 13.09.2018
 */

public class Main {

    private static final int BOUND = 1_000_000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayReadInteger(new ReadingConsole()).fill(lengthOfArray, BOUND));

        System.out.println("Numbers in an array : " + integerArray);

        System.out.print("Result : ");
        int numberOfPolindrome = determineSecondNumberOfPolindrome(integerArray);
        if (numberOfPolindrome == 0) {
            System.out.print("No value matching the condition of the task was found.");
        } else if (numberOfPolindrome > 0) {
            System.out.print(numberOfPolindrome);
        }

    }

    private static int determineSecondNumberOfPolindrome(Array<Integer> integerArray) {
        int resultNumber = 0;
        if (Objects.nonNull(integerArray) && CheckerLengthArray.checkLengthArray(integerArray)) {
            int counterPolindromeNumber = 0;
            for (int i = 0; i < integerArray.getLength(); i++) {
                int number = integerArray.get(i);
                String numberValue = Integer.toString(number);
                int duplicateNumber = number;
                int reverseNumber = 0;
                for (int j = 0; j < numberValue.length(); j++) {
                    reverseNumber = reverseNumber * 10 + (duplicateNumber % 10);
                    duplicateNumber /= 10;
                }
                if (number == reverseNumber) {
                    counterPolindromeNumber++;
                }
                if (counterPolindromeNumber == 2) {
                    resultNumber = number;
                }
            }
        }
        return resultNumber;
    }

}
