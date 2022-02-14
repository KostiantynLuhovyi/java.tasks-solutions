package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * In the array, each element is 0, 1, 2.
 * Rearrange the elements of the array so that all zeros are first, then all the ones, and finally all the deuces.
 *
 * <p>Created by Konstantin Lugowoy on 17.06.2017.
 */
public class Main {

    private static final int BOUND = 2;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                                                        HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Original " + array + "\n");

        Sorting<ArrayInts> sorting = Sorting::sortArray;
        sorting.sort(array);

        System.out.println("After sort " + array);

    }

}
