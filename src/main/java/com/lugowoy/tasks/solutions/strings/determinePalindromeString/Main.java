package com.lugowoy.tasks.solutions.strings.determinePalindromeString;

import com.lugowoy.helper.filling.array.strings.FillingArrayReadingValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Determine a palindrome string. If there are more than one such lines, determine the second one.
 *
 * <p> Created by LugowoyKonstantin on 28.09.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter strings : ");
        Array<String> stringArray = new Array<>(new FillingArrayReadingValueStrings(new ReadingConsole()).fill(lengthOfArray));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result : " + determinePalindromeString(stringArray));

    }

    private static String determinePalindromeString(Array<String> stringArray) {
        int countResultString = 0;
        String resultString = "";
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                String str = stringArray.get(i);
                char[] chars = str.toCharArray();
                int firstIndex = 0;
                int secondIndex = chars.length - 1;
                while (secondIndex > firstIndex) {
                    if (chars[firstIndex] == chars[secondIndex]) {
                        resultString = str;
                    } else {
                        resultString = "";
                        break;
                    }
                    ++firstIndex;
                    --secondIndex;
                }
                if (!resultString.equals("")) {
                    countResultString++;
                    if (countResultString == 2) {
                        break;
                    }
                }
            }
        }
        return resultString;
    }

}
