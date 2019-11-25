package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.expense;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Paint;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

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
