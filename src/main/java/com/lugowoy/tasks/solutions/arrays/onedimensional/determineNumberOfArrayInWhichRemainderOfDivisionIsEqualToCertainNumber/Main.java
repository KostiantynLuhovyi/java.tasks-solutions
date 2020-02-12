package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Determine the number of the array in which the number is equal to dividing a certain number.
 * <p> Created by Konstantin Lugowoy on 14-Feb-17.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int LOWER_BOUND = -200;
    private static final int UPPER_BOUND = 300;

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, LOWER_BOUND, UPPER_BOUND));

        System.out.println(array);

        System.out.println("Enter number to the modulo : ");
        int numberToModulo = READER.readInt();

        System.out.println("Enter result to the modulo : ");
        int resultModulo = READER.readInt();

        DETERMINANT.determinate(array, numberToModulo, resultModulo);
    }

    private static final Determinant DETERMINANT = (array, numberToModulo, resultModulo) -> {
        System.out.println("Result to the modulo operation : ");
        int countResult = 0;
        for (int number : array.toArray(new int[array.size()])) {
            if (number % numberToModulo == resultModulo) {
                System.out.print(number + " ");
            } else {
                countResult++;
            }
        }
        if (countResult == array.size()) {
            System.out.println("No numbers which satisfy the condition.");
        }
    };

}
