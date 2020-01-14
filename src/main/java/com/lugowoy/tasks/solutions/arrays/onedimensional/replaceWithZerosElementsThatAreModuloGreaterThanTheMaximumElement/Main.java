package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceWithZerosElementsThatAreModuloGreaterThanTheMaximumElement;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given integers a1, a2, ..., an. Among them there are positive and negative.
 * Replace the zeros with those numbers that they are more modular than a certain number (| ai |> max {a1, a2, ..., an}).
 * <p> Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original sequence : " + array);

        int maximumNumberElement = 0;

        if (Arrays.stream(array.toArray(new int[array.size()])).max().isPresent()) {
            maximumNumberElement = Arrays.stream(array.toArray(new int[array.size()])).max().getAsInt();
        }

        System.out.println("Result sequence : ");
        int finalMaximumNumberElement = maximumNumberElement;
        Arrays.stream(array.toArray(new int[array.size()])).forEachOrdered(integer -> {
            if (finalMaximumNumberElement != 0) {
                if (Math.abs(integer) > finalMaximumNumberElement) {
                    integer = 0;
                }
            }
            System.out.print(integer + " ");
        });

    }

}
