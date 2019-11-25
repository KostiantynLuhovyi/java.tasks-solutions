package com.lugowoy.tasks.deduceSumOfIntegerAndFractionalPartsOfTwoEnteredNumbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters two real numbers from the keyboard.
 * To deduce on the screen the sum of the integer and fractional parts of two numbers.
 * <p>
 * Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter first real number : ");
        double firstRealNumber = READER.readDouble();
        System.out.println();

        System.out.println("Enter second real number : ");
        double secondRealNumber = READER.readDouble();
        System.out.println();

        Summing<Double> summing = Summing::summationIntegerPartOfTwoNumbers;
        double resultSumOfIntegerPartsOfTwoNumbers = summing.summarize(firstRealNumber, secondRealNumber);

        summing = Summing::summationDigitPartOfTwoNumbers;
        double resultSumOfFractionalPartsOfTwoNumbers = summing.summarize(firstRealNumber, secondRealNumber);

        System.out.printf("The sum of the integer and fractional parts of the entered numbers %f and %f is : \n" +
                                                                      "sum of the integer parts : %f ;\n" +
                                                                      "sum of the fractional parts : %f .",
                                                                                firstRealNumber, secondRealNumber,
                                                                                resultSumOfIntegerPartsOfTwoNumbers,
                                                                                resultSumOfFractionalPartsOfTwoNumbers);

    }

}
