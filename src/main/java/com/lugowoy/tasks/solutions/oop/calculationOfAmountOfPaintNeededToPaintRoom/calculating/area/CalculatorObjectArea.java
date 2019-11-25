package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public abstract class CalculatorObjectArea<T> implements CalculatingObjectArea<T> {

    @Override
    public abstract void calculateArea(T t);

}
