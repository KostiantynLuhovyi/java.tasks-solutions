package com.lugowoy.tasks.exchangeCentralNumberOfTwoNumbers;

/**
 * Created by Konstantin Lugowoy on 05-Feb-17.
 */

public class ExchangeCentralNumberOfTwoNumber {

    public static void exchange(Number firstNumber, Number secondNumber) {
        int firstCenterOfNumber = getCenterOfNumber(firstNumber);
        int secondCenterOfNumber = getCenterOfNumber(secondNumber);
        parseToSetCenterNumber(firstNumber, secondCenterOfNumber);
        parseToSetCenterNumber(secondNumber, firstCenterOfNumber);
    }

    private static void parseToSetCenterNumber(Number number, int centerOfNumber) {
        int oneDigit, thousandthDigit;

        oneDigit = number.getNumber() % 10;

        number.setNumber(number.getNumber() / 10);

        number.setNumber(number.getNumber() / 10);

        thousandthDigit = number.getNumber();

        number.setNumber((thousandthDigit * 100) + (centerOfNumber * 10) + oneDigit);
    }

    private static int getCenterOfNumber(Number number) {
        int num = number.getNumber();
        int centerOfNumber;

        int oneDigit = num % 10;
        num /= 10;

        centerOfNumber = num % 10;

        return centerOfNumber;
    }

}
