package com.lugowoy.tasks.printLongestNumber;

import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 08.08.2018.
 */

public interface DeterminantLongestNumber {

    int determine(Array<Integer> integerArray);

    static int determineLongestNumberOfNumbers(Array<Integer> integerArray) {
        int resultNumber = Integer.MIN_VALUE;
        int digitCount = 0, resultNumberDigitCount = 0;
        for (int i = 0; i < integerArray.getLength(); i++) {
            int number = Math.abs(integerArray.get(i));
            digitCount = countDigitOfNumber(digitCount, number);
            if (resultNumberDigitCount < digitCount) {
                resultNumberDigitCount = digitCount;
                resultNumber = number;
            }
            digitCount = 0;
        }
        return resultNumber;
    }

    static int determineLongestNumberOfStrings(Array<String> stringsArray) {
        int resultNumber = Integer.MIN_VALUE;
        StringBuilder numberOfString = new StringBuilder();
        int digitCount = 0, resultNumberDigitCount = 10;
        for (int i = 0; i < stringsArray.getLength(); i++) {
            String number = Integer.toString(Math.abs(Integer.parseInt(stringsArray.get(i))));
            digitCount = countDigitOfNumberOfString(numberOfString, digitCount, number);
            if (resultNumberDigitCount < digitCount) {
                resultNumberDigitCount = digitCount;
                resultNumber = Integer.parseInt(numberOfString.toString());
            }
            digitCount = 0;
            numberOfString.delete(0, numberOfString.length());
        }
        return resultNumber;
    }

    static int countDigitOfNumber(int digitCount, int number) {
        int moduleOfNumber = Math.abs(number);
        while (moduleOfNumber > 0) {
            moduleOfNumber /= 10;
            digitCount++;
        }
        return digitCount;
    }

    static int countDigitOfNumberOfString(StringBuilder numberOfString, int digitCount, String number) {
        for (int j = 0; j < number.length(); j++) {
            numberOfString.append(number.charAt(j));
            digitCount++;
        }
        return digitCount;
    }

}
