package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by LugowoyKonstantin on 06.03.2017.
 */

public class CalculatorPercentOfAreaOfDoorsFromRoomArea
        implements CalculatingPercentOfAreaOfObjectsFromRoomArea {

    @Override
    public BigDecimal calculatePercentage(Room room) {
        return new BigDecimal(room.getTotalAreaRoom().multiply(new BigDecimal(room.getTotalAreaOfDoorsInRoom().doubleValue())
                .divide(new BigDecimal(100), 2, RoundingMode.DOWN)).doubleValue());
    }

}
