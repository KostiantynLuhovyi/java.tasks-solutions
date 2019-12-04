package com.lugowoy.tasks.solutions.core.reverseEntryThreeDigitNumber;

/**
 * Created by Konstantin Lugowoy on 03-Feb-17.
 */

public class ReverseService {

    public static int reverse(int number) {
        int oneDigit, decimalDigit, thousandthDigit;

        oneDigit = number % 10;
        number /= 10;

        decimalDigit = number % 10;
        number /= 10;

        thousandthDigit = number;

        number = 100 * oneDigit + 10 * decimalDigit + thousandthDigit;

        return number;
    }

}
