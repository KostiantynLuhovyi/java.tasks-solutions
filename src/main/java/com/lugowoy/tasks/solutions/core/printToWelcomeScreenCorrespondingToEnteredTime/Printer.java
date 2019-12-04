package com.lugowoy.tasks.solutions.core.printToWelcomeScreenCorrespondingToEnteredTime;

/**
 * Created by Konstantin Lugowoy on 04.10.2017.
 */

public abstract class Printer {

    private String printText;

    public Printer() {
    }

    public Printer(String printText) {
        this.printText = printText;
    }

    public abstract void print();

    public String getPrintText() {
        return printText;
    }

    public void setPrintText(String printText) {
        this.printText = printText;
    }

}
