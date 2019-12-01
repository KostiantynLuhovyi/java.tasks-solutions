package com.lugowoy.tasks.solutions.arrays.onedimensional.findSegmentOfArrayIsPolindrome;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;
import java.util.Objects;

/**
 * Given an array A. Find the segment of the maximum length array in which the first number equals the last,
 * the second the penultimate, and so on.
 * Output this segment and its length.
 *
 * <p> Created by Konstantin Lugowoy on 18.06.2017.
 */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);

        getPalindromeAndLength(array);

    }

    private static void getPalindromeAndLength(ArrayInts array) {
        int count = 1;
        for (int i = 0; i < count; i++) {
            boolean isPalindrome = false;
            if ((array.size() - count + 1) == 1) {
                isPalindrome = true;
            } else {
                for (int j = 0; j < (array.size() - count + 1) / 2; j++) {
                    if (Objects.equals(array.get(i + j), array.get(i + array.size() - count - j))) {
                        if (j + 1 == (array.size() - count + 1) / 2) {
                            isPalindrome = true;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (isPalindrome) {
                int[] temp = Arrays.copyOfRange(array.toArray(new int[array.size()]), i, array.size() - count + i + 1);
                if (temp.length > 1) {
                    System.out.println(Arrays.toString(temp) + ", length is equal " + temp.length);
                    return;
                } else {
                    System.out.println();
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
