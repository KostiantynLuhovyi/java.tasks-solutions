package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.util.filling;

import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.calculating.CalculatingCurrencyRate;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.factory.Factory;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.factory.FactoryCurrency;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.CurrencyRate.Rate;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public abstract class FillingBankCurrency {

    private static final int QUANTITY_OF_CURRENCY_IN_THE_BANK = 4;

    private static final Factory<Currency> CURRENCY_FACTORY = FactoryCurrency::createCurrency;

    public static void fillingBankCurrency(List<Bank> bankList) {
        if (bankList != null) {
            for (Bank bank : bankList) {
                if (bank != null) {
                    bank.setCurrencyList(new ArrayList<>(0));
                    bank.setCurrencyBalanceList(new ArrayList<>(0));

                    for (int indexCurrency = 1; indexCurrency <= QUANTITY_OF_CURRENCY_IN_THE_BANK; indexCurrency++) {
                        Currency currency = CURRENCY_FACTORY.create();
                        currency.setTypeOfCurrency(TypeOfCurrency.getIndexTypeOfCurrency(indexCurrency));

                        bank.getCurrencyList().add(currency);
                        fillingAndSetCurrencyRatesListForConcreteCurrency(currency);

                        fillingAndSetCurrencyBalanceListForConcreteCurrency(indexCurrency, bank);
                    }
                }
            }
        }
    }

    private static void fillingAndSetCurrencyRatesListForConcreteCurrency(Currency currency) {
        List<CurrencyRate> currencyRateList = new ArrayList<>(0);
        currency.setCurrencyRateList(currencyRateList);

        CalculatingCurrencyRate calculatingCurrencyRate = CalculatingCurrencyRate::calculateCurrencyRate;

        switchForFillingCurrencyRateListOfConcreteCurrency(currency, currencyRateList, calculatingCurrencyRate);
    }

    private static void switchForFillingCurrencyRateListOfConcreteCurrency(Currency currency, List<CurrencyRate> currencyRateList, CalculatingCurrencyRate calculatingCurrencyRate) {
        switch (currency.getTypeOfCurrency()) {
            case UAH:
                fillingAndSetCurrencyRateList(currencyRateList,
                        new CurrencyRate(TypeOfCurrency.USD, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_USD_AND_USD_TO_UAH)),
                        new CurrencyRate(TypeOfCurrency.EUR, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_EUR_AND_EUR_TO_UAH)),
                        new CurrencyRate(TypeOfCurrency.RUB, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_RUB_AND_RUB_TO_UAH)));
                break;
            case USD:
                fillingAndSetCurrencyRateList(currencyRateList,
                        new CurrencyRate(TypeOfCurrency.EUR, calculatingCurrencyRate.calculateRate(Rate.USD_TO_EUR_AND_EUR_TO_USD)),
                        new CurrencyRate(TypeOfCurrency.UAH, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_USD_AND_USD_TO_UAH)),
                        new CurrencyRate(TypeOfCurrency.RUB, calculatingCurrencyRate.calculateRate(Rate.RUB_TO_USD_AND_USD_TO_RUB)));
                break;
            case EUR:
                fillingAndSetCurrencyRateList(currencyRateList,
                        new CurrencyRate(TypeOfCurrency.USD, calculatingCurrencyRate.calculateRate(Rate.USD_TO_EUR_AND_EUR_TO_USD)),
                        new CurrencyRate(TypeOfCurrency.UAH, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_EUR_AND_EUR_TO_UAH)),
                        new CurrencyRate(TypeOfCurrency.RUB, calculatingCurrencyRate.calculateRate(Rate.RUB_TO_EUR_AND_EUR_TO_RUB)));
                break;
            case RUB:
                fillingAndSetCurrencyRateList(currencyRateList,
                        new CurrencyRate(TypeOfCurrency.USD, calculatingCurrencyRate.calculateRate(Rate.RUB_TO_USD_AND_USD_TO_RUB)),
                        new CurrencyRate(TypeOfCurrency.EUR, calculatingCurrencyRate.calculateRate(Rate.RUB_TO_EUR_AND_EUR_TO_RUB)),
                        new CurrencyRate(TypeOfCurrency.UAH, calculatingCurrencyRate.calculateRate(Rate.UAH_TO_RUB_AND_RUB_TO_UAH)));
                break;
        }
    }

    private static void fillingAndSetCurrencyRateList(List<CurrencyRate> currencyRateList,
                                                      CurrencyRate currencyRateFirst, CurrencyRate currencyRateSecond, CurrencyRate currencyRateThird) {
        currencyRateList.add(currencyRateFirst);
        currencyRateList.add(currencyRateSecond);
        currencyRateList.add(currencyRateThird);
    }

    private static void fillingAndSetCurrencyBalanceListForConcreteCurrency(int indexTypeOfCurrency, Bank bank) {
        CurrencyBalance currencyBalance = new CurrencyBalance();
        currencyBalance.setTypeOfCurrency(TypeOfCurrency.getIndexTypeOfCurrency(indexTypeOfCurrency));
        currencyBalance.setCurrencyBalance(new BigDecimal((Math.random() * (10000 - 2000)) + 2000).setScale(2, RoundingMode.HALF_UP));
        bank.getCurrencyBalanceList().add(currencyBalance);
    }

}
