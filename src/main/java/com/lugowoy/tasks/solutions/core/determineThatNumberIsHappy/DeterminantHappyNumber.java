package com.lugowoy.tasks.determineThatNumberIsHappy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin Lugowoy on 17.08.2017.
 */

public interface DeterminantHappyNumber {

    boolean determine(int number);

    static boolean determineThatNumberIsHappy(int number) {
        boolean result = false;
        List<Integer> happyNumbers = getListOfHappyNumbers(number);
        fillListOfHappyNumbers(happyNumbers);
        if (happyNumbers.contains(number)) {
            result = true;
        }
        return result;
    }

    private static void fillListOfHappyNumbers(List<Integer> integerList) {
        int currentLuckyNumber = integerList.get(1);
        int indexCurrentLuckyNumber = 1;
        int offset = 1;
        while (indexCurrentLuckyNumber < integerList.size() - offset) {
            int deleteNumberIndex = currentLuckyNumber - offset;
            while (deleteNumberIndex < integerList.size()) {
                integerList.remove(deleteNumberIndex);
                deleteNumberIndex += currentLuckyNumber - offset;
            }
            if (indexCurrentLuckyNumber < integerList.size()) {
                currentLuckyNumber = integerList.get(++indexCurrentLuckyNumber);
            } else {
                break;
            }
        }
    }

    private static List<Integer> getListOfHappyNumbers(int number) {
        List<Integer> list;
        number += 10;
        if (checkEvenNumber(number)) {
            list = fillListOddNumbers(number);
        } else {
            number += 1;
            list = fillListOddNumbers(number);
        }
        return list;
    }

    private static List<Integer> fillListOddNumbers(int number) {
        List<Integer> list = new ArrayList<>(0);
        for (int i = 1; i <= number; i += 2) {
            list.add(i);
        }
        return list;
    }

    private static boolean checkEvenNumber(int number) {
        boolean result = false;
        if (number % 2 == 0) {
            result = true;
        }
        return result;
    }

}
