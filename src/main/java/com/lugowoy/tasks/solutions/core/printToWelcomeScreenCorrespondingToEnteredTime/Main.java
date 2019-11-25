package com.lugowoy.tasks.printToWelcomeScreenCorrespondingToEnteredTime;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.checkCorrectnessOfEnteredTimeData.Checker;
import com.lugowoy.tasks.checkCorrectnessOfEnteredTimeData.CheckerHours;
import com.lugowoy.tasks.checkCorrectnessOfEnteredTimeData.CheckerMinutes;
import com.lugowoy.tasks.checkCorrectnessOfEnteredTimeData.CheckerSeconds;

/**
 * The time (hours and minutes) is entered - the program displays a greeting corresponding to the entered time
 * (for example, entered 15 hours 6 minutes - the greeting "good day" is displayed).
 * <p>
 * Created by Konstantin Lugowoy on 04.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter hours : ");
        int hours = READER.readInt();
        System.out.println("Enter minutes : ");
        int minutes = READER.readInt();
        System.out.println("Enter seconds : ");
        int seconds = READER.readInt();

        Checker checker = CheckerHours::checkCorrectHours;
        if (checker.check(hours)) {
            checker = CheckerMinutes::checkCorrectMinutes;
            if (checker.check(minutes)) {
                checker = CheckerSeconds::checkCorrectSeconds;
                if (checker.check(seconds)) {
                    Printer printer = new PrinterWelcomeCorrespondingToEnteredTime(hours);
                    printer.print();
                } else {
                    System.out.println("The value of seconds is invalid.");
                }
            } else {
                System.out.println("The value of minutes is invalid.");
            }
        } else {
            System.out.println("The value of hours is invalid.");
        }

    }

}
