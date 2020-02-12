package com.lugowoy.tasks.solutions.arrays.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.models.storages.arrays.AbstractArray.DEFAULT_LENGTH;

/**
 * Given integers a1, a2, ..., an and b1, b2, ..., bn.
 * Convert the sequence b1, b2, ..., bn by the rule: if ai ≤ 0, then bi is increased by a factor of 10 otherwise bi is replaced by zero.
 * <p> Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        ArrayInts firstArray = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(DEFAULT_LENGTH, LOWER_BOUND, UPPER_BOUND));
        System.out.println("First sequence : " + firstArray);
        System.out.println();

        ArrayInts secondArray = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(DEFAULT_LENGTH, LOWER_BOUND, UPPER_BOUND));
        System.out.println("Second sequence : " + secondArray);
        System.out.println();

        Executor.execute(() -> ConvertingSequenceByRule.convertSecondSequenceByRuleDefinedByFirstSequence(firstArray, secondArray),
                                                                                  ExecutionTimeOutputToConsole::outputExecutionTime);

    }

}
