package com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.factory;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

@FunctionalInterface
public interface Factory<T> {

    T create();

}
