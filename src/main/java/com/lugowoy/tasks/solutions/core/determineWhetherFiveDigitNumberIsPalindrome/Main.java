package com.lugowoy.tasks.determineWhetherFiveDigitNumberIsPalindrome;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter a five-digit number from the keyboard and determine if it is a palindrome.
 * (ie, it reads the same in both directions, for example, 12321 is a palindrome, and 12345 is not a palindrome).
 * <p>
 * Created by Konstantin Lugowoy on 14.09.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter a number consisting of five digits : ");
        int number = enterNumber();

        Determinant determinant = Determinant::determineWhetherFiveDigitNumberIsPalindrome;

        if (determinant.determine(number)) {
            System.out.printf("Number %d is a polindrome.", number);
        } else {
            System.out.printf("Number %d is a not polindrome.", number);
        }

    }

    private static int enterNumber() {
        int number;
        while (true) {
            number = READER.readInt();
            if (checkThatNumberContainsFiveDigits(number)) {
                break;
            } else {
                System.out.println("Incorrect number. Re-enter : ");
            }
        }
        return number;
    }

    private static boolean checkThatNumberContainsFiveDigits(int number) {
        boolean resultCheck = false;
        int duplicateNumber = number;
        int countDigitsOfNumber = 0;
        while (duplicateNumber > 0) {
            duplicateNumber /= 10;
            countDigitsOfNumber++;
        }
        if (countDigitsOfNumber == 5) {
            resultCheck = true;
        }
        return resultCheck;
    }


}
