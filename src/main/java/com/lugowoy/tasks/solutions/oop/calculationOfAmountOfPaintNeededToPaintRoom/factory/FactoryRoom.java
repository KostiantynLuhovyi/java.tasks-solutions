package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 21-Feb-17.
 */

public class FactoryRoom extends FactoryModel<Double> {

    public FactoryRoom(Reader reader) {
        super(reader);
    }

    public FactoryRoom(Reading reading) {
        super(reading);
    }

    public Room createRoom() {
        System.out.println("Enter the width of the room : ");
        BigDecimal widthRoom = new BigDecimal(super.getReader().readDouble());

        System.out.println("Enter the length of the room : ");
        BigDecimal lengthRoom = new BigDecimal(super.getReader().readDouble());

        System.out.println("Enter the height of the room : ");
        BigDecimal heightRoom = new BigDecimal(super.getReader().readDouble());

        System.out.println();

        return new Room(widthRoom, lengthRoom, heightRoom);
    }

}
