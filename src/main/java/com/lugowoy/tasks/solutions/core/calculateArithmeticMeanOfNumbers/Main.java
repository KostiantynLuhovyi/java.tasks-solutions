package com.lugowoy.tasks.solutions.core.calculateArithmeticMeanOfNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayReadDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Write a program that finds the arithmetic mean of the three real numbers.
 *
 * <p> Created by Konstantin Lugowoy on 03-Dec-16.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter quantity numbers to calculate arithmetic mean of numbers : ");
        int quantityNumbers = ArrayLengthReader.readLength(READER);

        System.out.println("Enter numbers to calculate : ");
        Array<Double> array = new Array<>(new FillingArrayReadDoubles(READER).fill(quantityNumbers));

        System.out.println();
        System.out.println("You entered the numbers : ");
        for (double d : array) {
            System.out.print(d + " ");
        }

        System.out.println();

        double resultArithmeticMeanNumbers = 0d;
        for (double number : array) {
            resultArithmeticMeanNumbers += number;
        }
        resultArithmeticMeanNumbers /= array.size();

        System.out.printf("The arithmetic mean of the entered real numbers equals %f", resultArithmeticMeanNumbers);

    }

}
