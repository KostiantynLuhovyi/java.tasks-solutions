package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.expense;

import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.CalculatingExpense;
import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.models.Paint;
import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.models.Room;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public interface CalculatingExpensePaintForRoom extends CalculatingExpense {

    BigDecimal calculateExpensePaintForRoom(Room room, Paint paint);

}
