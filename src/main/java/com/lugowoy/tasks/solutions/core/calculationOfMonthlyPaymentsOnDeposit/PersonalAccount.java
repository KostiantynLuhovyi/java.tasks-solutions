package com.lugowoy.tasks.calculationOfMonthlyPaymentsOnDeposit;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Konstantin Lugowoy on 11-Feb-17.
 */

public class PersonalAccount implements Serializable, Cloneable {

    private static final AtomicInteger INTEGER = new AtomicInteger(0);

    private int id;

    private User user;
    private Bank bank;

    private List<BankingService> bankingServices;

    public PersonalAccount() {
        this.id = INTEGER.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalAccount)) return false;

        PersonalAccount that = (PersonalAccount) o;

        if (getId() != that.getId()) return false;
        if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null) return false;
        if (getBank() != null ? !getBank().equals(that.getBank()) : that.getBank() != null) return false;
        return getBankingServices() != null ? getBankingServices().equals(that.getBankingServices()) : that.getBankingServices() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getBank() != null ? getBank().hashCode() : 0);
        result = 31 * result + (getBankingServices() != null ? getBankingServices().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalAccount[" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", bankingServices=" + bankingServices +
                ']';
    }

    @Override
    public PersonalAccount clone() {
        PersonalAccount personalAccount = new PersonalAccount();
        Cloner cloner = new Cloner();
        try {
            personalAccount = (PersonalAccount) super.clone();
            personalAccount.setId(this.getId());
            personalAccount.setBank(cloner.deepClone(this.getBank()));
            personalAccount.setUser(cloner.deepClone(this.getUser()));
            personalAccount.setBankingServices(cloner.deepClone(this.getBankingServices()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return personalAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<BankingService> getBankingServices() {
        return bankingServices;
    }

    public void setBankingServices(List<BankingService> bankingServices) {
        this.bankingServices = bankingServices;
    }

}
