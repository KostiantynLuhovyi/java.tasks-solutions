package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.CalculatingArea;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public interface CalculatingObjectArea<T> extends CalculatingArea {

    void calculateArea(T t);

}
