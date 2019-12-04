package com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Konstantin Lugowoy on 11-Feb-17.
 */

public class BankingService implements Serializable, Cloneable {

    private static final AtomicInteger INTEGER = new AtomicInteger(0);

    private int id;

    public BankingService() {
        this.id = INTEGER.incrementAndGet();
    }

    public BankingService(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingService)) return false;

        BankingService that = (BankingService) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "BankingService[" +
                "id=" + id +
                ']';
    }

    @Override
    public BankingService clone() {
        BankingService bankingService = new BankingService();
        try {
            bankingService = (BankingService) super.clone();
            bankingService.setId(this.getId());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return bankingService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
