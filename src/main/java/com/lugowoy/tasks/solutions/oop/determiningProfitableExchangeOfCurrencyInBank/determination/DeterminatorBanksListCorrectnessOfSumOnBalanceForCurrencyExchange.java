package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.determination;

import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Bank;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;

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
