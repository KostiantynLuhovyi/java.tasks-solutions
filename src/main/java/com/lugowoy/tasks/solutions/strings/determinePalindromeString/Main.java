package com.lugowoy.tasks.solutions.strings.determinePalindromeString;

import com.lugowoy.helper.filling.array.strings.FillingArrayReadValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Determine a palindrome string. If there are more than one such lines, determine the second one.
 * <p> Created by LugowoyKonstantin on 28.09.2018.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter strings : ");
        FillingArrayReadValueStrings filler = new FillingArrayReadValueStrings(new ReadingConsole());

        Array<String> stringArray = new Array<>(filler.fill(lengthArray));

        System.out.println("Strings in an array : " + stringArray);

        String valuePalindrome = determinePalindromeString(stringArray);
        if (valuePalindrome.equals("")) {
            System.out.println("Palindrome string not found.");
        } else {
            System.out.println("Result palindrome string : " + determinePalindromeString(stringArray));
        }

    }

    private static String determinePalindromeString(Array<String> stringArray) {
        int countPalindrome = 0;
        String stringValue;
        String resultValuePalindrome = "";
        System.out.println(stringArray.size());
        for (int i = 0; i < stringArray.size(); i++) {
            stringValue = stringArray.get(i);
            if (isPalindromeString(stringValue)) {
                if (countPalindrome == 1) {
                    resultValuePalindrome = stringValue;
                    break;
                }
                resultValuePalindrome = stringValue;
                countPalindrome++;
            }
        }
        return resultValuePalindrome;
    }

    private static boolean isPalindromeString(String str) {
        boolean isPalindrome = false;
        int i = 0;
        int j = str.length() - 1;
        System.out.println(j);
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
            } else {
                isPalindrome = true;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }

}
