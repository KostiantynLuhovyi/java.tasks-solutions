package com.lugowoy.tasks.solutions.arrays.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Find subset of contiguous elements of array sum of values of elements which is equal to number.
 * <p> Created by Konstantin Lugowoy on 18.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_UPPER_BOUND));

        System.out.println("Original " + array);

        int number = enterNumber();

        Finding finding = Finding::findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

        ArrayInts resultArray = new ArrayInts(finding.find(array, number));

        if (CheckerArray.checkLengthInArray(resultArray)) {
            System.out.println("Result : " + resultArray);
        } else{
            System.out.println("An array does not contain such a sequence of elements.");
        }

    }

    private static int enterNumber() {
        System.out.println("Enter number : ");
        ReadingConsole reader = new ReadingConsole();
        int number;
        while (true) {
            number = reader.readInt();
            if ((number >= 0) && (number <= 200)) {
                break;
            } else {
                System.out.println("Number must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return number;
    }

}
