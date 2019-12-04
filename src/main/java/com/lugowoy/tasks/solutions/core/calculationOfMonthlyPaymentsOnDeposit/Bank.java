package com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Konstantin Lugowoy on 10-Feb-17.
 */

public class Bank implements Serializable, Cloneable {

    private List<BankingService> bankingServices;

    private Set<User> users;
    private Set<PersonalAccount> accounts;

    public Bank() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;

        Bank bank = (Bank) o;

        if (getBankingServices() != null ? !getBankingServices().equals(bank.getBankingServices()) : bank.getBankingServices() != null)
            return false;
        if (getUsers() != null ? !getUsers().equals(bank.getUsers()) : bank.getUsers() != null) return false;
        return getAccounts() != null ? getAccounts().equals(bank.getAccounts()) : bank.getAccounts() == null;
    }

    @Override
    public int hashCode() {
        int result = getBankingServices() != null ? getBankingServices().hashCode() : 0;
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        result = 31 * result + (getAccounts() != null ? getAccounts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bank[" +
                "bankingServices=" + bankingServices +
                ", users=" + users +
                ", accounts=" + accounts +
                ']';
    }

    @Override
    public Bank clone() {
        Bank bank = null;
        Cloner cloner = new Cloner();
        try {
            bank = (Bank) super.clone();
            bank.setBankingServices(cloner.deepClone(this.getBankingServices()));
            bank.setUsers(cloner.deepClone(this.getUsers()));
            bank.setAccounts(cloner.deepClone(this.getAccounts()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return bank;
    }

    public List<BankingService> getBankingServices() {
        return bankingServices;
    }

    public void setBankingServices(List<BankingService> bankingServices) {
        this.bankingServices = bankingServices;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<PersonalAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<PersonalAccount> accounts) {
        this.accounts = accounts;
    }

}
