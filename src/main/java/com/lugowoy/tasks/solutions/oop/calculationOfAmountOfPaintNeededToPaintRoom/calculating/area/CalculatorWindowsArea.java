package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Window;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public class CalculatorWindowsArea extends CalculatorObjectArea<Window> implements CalculatingTotalAreaOfObjectInRoom<Window> {

    @Override
    public void calculateArea(Window window) {
        BigDecimal areaWindow = new BigDecimal(window.getWidthWindow().multiply(window.getHeightWindow()).doubleValue());
        window.setAreaWindow(areaWindow);
    }

    @Override
    public BigDecimal calculateTotalAreaOfObjectInRoom(Room room) {
        BigDecimal totalAreaOfTheWindowsInTheRoom = new BigDecimal(0);
        for (Window window : room.getWindowListInFlat()) {
            this.calculateArea(window);
            totalAreaOfTheWindowsInTheRoom = new BigDecimal(totalAreaOfTheWindowsInTheRoom.add(window.getAreaWindow()).doubleValue());
        }
        return totalAreaOfTheWindowsInTheRoom;
    }

    @Override
    public BigDecimal calculateTotalAreaOfObjectInRoom(List<Window> windowList) {
        BigDecimal totalAreaOfTheWindowsInTheRoom = new BigDecimal(0);
        for (Window window : windowList) {
            this.calculateArea(window);
            totalAreaOfTheWindowsInTheRoom = new BigDecimal(totalAreaOfTheWindowsInTheRoom.add(window.getAreaWindow()).doubleValue());
        }
        return totalAreaOfTheWindowsInTheRoom;
    }

}
