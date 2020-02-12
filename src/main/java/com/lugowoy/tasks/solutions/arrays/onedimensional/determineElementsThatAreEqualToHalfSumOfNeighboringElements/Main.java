package com.lugowoy.tasks.solutions.arrays.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Determine the elements that are equal to the half-sum of the neighboring elements.
 * <p> Created by Konstantin Lugowoy on 03.09.2017.
 */
public class Main {

    private static final Determinant DETERMINANT = Determinant::determineElementsThatEqualToHalfSumOfNeighboringElements;

    private static final int BOUND = 20;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);

        System.out.println("Result : ");
        DETERMINANT.determine(array);

    }

}
