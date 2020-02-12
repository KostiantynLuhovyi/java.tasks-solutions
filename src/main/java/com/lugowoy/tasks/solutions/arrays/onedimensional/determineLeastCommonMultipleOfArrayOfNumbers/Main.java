package com.lugowoy.tasks.solutions.arrays.onedimensional.determineLeastCommonMultipleOfArrayOfNumbers;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Write a program that enter an array of integers, finds and prints their least common multiple a number.
 * <p> Created by Konstantin Lugowoy on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray));

        System.out.println("Array " + array);

        DeterminantLeastCommonMultiple determinantLCM = DeterminantLeastCommonMultiple::determineLeastCommonMultiple;
        System.out.println("The least common multiple of the array is : " + determinantLCM.determine(array));

    }

}
