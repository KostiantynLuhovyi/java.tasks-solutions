package com.lugowoy.tasks.solutions.arrays.onedimensional.compareModulesOfProductOfDifferentNumbersInArray;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * In the sequence of integers a1, a2, ..., an, there are positive and negative
 * elements. Calculate the multiplication of negative elements P1 and the
 * multiplication of positive elements P2. Compare the module P2 with the module
 * P1 and indicate which of the products is larger modulo.
 *
 * <p>Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        int lengthArray = Helper.readConsoleArrayLength(
                Helper.INPUT_LENGTH_ARRAY, Capacity.UPPER.get());

        ArrayInts array = new ArrayInts(new HelperFiller().getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Array : " + array + "\n");

        Helper.EXECUTOR.execute(() -> {

            ProductArrayNumbers product = ProductArrayNumbers::productNegativeNumbers;
            int moduleNegativeNumbersArray = Math.abs(product.product(array));

            product = ProductArrayNumbers::productPositiveNumbers;
            int modulePositiveNumbersArray = Math.abs(product.product(array));

            if (moduleNegativeNumbersArray > modulePositiveNumbersArray) {
                System.out.println("Module product negative numbers of the array"
                                   + "is larger module product positive numbers.");
            } else if (modulePositiveNumbersArray > moduleNegativeNumbersArray) {
                System.out.println("Module product positive numbers of the array"
                                   + "is larger module product negative numbers.");
            }

        }, new OutputExecutionTimeToConsole());

    }

}
