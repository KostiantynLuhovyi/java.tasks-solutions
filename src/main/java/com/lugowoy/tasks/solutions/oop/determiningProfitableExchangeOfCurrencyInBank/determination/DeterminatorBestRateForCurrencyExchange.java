package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.determination;

import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Bank;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;

import java.util.List;

/**
 * Created by LugowoyKonstantin on 19.03.2017.
 */

public interface DeterminatorBestRateForCurrencyExchange extends Determinator {

    Bank determineBankToBestRateForConcreteCurrencyExchange(List<Bank> bankList, TypeOfCurrency fromTypeOfCurrency, TypeOfCurrency inTypeOfCurrency);

}
