package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Door;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public class CalculatorDoorsArea extends CalculatorObjectArea<Door> implements CalculatingTotalAreaOfObjectInRoom<Door> {

    @Override
    public void calculateArea(Door door) {
        BigDecimal areaDoor = new BigDecimal(door.getWidthDoor().multiply(door.getHeightDoor()).doubleValue());
        door.setAreaDoor(areaDoor);
    }

    @Override
    public BigDecimal calculateTotalAreaOfObjectInRoom(Room room) {
        BigDecimal totalAreaOfTheDoorsInTheRoom = new BigDecimal(0);
        for (Door door : room.getDoorListInFlat()) {
            this.calculateArea(door);
            totalAreaOfTheDoorsInTheRoom = new BigDecimal(totalAreaOfTheDoorsInTheRoom.add(door.getAreaDoor()).doubleValue());
        }
        return totalAreaOfTheDoorsInTheRoom;
    }

    @Override
    public BigDecimal calculateTotalAreaOfObjectInRoom(List<Door> doors) {
        BigDecimal totalAreaOfTheDoorsInTheRoom = new BigDecimal(0);
        for (Door door : doors) {
            this.calculateArea(door);
            totalAreaOfTheDoorsInTheRoom = new BigDecimal(totalAreaOfTheDoorsInTheRoom.add(door.getAreaDoor()).doubleValue());
        }
        return totalAreaOfTheDoorsInTheRoom;
    }

}
