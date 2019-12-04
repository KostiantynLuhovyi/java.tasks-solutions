package com.lugowoy.tasks.solutions.core.showAllEightDigitNumbersOfNumbersInWhichDoNotRepeat;

/**
 * Display on the screen all eight-digit numbers, the numbers in which do not repeat.
 * These numbers must be divisible by 12345 without any residue. Show the total number of numbers found.
 * <p>
 * Created by Konstantin Lugowoy on 21.10.2017.
 */

public class Main {

    public static void main(String[] args) {

        showAllEightDigitNumbersOfNumbersInWhichDoNotRepeat();

    }

    private static void showAllEightDigitNumbersOfNumbersInWhichDoNotRepeat() {
        int countNumber = 0;
        System.out.println("All eight-digit numbers of the numbers in which do not repeat : ");
        for (int number = 10000000; number < 99999999; number++) {
            int[] numbers = new int[8];
            for (int i = 0, num = number; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++, num /= 10) {
                    numbers[j] = num % 10;
                }
                if (checkDoNotRepeatDigitOfNumber(numbers)) {
                    System.out.println(number);
                    countNumber++;
                }
            }
        }
        System.out.println("Count result : " + countNumber);
    }

    private static boolean checkDoNotRepeatDigitOfNumber(int[] numbers) {
        boolean checkDoNotRepeatNumberDigit = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (checkDoNotRepeatNumberDigit) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] == numbers[j]) {
                        checkDoNotRepeatNumberDigit = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return checkDoNotRepeatNumberDigit;
    }

}
