package com.lugowoy.tasks.solutions.core.determineHowMuchTimeIsLeftBeforeMidnight;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters the time in seconds from the beginning of the day from the keyboard.
 * Determine how much time (hours, minutes and seconds) is left until midnight.
 * <p>
 * Created by Konstantin Lugowoy on 17.06.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int SECONDS_IN_DAY = 86400;

    public static void main(String[] args) {

        int numberOfSecondsSinceTheBeginningOfTheDay = enterNumberOfSecondsSinceTheBeginningOfTheDay();

        int numberOfSecondsLeftInTheDay = SECONDS_IN_DAY - numberOfSecondsSinceTheBeginningOfTheDay;

        int hoursEndToTheDay = numberOfSecondsLeftInTheDay / 3600;
        int minutesEndToTheDay = numberOfSecondsLeftInTheDay / 60 - hoursEndToTheDay * 60;
        int secondsEndToTheDay = numberOfSecondsLeftInTheDay - minutesEndToTheDay * 60 - hoursEndToTheDay * 3600;

        System.out.printf("%d hours, %d minutes, %d seconds it remains until midnight.",
                                                              hoursEndToTheDay, minutesEndToTheDay, secondsEndToTheDay);

    }

    private static int enterNumberOfSecondsSinceTheBeginningOfTheDay() {
        int numberOfSecondsSinceTheBeginningOfTheDay;
        System.out.println("Enter number of seconds since the beginning of the day :");
        while (true) {
            numberOfSecondsSinceTheBeginningOfTheDay = READER.readInt();
            if ((numberOfSecondsSinceTheBeginningOfTheDay >= 0) && (numberOfSecondsSinceTheBeginningOfTheDay <= SECONDS_IN_DAY)) {
                break;
            } else {
                System.out.println("Number of seconds since the beginning of the day must be a positive number or not more 86400.");
                System.out.println("Re-enter : ");
            }
        }
        return numberOfSecondsSinceTheBeginningOfTheDay;
    }

}
