package com.lugowoy.tasks.solutions.arrays.onedimensional.outputToDisplayNumberForParticularCondition;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given numbers a1 a2, .... an. Print out only the number, for which the condition ai ≤ i.
 * <p> Created by Konstantin Lugowoy on 14-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Numbers numbers = new Numbers(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

        System.out.println();

        System.out.println("Result : ");
        DISPLAY.show(numbers);

    }

    private static final Display DISPLAY = numbers -> {
        /*int firstValue = numbers.getNumbers()[0];*/
        for (int i = 0; i < numbers.getNumbers().length; i++) {
            if (/*firstValue*/numbers.getNumbers()[i] <= i) {
                System.out.println(i + " : " + numbers.getNumbers()[i]);
            }
        }
    };

}
