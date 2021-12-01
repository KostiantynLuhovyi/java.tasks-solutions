package com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Write a program that enter a sequence of integers that counts them as the
 * masses of objects available and finds out whether all these items can be put
 * on two cups of the weighing-machine so that achieve balance.
 *
 * <p> Created by Konstantin Lugowoy on 27.05.2018.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();

        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        Array<Subject> subjectArray = new Array<>(new FillingArraySubjects(BOUND).fill(lengthArray));

        new Executor().execute(() -> {
            System.out.println("The array of subjects : " + subjectArray);
            Determinant determinant = Determinant::determineEquilibriumBetweenWeightOfSubjects;
            if (determinant.determine(subjectArray)) {
                System.out.println("Scales are in equilibrium.");
            } else {
                System.out.println("Scales is not in equilibrium.");
            }
        }, new OutputExecutionTimeToConsole());

    }

}
