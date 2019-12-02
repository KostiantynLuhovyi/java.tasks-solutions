package com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.determination;

import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.Bank;
import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 19.03.2017.
 */

public interface DeterminatorBanksListCorrectnessOfSumOnBalanceForCurrencyExchange {

    List<Bank> determineBanksListHaveCorrectnessOfSumOnBalanceForCurrencyExchange(List<Bank> banksList,
                                                                                  TypeOfCurrency inTypeOfCurrency,
                                                                                  BigDecimal sumForExchange);

}
