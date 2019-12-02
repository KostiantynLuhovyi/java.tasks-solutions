package com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.calculating;

import com.lugowoy.tasks.solutions.oop.determiningProfitableExchangeOfCurrencyInBank.models.CurrencyRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by LugowoyKonstantin on 18.03.2017.
 */

@FunctionalInterface
public interface CalculatingCurrencyRate {

    BigDecimal calculateRate(CurrencyRate.Rate rate);

    static BigDecimal calculateCurrencyRate(CurrencyRate.Rate rate) {
        return new BigDecimal((Math.random() * (rate.getMaxRate() - rate.getMinRate()))
                                                  + rate.getMinRate()).setScale(2, RoundingMode.HALF_DOWN);
    }

}
