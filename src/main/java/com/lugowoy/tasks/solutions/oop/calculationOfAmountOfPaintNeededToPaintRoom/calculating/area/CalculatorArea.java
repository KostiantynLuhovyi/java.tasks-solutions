package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area;

/**
 * Created by LugowoyKonstantin on 22-Feb-17.
 */

public abstract class CalculatorArea<T> implements CalculatingArea<T> {

    @Override
    public abstract void calculateArea(T t);

}
