package com.lugowoy.tasks.checkMultiplicityOfNumberByThreeNumbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import static java.lang.Math.abs;

/**
 * Enter the number and determine whether it is a multiple of 3, 5, and 7 at the same time.
 * <p>
 * Created by Konstantin Lugowoy on 12.09.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int NUMBER_FIRST_FOR_CHECK_MULTIPLICITY = 3;
    private static final int NUMBER_SECOND_FOR_CHECK_MULTIPLICITY = 5;
    private static final int NUMBER_THIRD_FOR_CHECK_MULTIPLICITY = 7;

    public static void main(String[] args) {

        System.out.println("Enter number for check multiplicity : ");
        int number = enterNumber();

        if (checkMultiplicityOfNumbers(number)) {
            System.out.printf("Number %d is multiplicity of %d, %d, %d numbers.", number,
                                                                                  NUMBER_FIRST_FOR_CHECK_MULTIPLICITY,
                                                                                  NUMBER_SECOND_FOR_CHECK_MULTIPLICITY,
                                                                                  NUMBER_THIRD_FOR_CHECK_MULTIPLICITY);
        } else {
            System.out.printf("Number %d is not multiplicity of %d, %d, %d numbers.", number,
                                                                                      NUMBER_FIRST_FOR_CHECK_MULTIPLICITY,
                                                                                      NUMBER_SECOND_FOR_CHECK_MULTIPLICITY,
                                                                                      NUMBER_THIRD_FOR_CHECK_MULTIPLICITY);
        }

    }

    private static boolean checkMultiplicityOfNumbers(int number) {
        boolean checkResult = false;
        if (abs(number) % NUMBER_FIRST_FOR_CHECK_MULTIPLICITY == 0) {
            if (abs(number) % NUMBER_SECOND_FOR_CHECK_MULTIPLICITY == 0) {
                if (abs(number) % NUMBER_THIRD_FOR_CHECK_MULTIPLICITY == 0) {
                    checkResult = true;
                }
            }
        }
        return checkResult;
    }

    private static int enterNumber() {
        long number;
        while (true) {
            number = READER.readInt();
            if ((number > Integer.MIN_VALUE) && (number < Integer.MAX_VALUE)) {
                break;
            } else {
                System.out.println("The value of the number is less than or greater than the allowable value.");
                System.out.printf("Min value : %d%n", Integer.MIN_VALUE);
                System.out.printf("Max value : %d%n", Integer.MAX_VALUE);
                System.out.println("Re-enter : ");
            }
        }
        return (int) number;
    }


}
