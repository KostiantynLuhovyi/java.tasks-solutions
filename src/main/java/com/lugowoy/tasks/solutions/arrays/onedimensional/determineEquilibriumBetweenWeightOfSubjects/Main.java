package com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Write a program that enter a sequence of integers that counts them as the masses of objects available
 * and finds out whether all these items can be put on two cups of the weighing-machine so that achieve balance.
 * <p> Created by Konstantin Lugowoy on 27.05.2018.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        Array<Integer> integerArray = new Array<>(Helper.FILLER_ARRAY_INTEGERS.fill(lengthOfArray, BOUND));

        System.out.println("The array of integer numbers : " + integerArray);

        Array<Subject> subjectArray = new Array<>(new FillingArraySubjects(integerArray).fill(lengthOfArray));

        System.out.println("The array of subjects : " + subjectArray);

        Determinant determinant = Determinant::determineEquilibriumBetweenWeightOfSubjects;
        if (determinant.determine(subjectArray)) {
            System.out.println("Scales are in equilibrium.");
        } else {
            System.out.println("Scales is not in equilibrium.");
        }

    }

}
