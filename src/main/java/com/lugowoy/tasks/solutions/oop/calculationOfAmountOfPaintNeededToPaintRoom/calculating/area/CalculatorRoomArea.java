package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public class CalculatorRoomArea extends CalculatorObjectArea<Room> {

    @Override
    public void calculateArea(Room room) {
        BigDecimal areaTwoWallsDefiningTheWidthOfTheRoom
                = new BigDecimal(room.getWidthRoom().multiply(room.getHeightRoom().multiply(new BigDecimal(2))).doubleValue());
        BigDecimal areaTwoWallsDefiningTheLengthOfThRoom
                = new BigDecimal(room.getLengthRoom().multiply(room.getHeightRoom().multiply(new BigDecimal(2))).doubleValue());

        room.setTotalAreaRoom(areaTwoWallsDefiningTheWidthOfTheRoom.add(areaTwoWallsDefiningTheLengthOfThRoom));
    }

}
