package com.lugowoy.tasks.printNumbersWhoseLengthIsLessThanAverage;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;

/**
 * Print numbers whose length is less than the average.
 * <p>
 * Created by Konstantin Lugowoy on 09.08.2018.
 */

public class Main {

    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomInteger().fill(lengthOfArray, MAX_VALUE));

        System.out.println("Numbers in an array : " + integerArray);

        double valueOfArithmeticMeanLengthOfAllNumbers = calculateArithmeticMeanOfLengthsOfAllNumbers(integerArray);
        System.out.println("Result arithmetic mean of length of all numbers : " + valueOfArithmeticMeanLengthOfAllNumbers);

        System.out.println("Numbers that are less than the average of the lengths of all numbers : ");
        printNumbersWhoseLengthIsLessThanAverage(integerArray, valueOfArithmeticMeanLengthOfAllNumbers);


    }

    private static void printNumbersWhoseLengthIsLessThanAverage(Array<Integer> integerArray, double valueArithmeticMean) {
        for (int i = 0; i < integerArray.getLength(); i++) {
            int valueOfNumber = integerArray.get(i);
            int valueDigitOfNumber = countDigitOfNumber(valueOfNumber);
            if (valueDigitOfNumber < valueArithmeticMean) {
                System.out.print(valueOfNumber + " ");
            }
        }
    }

    private static double calculateArithmeticMeanOfLengthsOfAllNumbers(Array<Integer> integerArray) {
        double resultToCalculateArithmeticMean = 0;
        for (int i = 0; i < integerArray.getLength(); i++) {
            resultToCalculateArithmeticMean += countDigitOfNumber(integerArray.get(i));
        }
        return resultToCalculateArithmeticMean / integerArray.getLength();
    }

    private static int countDigitOfNumber(int number) {
        int moduleOfNumber = Math.abs(number);
        int digitCount = 0;
        while (moduleOfNumber > 0) {
            moduleOfNumber /= 10;
            digitCount++;
        }
        return digitCount;
    }

}
