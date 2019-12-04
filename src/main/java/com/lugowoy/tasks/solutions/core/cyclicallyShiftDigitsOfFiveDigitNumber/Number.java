package com.lugowoy.tasks.solutions.core.cyclicallyShiftDigitsOfFiveDigitNumber;

/**
 * Created by Konstantin Lugowoy on 06.03.2017.
 */

public class Number {

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if ((number >= 1) && (number <= 99999)) {
            this.number = number;
        } else {
            System.out.println("Incorrect number. Repeat : ");
            this.number = -1;
        }
    }

}
