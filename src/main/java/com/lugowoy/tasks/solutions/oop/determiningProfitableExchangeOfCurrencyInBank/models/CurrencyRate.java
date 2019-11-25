package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 18.03.2017.
 */

public class CurrencyRate implements Serializable, Cloneable {

    public static final double MIN_UAH_TO_USD = 26.50;
    public static final double MAX_UAH_TO_USD = 29.00;

    public static final double MIN_UAH_TO_EUR = 28.30;
    public static final double MAX_UAH_TO_EUR = 31.00;

    public static final double MIN_UAH_TO_RUB = 0.38;
    public static final double MAX_UAH_TO_RUB = 0.48;

    public static final double MIN_RUB_TO_USD = 56.00;
    public static final double MAX_RUB_TO_USD = 59.00;

    public static final double MIN_RUB_TO_EUR = 60.00;
    public static final double MAX_RUB_TO_EUR = 64.00;

    public static final double MIN_USD_TO_EUR = 1.030;
    public static final double MAX_USD_TO_EUR = 1.090;

    private TypeOfCurrency typeOfCurrency;
    private BigDecimal currencyRate;

    public CurrencyRate() {
    }

    public CurrencyRate(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public CurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public CurrencyRate(TypeOfCurrency typeOfCurrency, BigDecimal currencyRate) {
        this.typeOfCurrency = typeOfCurrency;
        this.currencyRate = currencyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyRate)) return false;

        CurrencyRate that = (CurrencyRate) o;

        if (typeOfCurrency != that.typeOfCurrency) return false;
        return currencyRate != null ? currencyRate.equals(that.currencyRate) : that.currencyRate == null;
    }

    @Override
    public int hashCode() {
        int result = typeOfCurrency != null ? typeOfCurrency.hashCode() : 0;
        result = 31 * result + (currencyRate != null ? currencyRate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRate[" +
                "typeOfCurrency=" + typeOfCurrency +
                ", currencyRate=" + currencyRate +
                ']';
    }

    @Override
    public CurrencyRate clone() {
        CurrencyRate currencyRate = new CurrencyRate();
        try {
            currencyRate = (CurrencyRate) super.clone();
            currencyRate.setTypeOfCurrency(this.getTypeOfCurrency());//Enum is a singleton, so refers to the same instance.
            currencyRate.setCurrencyRate(new Cloner().deepClone(this.getCurrencyRate()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return currencyRate;
    }

    public TypeOfCurrency getTypeOfCurrency() {
        return typeOfCurrency;
    }

    public void setTypeOfCurrency(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public enum Rate {
        UAH_TO_USD_AND_USD_TO_UAH(26.50, 29.00),
        UAH_TO_EUR_AND_EUR_TO_UAH(28.30, 31.00),
        UAH_TO_RUB_AND_RUB_TO_UAH(0.35, 0.45),
        RUB_TO_USD_AND_USD_TO_RUB(56.00, 59.00),
        RUB_TO_EUR_AND_EUR_TO_RUB(60.00, 64.00),
        USD_TO_EUR_AND_EUR_TO_USD(1.030, 1.090);

        private double minRate;
        double maxRate;

        Rate(double minRate, double maxRate) {
            this.minRate = minRate;
            this.maxRate = maxRate;
        }

        public double getMinRate() {
            return minRate;
        }

        public void setMinRate(double minRate) {
            this.minRate = minRate;
        }

        public double getMaxRate() {
            return maxRate;
        }

        public void setMaxRate(double maxRate) {
            this.maxRate = maxRate;
        }
    }

}

