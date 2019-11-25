package com.lugowoy.tasks.showNumbersAndTotalNumberOfAllSixDigitHappyTickets;

/**
 * Show the numbers and the total number of all the happy tram tickets with six-digit numbers.
 * <p>
 * Created by Konstantin Lugowoy on 21.10.2017.
 */

public class Main {

    public static void main(String[] args) {

        Display display = Display::displayAllHappyTickets;
        display.display();

    }

}
