package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.CalculatingArea;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public interface CalculatingObjectArea<T> extends CalculatingArea {

    void calculateArea(T t);

}
