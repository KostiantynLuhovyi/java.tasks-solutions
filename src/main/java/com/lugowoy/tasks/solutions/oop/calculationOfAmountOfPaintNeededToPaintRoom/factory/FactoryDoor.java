package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Door;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 21-Feb-17.
 */

public class FactoryDoor extends FactoryModel<Double> {

    public FactoryDoor(Reader reader) {
        super(reader);
    }

    public FactoryDoor(Reading reading) {
        super(reading);
    }

    public Door createDoor() {
        BigDecimal widthDoor = setWidthOfDoor();
        BigDecimal heightDoor = setHeightOfDoor();
        return new Door(widthDoor, heightDoor);
    }

    private BigDecimal setHeightOfDoor() {
        System.out.println("Enter the height of the door : ");
        return new BigDecimal(super.getReader().readDouble());
    }

    private BigDecimal setWidthOfDoor() {
        System.out.println("Enter the width of the door : ");
        return new BigDecimal(super.getReader().readDouble());
    }

}
