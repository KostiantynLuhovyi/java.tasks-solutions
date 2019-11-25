package com.lugowoy.tasks.printDayOfWeekAccordingToNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that prompts the user to enter the day of the week number,
 * and in response displays the name of that day (for example, 6 is Saturday).
 * Solve using if and switch.
 * <p>
 * Created by Konstantin Lugowoy on 01.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the day of the week number : ");
        int numberDay;
        while (true) {
            numberDay = READER.readInt();
            if ((numberDay >= 1) && (numberDay <= 7)) {
                PrinterDayOfWeek printer = PrinterDayOfWeek::printDayOfWeekAccordingToNumberToUseSwitchInstruction;
                System.out.println("The entered value corresponds to the day of the week : " + printer.print(numberDay));
                break;
            } else {
                System.out.println("Invalid value day of the week number.");
                break;
            }
        }

    }

}
