package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public class Bank implements Serializable, Cloneable {

    private String bankName;

    private List<Currency> currencyList;

    private List<CurrencyBalance> currencyBalanceList;

    public Bank() {
    }

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;

        Bank bank = (Bank) o;

        if (getBankName() != null ? !getBankName().equals(bank.getBankName()) : bank.getBankName() != null)
            return false;
        if (getCurrencyList() != null ? !getCurrencyList().equals(bank.getCurrencyList()) : bank.getCurrencyList() != null)
            return false;
        return getCurrencyBalanceList() != null ? getCurrencyBalanceList().equals(bank.getCurrencyBalanceList()) : bank.getCurrencyBalanceList() == null;
    }

    @Override
    public int hashCode() {
        int result = getBankName() != null ? getBankName().hashCode() : 0;
        result = 31 * result + (getCurrencyList() != null ? getCurrencyList().hashCode() : 0);
        result = 31 * result + (getCurrencyBalanceList() != null ? getCurrencyBalanceList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bank[" +
                "bankName='" + bankName + '\'' +
                ", currencyList=" + currencyList +
                ", currencyBalanceList=" + currencyBalanceList +
                ']';
    }

    @Override
    public Bank clone() {
        Bank bank = new Bank();
        Cloner cloner = new Cloner();
        try {
            bank = (Bank) super.clone();
            bank.setBankName(cloner.deepClone(this.getBankName()));
            bank.setCurrencyList(cloner.deepClone(this.getCurrencyList()));
            bank.setCurrencyBalanceList(cloner.deepClone(this.getCurrencyBalanceList()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return bank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<CurrencyBalance> getCurrencyBalanceList() {
        return currencyBalanceList;
    }

    public void setCurrencyBalanceList(List<CurrencyBalance> currencyBalanceList) {
        this.currencyBalanceList = currencyBalanceList;
    }

}
