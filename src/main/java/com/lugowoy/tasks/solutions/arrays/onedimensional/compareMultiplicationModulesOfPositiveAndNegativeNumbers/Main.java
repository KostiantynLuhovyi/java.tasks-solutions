package com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.Multiplication;
import com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationNegativeNumbers;
import com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationPositiveNumbers;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * In the sequence of integers a1, a2, ..., an, there are positive and negative elements.
 * Calculate the multiplication of negative elements P1 and the multiplication of positive elements P2.
 * Compare the module P2 with the module P1 and indicate which of the products is larger modulo.
 * <p> Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Multiplication<ArrayInts> multiplication = MultiplicationNegativeNumbers::multiplication;
        int resultModuleOfNegativeNumbers = Math.abs(multiplication.multiply(array));

        multiplication = MultiplicationPositiveNumbers::multiplication;
        int resultModuleOfPositiveNumbers = Math.abs(multiplication.multiply(array));

        if (resultModuleOfNegativeNumbers > resultModuleOfPositiveNumbers) {
            System.out.println("Multiplication negative numbers on the module larger positive numbers.");
        } else if (resultModuleOfPositiveNumbers > resultModuleOfNegativeNumbers) {
            System.out.println("Multiplication positive numbers on the module larger negative numbers.");
        }

    }

}
