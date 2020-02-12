package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

import com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.Calculating;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */
public interface CalculatingArea<T> extends Calculating {

    void calculateArea(T t);

}
