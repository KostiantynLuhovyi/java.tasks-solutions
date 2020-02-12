package com.lugowoy.tasks.solutions.arrays.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Write a program that enter a sequence of integers that finds and prints their greatest common divisor.
 * <p> Created by Konstantin Lugowoy on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray));

        System.out.println(array);

        DeterminantGreatestCommonDivisor determinantGCD = DeterminantGreatestCommonDivisor::determineGreatestCommonDivisor;
        System.out.println("The greatest common divisor of the array is : " + determinantGCD.determine(array));
    }

}
