package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public class CalculatorPercentOfAreaOfWindowsFromRoomArea
        implements CalculatingPercentOfAreaOfObjectsFromRoomArea {

    @Override
    public BigDecimal calculatePercentage(Room room) {
        return new BigDecimal(room.getTotalAreaRoom()
                .multiply(new BigDecimal(room.getTotalAreaOfWindowsInRoom().doubleValue())
                        .divide(new BigDecimal(100), 2, RoundingMode.DOWN)).doubleValue());
    }

}
