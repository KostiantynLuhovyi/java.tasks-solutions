package com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.factory;

import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.Bank;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public interface FactoryBank {

    static Bank createBank() {
        return new Bank();
    }

    static Bank createBank(String nameBank) {
        return new Bank(nameBank);
    }

}
