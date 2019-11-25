package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Window;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 21-Feb-17.
 */

public class FactoryWindow extends FactoryModel<Double> {

    public FactoryWindow(Reader reader) {
        super(reader);
    }

    public FactoryWindow(Reading reading) {
        super(reading);
    }

    public Window createWindow() {
        System.out.println("Enter the width of the window : ");
        BigDecimal widthWindow = new BigDecimal(super.getReader().readDouble());

        System.out.println("Enter the height of the window : ");
        BigDecimal heightWindow = new BigDecimal(super.getReader().readDouble());

        System.out.println();

        return new Window(widthWindow, heightWindow);
    }

}
