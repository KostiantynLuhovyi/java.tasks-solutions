package com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

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

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Multiplication<ArrayInts, Integer> multiplication = Multiplication::multiplyNegativeNumbers;
        int resultModuleOfNegativeNumbers = Math.abs(multiplication.multiply(array));

        multiplication = Multiplication::multiplyPositiveNumbers;
        int resultModuleOfPositiveNumbers = Math.abs(multiplication.multiply(array));

        if (resultModuleOfNegativeNumbers > resultModuleOfPositiveNumbers) {
            System.out.println("Multiplication negative numbers on the module larger positive numbers.");
        } else if (resultModuleOfPositiveNumbers > resultModuleOfNegativeNumbers) {
            System.out.println("Multiplication positive numbers on the module larger negative numbers.");
        }

    }

}
