package com.lugowoy.tasks.displayArmstrongNumbersInSpecifiedRange;

/**
 * Display on the screen all Armstrong numbers in the range from 0 to 10.000.000.
 * <p>
 * Created by Konstantin Lugowoy on 02.11.2017.
 */

public class Main {

    private static final int BOUND = 10_000_000;

    public static void main(String[] args) {

        for (int i = 0; i <= BOUND; i++) {
            if (isArmstrongNumber(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    private static int numberOfDigit(int number) {
        int numberOfDigit = 0;
        if (number > 0)
            while (number != 0) {
                number = number / 10;
                numberOfDigit++;
            }
        return numberOfDigit;
    }

    private static boolean isArmstrongNumber(int number) {
        int digit;
        int result = 0;
        int tmpNumber = number;
        int count = numberOfDigit(number);
        while (number != 0) {
            digit = number % 10;
            result = result + ((int) Math.pow(digit, count));
            number = number / 10;
        }
        return tmpNumber == result;
    }

}
