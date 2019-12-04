package com.lugowoy.tasks.solutions.core.outputNumbersThatAreDivisibleByThreeAndNine;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Output numbers that are divisible by 3 and 9.
 * <p>
 * Created by Konstantin Lugowoy on 13.07.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray));

        System.out.println("Numbers : " + array);

        System.out.println("Numbers that are divisible by 3 and by 9 : ");

        Array<Integer> resultNumbers = printNumbersThatAreDivisibleByThreeAndNine(array);

        if (resultNumbers.size() == 0) {
            System.out.print("There are no such numbers.");
        } else {
            System.out.println("Result " + resultNumbers);
        }

    }

    private static Array<Integer> printNumbersThatAreDivisibleByThreeAndNine(Array<Integer> array) {
        Array<Integer> resultArray = new Array<>(0);
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i) % 3 == 0) && (array.get(i) % 9 == 0)) {
                resultArray.add(array.get(i));
            }
        }
        return resultArray;
    }

}
