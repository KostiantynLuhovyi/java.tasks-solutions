package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public class Currency implements Serializable, Cloneable {

    private TypeOfCurrency typeOfCurrency;

    private List<CurrencyRate> currencyRateList;

    public Currency() {
    }

    public Currency(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public Currency(TypeOfCurrency typeOfCurrency, List<CurrencyRate> currencyRateList) {
        this.typeOfCurrency = typeOfCurrency;
        this.currencyRateList = currencyRateList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (getTypeOfCurrency() != currency.getTypeOfCurrency()) return false;
        return getCurrencyRateList() != null ? getCurrencyRateList().equals(currency.getCurrencyRateList()) : currency.getCurrencyRateList() == null;
    }

    @Override
    public int hashCode() {
        int result = getTypeOfCurrency() != null ? getTypeOfCurrency().hashCode() : 0;
        result = 31 * result + (getCurrencyRateList() != null ? getCurrencyRateList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency[" +
                "typeOfCurrency=" + typeOfCurrency +
                ", currencyRateList=" + currencyRateList +
                ']';
    }

    @Override
    public Currency clone() {
        Currency currency = new Currency();
        try {
            currency = (Currency) super.clone();
            currency.setTypeOfCurrency(this.getTypeOfCurrency());//Enum is a singleton, so refers to the same instance.
            currency.setCurrencyRateList(new Cloner().deepClone(this.getCurrencyRateList()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return currency;
    }

    public TypeOfCurrency getTypeOfCurrency() {
        return typeOfCurrency;
    }

    public void setTypeOfCurrency(TypeOfCurrency typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public List<CurrencyRate> getCurrencyRateList() {
        return currencyRateList;
    }

    public void setCurrencyRateList(List<CurrencyRate> currencyRateList) {
        this.currencyRateList = currencyRateList;
    }

}
