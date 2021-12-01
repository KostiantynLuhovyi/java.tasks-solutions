package com.lugowoy.tasks.solutions.arrays.onedimensional.compareModulesOfProductOfDifferentNumbersInArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

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

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Array : " + array + "\n");

        new Executor().execute(() -> {
            ProductArrayNumbers<ArrayInts> product =
                    ProductArrayNumbers::productNegativeNumbers;
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
