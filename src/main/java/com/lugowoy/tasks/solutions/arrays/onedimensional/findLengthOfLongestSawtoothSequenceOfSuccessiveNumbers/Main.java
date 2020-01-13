package com.lugowoy.tasks.solutions.arrays.onedimensional.findLengthOfLongestSawtoothSequenceOfSuccessiveNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Find the length of the longest "sawtooth" sequence of successive numbers Xk <Xk + 1> Xk + 2> ...> Xk + m <Xk + m + 1 <... <Xn.
 * <p> Created by Konstantin Lugowoy on 27.06.2017.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);

        System.out.printf("The length of the longest sawtooth sequence is %d .", getLengthSawOfArrayElements(array));

    }

    private static int getLengthSawOfArrayElements(ArrayInts array) {
        int lengthSaw = 0, maxLengthSaw = 0;
        boolean isPrev = false;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 1; i < array.size() - 1; i++) {
                if ((array.get(i - 1) < array.get(i))
                        && (array.get(i) > array.get(i + 1))) {
                    if (isPrev) {
                        lengthSaw += 2;
                    } else {
                        lengthSaw = 3;
                        isPrev = true;
                    }
                    i++;
                } else {
                    isPrev = false;
                    maxLengthSaw = Math.max(maxLengthSaw, lengthSaw);
                }
            }
        }
        return Math.max(maxLengthSaw, lengthSaw);
    }

}
