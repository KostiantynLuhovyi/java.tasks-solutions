package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumbersFromArrayThatSatisfyConditionForSolutionOfTask;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Write a program that has an array of random integers
 * and prints three of its (not necessarily distinct) elements x, y, and z, such that x * y = z.
 * <p> Created by Konstantin Lugowoy on 25.04.2018.
 */
public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        System.out.println("Result : ");
        printExpressionWithNumbersSatisfyingCondition(array);

    }

    private static void printExpressionWithNumbersSatisfyingCondition(ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            int countExpression = 0;
            for (int i = 0; i < array.size(); i++) {
                for (int j = i + 1; j < array.size(); j++) {
                    for (int k = 0; k < array.size(); k++) {
                        if (array.get(i) * array.get(j) == array.get(k)) {
                            System.out.printf("Expression: %d * %d = %d.\n", array.get(i), array.get(j), array.get(k));
                            countExpression++;
                        }
                    }
                }
                if (countExpression == 0) {
                    System.out.println("No numbers were found to evaluate the expression by condition.");
                }
            }
        }
    }

}