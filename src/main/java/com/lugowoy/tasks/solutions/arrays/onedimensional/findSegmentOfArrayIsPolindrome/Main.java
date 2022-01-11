package com.lugowoy.tasks.solutions.arrays.onedimensional.findSegmentOfArrayIsPolindrome;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Given an array A. Find the segment of the maximum length array in which the first number equals the last,
 * the second number equal the penultimate, and so on.
 * Output this segment and its length.
 *
 * <p>Created by Konstantin Lugowoy on 18.06.2017.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array : " + array + "\n");

        new Executor().execute(() -> {
            findSegmentOfArrayThatIsPalindrome(array);
        }, new OutputExecutionTimeToConsole());

    }

    private static void findSegmentOfArrayThatIsPalindrome(@NotNull final ArrayInts array) {
        int count = 1;
        for (int i = 0; i < count; i++) {
            boolean isPalindrome = false;
            if ((array.size() - count + 1) == 1) {
                isPalindrome = true;
            } else {
                for (int j = 0; j < ((array.size() - count + 1) / 2); j++) {
                    if (array.get(i + j) == array.get(i + array.size() - count - j)) {
                        if (j + 1 == (array.size() - count + 1) / 2) {
                            isPalindrome = true;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (isPalindrome) {
                int[] temp = Arrays.copyOfRange(array.toArray(
                        new int[array.size()]), i, array.size() - count + i + 1);
                if (temp.length > 1) {
                    System.out.println(Arrays.toString(temp) +
                                       ", length is equal " + temp.length);
                    return;
                } else {
                    System.out.println("In the array there is no segment that is a palindrome.");
                    return;
                }
            }
            if (i + 1 == count) {
                i = 0;
                count++;
            }
        }
    }

}
