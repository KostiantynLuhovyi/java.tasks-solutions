package com.lugowoy.tasks.solutions.core.countNumberOfOccurrencesOfMaximumNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayReadIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

public class Main {

    public static void main(String[] args) {

        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Numbers numbers = new Numbers(new FillingArrayReadIntegers(new ReadingConsole()).fill(lengthOfArray));

        Counting counting = CountingNumbers::countMaximumNumbers;

        for (int i = 0; i < numbers.getNumbers().length; i++) {
            numbers.setMaxNumberCount(counting.countMaximumNumbers(numbers.getNumbers()[i]));
        }

        System.out.printf("Count maximum number among the input : %d .", numbers.getMaxNumberCount());

    }

}
