package com.lugowoy.tasks.solutions.core.determineWhetherValueBelongsToCertainInterval;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Determine if K belongs to a certain interval (n,m],[n,m),(n,m),[n,m].
 * <p>
 * Created by Konstantin Lugowoy on 14.09.2018
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the minimum value for the interval : ");
        int minValueForInterval = READER.readInt();

        System.out.println("Enter the maximum value for the interval : ");
        int maxValueForInterval = READER.readInt();

        if (minValueForInterval < maxValueForInterval) {
            System.out.println("Enter a value to check for the interval : ");
            int valueToCheck = READER.readInt();
            printResultsOfCheckToSeeIfValueBelongsToSpecificInterval(minValueForInterval, maxValueForInterval, valueToCheck);
        } else {
            System.err.println("Incorrect minimum or maximum value of the interval.");
        }

    }

    private static void printResultsOfCheckToSeeIfValueBelongsToSpecificInterval(int minValueForInterval, int maxValueForInterval, int valueToCheck) {
        int countOfCheckValue = 0;
        if (valueToCheck > minValueForInterval && valueToCheck <= maxValueForInterval) {
            System.out.println("The value " + valueToCheck + " is included in the interval : (" + minValueForInterval + "," + maxValueForInterval + "].");
            countOfCheckValue++;
        }
        if (valueToCheck >= minValueForInterval && valueToCheck < maxValueForInterval) {
            System.out.println("The value " + valueToCheck + " is included in the interval : [" + minValueForInterval + "," + maxValueForInterval + ").");
            countOfCheckValue++;
        }
        if (valueToCheck > minValueForInterval && valueToCheck < maxValueForInterval) {
            System.out.println("The value " + valueToCheck + " is included in the interval : (" + minValueForInterval + "," + maxValueForInterval + ").");
            countOfCheckValue++;
        }
        if (valueToCheck >= minValueForInterval && valueToCheck <= maxValueForInterval) {
            System.out.println("The value " + valueToCheck + " is included in the interval : [" + minValueForInterval + "," + maxValueForInterval + "].");
            countOfCheckValue++;
        }
        if (countOfCheckValue == 0) {
            System.out.println("The value does not belong to the intervals.");
        }
    }

}
