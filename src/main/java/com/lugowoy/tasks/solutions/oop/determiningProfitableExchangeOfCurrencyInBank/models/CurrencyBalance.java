package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 18.03.2017.
 */

public class CurrencyBalance implements Serializable, Cloneable {

    private TypeOfCurrency typeOfCurrency;

    private BigDecimal currencyBalance;

    public CurrencyBalance() {
    }

    public CurrencyBalance(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public CurrencyBalance(BigDecimal currencyBalance) {
        this.currencyBalance = currencyBalance;
    }

    public CurrencyBalance(TypeOfCurrency typeOfCurrency, BigDecimal currencyBalance) {
        this.typeOfCurrency = typeOfCurrency;
        this.currencyBalance = currencyBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyBalance)) return false;

        CurrencyBalance that = (CurrencyBalance) o;

        if (typeOfCurrency != that.typeOfCurrency) return false;
        return currencyBalance != null ? currencyBalance.equals(that.currencyBalance) : that.currencyBalance == null;
    }

    @Override
    public int hashCode() {
        int result = typeOfCurrency != null ? typeOfCurrency.hashCode() : 0;
        result = 31 * result + (currencyBalance != null ? currencyBalance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyBalance[" +
                "typeOfCurrency=" + typeOfCurrency +
                ", currencyBalance=" + currencyBalance +
                ']';
    }

    @Override
    public CurrencyBalance clone() {
        CurrencyBalance currencyBalance = new CurrencyBalance();
        try {
            currencyBalance = (CurrencyBalance) super.clone();
            currencyBalance.setTypeOfCurrency(this.getTypeOfCurrency());// Enum is a singleton, so refers to the same instance.
            currencyBalance.setCurrencyBalance(new Cloner().deepClone(this.getCurrencyBalance()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return currencyBalance;
    }

    public TypeOfCurrency getTypeOfCurrency() {
        return typeOfCurrency;
    }

    public void setTypeOfCurrency(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public BigDecimal getCurrencyBalance() {
        return currencyBalance;
    }

    public void setCurrencyBalance(BigDecimal currencyBalance) {
        this.currencyBalance = currencyBalance;
    }

}
