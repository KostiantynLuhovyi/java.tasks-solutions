package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.CalculatingArea;
import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

@FunctionalInterface
public interface CalculatingAreaOfRoomWithoutDoorsAndWindows extends CalculatingArea {

    BigDecimal calculateAreaOfTheRoomWithoutDoorsAndWindows(Room room);

    default BigDecimal calculate(Room room) {
        return room.getTotalAreaRoom().subtract(room.getTotalAreaOfDoorsInRoom()).subtract(room.getTotalAreaOfWindowsInRoom());
    }

}
