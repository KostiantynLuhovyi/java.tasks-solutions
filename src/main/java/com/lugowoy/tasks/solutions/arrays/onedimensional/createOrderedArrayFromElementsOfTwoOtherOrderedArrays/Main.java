package com.lugowoy.tasks.solutions.arrays.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given two ordered arrays A and B.
 * Form from the elements of these arrays an ordered array C.
 * <p> Created by Konstantin Lugowoy on 30.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        int lengthOfArray = Helper.enterArrayLengthToConsole();

        int[] firstInts = Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND);
        Arrays.sort(firstInts);
        ArrayInts firstArray = new ArrayInts(firstInts);
        System.out.println("First array : " + firstArray);

        int[] secondInts = Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND);
        Arrays.sort(secondInts);
        ArrayInts secondArray = new ArrayInts(secondInts);
        System.out.println("Second array : " + secondArray);

        Merging<ArrayInts> merging = Merging::mergeArrays;
        ArrayInts resultArray = merging.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);

    }

}
