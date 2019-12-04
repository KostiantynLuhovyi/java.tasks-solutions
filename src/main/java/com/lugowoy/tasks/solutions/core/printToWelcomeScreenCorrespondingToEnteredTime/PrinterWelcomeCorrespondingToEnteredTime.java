package com.lugowoy.tasks.solutions.core.printToWelcomeScreenCorrespondingToEnteredTime;

/**
 * Created by Konstantin Lugowoy on 04.10.2017.
 */

public class PrinterWelcomeCorrespondingToEnteredTime extends PrinterWelcome {

    private final int hour;

    public PrinterWelcomeCorrespondingToEnteredTime(int hours) {
        this.hour = hours;
    }

    @Override
    public void print() {
        if ((this.hour >= 0) && (this.hour <= 5)) {
            super.setPrintText("Good night.");
            System.out.println(super.getPrintText());
        } else if ((this.hour >= 6) && (this.hour <= 11)) {
            super.setPrintText("Good morning.");
            System.out.println(super.getPrintText());
        } else if ((this.hour >= 12) && (this.hour <= 18)) {
            super.setPrintText("Good day.");
            System.out.println(super.getPrintText());
        } else if ((this.hour >= 19) && (this.hour <= 23)) {
            this.setPrintText("Good evening.");
            System.out.println(super.getPrintText());
        }
    }

    public int getHour() {
        return hour;
    }

}
