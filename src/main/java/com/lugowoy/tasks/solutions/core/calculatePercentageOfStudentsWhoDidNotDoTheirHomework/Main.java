package com.lugowoy.tasks.solutions.core.calculatePercentageOfStudentsWhoDidNotDoTheirHomework;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The teacher enters from the keyboard the number of students who submitted homework and the number of those who did not pass.
 * Calculate how many percent of students who did not pass their homework from the total number of students.
 *
 * <p> Created by Konstantin Lugowoy on 17.06.2017.
 */

public class Main {

    public static void main(String[] args) {

        int numberOfStudentsWhoDidTheirHomework = enterNumberOfStudents("Enter the number of students who did their homework :");

        int numberOfStudentsWhoDidNotDoTheirHomework = enterNumberOfStudents("Enter the number of students who did not do their homework :");

        double percentageOfStudentsWhoDidNotDoTheirHomework = calculatePercentageOfStudentsWhoDidNotDoTheirHomework(numberOfStudentsWhoDidTheirHomework, numberOfStudentsWhoDidNotDoTheirHomework);

        System.out.printf("Percentage of students who did not do their homework : %.2f", percentageOfStudentsWhoDidNotDoTheirHomework);

    }

    private static double calculatePercentageOfStudentsWhoDidNotDoTheirHomework(int numberOfStudentsWhoDidTheirHomework,
                                                                                int numberOfStudentsWhoDidNotDoTheirHomework) {
        return (double) (numberOfStudentsWhoDidTheirHomework + numberOfStudentsWhoDidNotDoTheirHomework)
                                                                       * numberOfStudentsWhoDidNotDoTheirHomework / 100;
    }

    private static int enterNumberOfStudents(String msg) {
        Reader reader = new Reader(new ReadingConsole());
        int numberOfStudents;

        System.out.println(msg);
        while (true) {
            numberOfStudents = reader.readInt();
            if (numberOfStudents >= 0) {
                break;
            } else {
                System.out.println("Number of students must be a positive number or is equal zero.");
                System.out.println("Re-enter : ");
            }
        }
        return numberOfStudents;
    }

}

