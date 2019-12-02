package com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.factory;

import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.Currency;
import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public interface FactoryCurrency {

    static Currency createCurrency() {
        return new Currency();
    }

    static Currency createCurrency(TypeOfCurrency typeOfCurrency) {
        return new Currency(typeOfCurrency);
    }

}
