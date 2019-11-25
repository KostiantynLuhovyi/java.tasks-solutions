package com.lugowoy.tasks.determineNumberIsPolindrome;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Determine that the number of palindromes, whose values in the forward and reverse order are the same.
 * <p>
 * Created by Konstantin Lugowoy on 03.09.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter a number to determine if it is a palindrome : ");
        int number = READER.readInt();

        Determinant<Integer> determinant = Determinant::determineNumberIsPolindrome;

        if (determinant.determine(number)) {
            System.out.printf("Number %d is a polindrome.", number);
        } else {
            System.out.printf("Number %d is a not polindrome.", number);
        }

    }

}
