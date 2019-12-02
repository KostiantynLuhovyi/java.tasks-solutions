package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.expense;

import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.models.Paint;
import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public class CalculatorExpensePaintForRoom implements CalculatingExpensePaintForRoom {

    @Override
    public BigDecimal calculateExpensePaintForRoom(Room room, Paint paint) {
        return room.getAreaRoomWithoutAreaDoorsAndWindows().multiply(new BigDecimal(paint.getExpenseOfPaintPerSquareMeter()
                                                           .doubleValue())).setScale(2, RoundingMode.DOWN);
    }

}
