package com.lugowoy.tasks.determineAffiliationOfCertainValueToConcreteInterval;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that displays messages about the belonging of some value of k to the intervals (-10k, 0], (0, 5], (5, 10], (10, 10k].
 * <p>
 * Created by Konstantin Lugowoy on 14.09.2018
 */

public class Main {

    private static final String[] INTERVALS = {"(-10000, 0]", "(0, 5]", "(5, 10]", "(10, 10000]",
                                               "(-10000, 5]", "[0, 10]", "[5, 15]", "[10, 10000]"};

    public static void main(String[] args) {

        System.out.println("Enter value to check : ");
        int valueToCheck = Reader.getReader(new ReadingConsole()).readInt();

        determineAffiliationOfCertainValueToConcreteInterval(valueToCheck, INTERVALS);

    }

    private static void determineAffiliationOfCertainValueToConcreteInterval(int valueToCheck, String... intervals) {
        boolean isNotBelongToIntervals = true;
        for (String str : intervals) {
            switch (str) {
                case "(-10000, 0]":
                    if (valueToCheck > -10000 && valueToCheck <= 0) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : (-10000, 0].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "(-10000, 5]":
                    if (valueToCheck > -10000 && valueToCheck <= 5) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : (-10000, 5].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "(0, 5]":
                    if (valueToCheck > 0 && valueToCheck <= 5) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : (0, 5].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "(5, 10]":
                    if (valueToCheck > 5 && valueToCheck <= 10) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : (5, 10].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "[0, 10]":
                    if (valueToCheck >= 0 && valueToCheck <= 10) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : [0, 10].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "[5, 15]":
                    if (valueToCheck >= 5 && valueToCheck <= 15) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : [5, 15].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "(10, 10000]":
                    if (valueToCheck > 10 && valueToCheck <= 10000) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : (10, 10000].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                case "[10, 10000]":
                    if (valueToCheck >= 10 && valueToCheck <= 10000) {
                        System.out.println("The value " + valueToCheck + " is included in the interval : [10, 10000].");
                        isNotBelongToIntervals = false;
                    }
                    break;
                default:
                    System.err.println("Incorrect intervals.");
                    return;
            }
        }
        if (isNotBelongToIntervals) {
            System.out.println("The value does not included into one of the intervals.");
        }
    }

}
