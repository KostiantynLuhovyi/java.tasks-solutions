package com.lugowoy.tasks.solutions.arrays.onedimensional.determineLeastCommonMultipleArrayOfNumbers;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Write a program that enter an array of integers, finds and prints their least
 * common multiple a number.
 *
 * <p>Created by Konstantin Lugowoy on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();

        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(new FillingArrayRandomPrimitiveIntegers(),
                                                             lengthArray,
                                                             HelperFillerValues.INT_NEGATIVE_HUNDRED,
                                                             HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array " + array);

        DeterminantLeastCommonMultiple<ArrayInts> determinantLCM =
                DeterminantLeastCommonMultiple::determineLeastCommonMultiple;
        System.out.println("The least common multiple of the array is : "
                           + determinantLCM.determine(array));

    }

}
