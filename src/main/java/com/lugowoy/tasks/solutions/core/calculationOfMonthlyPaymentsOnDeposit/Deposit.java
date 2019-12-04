package com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit;

import com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit.BankingService;
import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 10-Feb-17.
 */

public class Deposit extends BankingService {

    private BigDecimal sumDeposit;
    private BigDecimal percentYearly;

    public Deposit() {
        super();
    }

    public Deposit(int id, BigDecimal sumDeposit, BigDecimal percentYearly) {
        super(id);
        this.sumDeposit = sumDeposit;
        this.percentYearly = percentYearly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        if (!super.equals(o)) return false;

        Deposit deposit = (Deposit) o;

        if (getSumDeposit() != null ? !getSumDeposit().equals(deposit.getSumDeposit()) : deposit.getSumDeposit() != null)
            return false;
        return getPercentYearly() != null ? getPercentYearly().equals(deposit.getPercentYearly()) : deposit.getPercentYearly() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSumDeposit() != null ? getSumDeposit().hashCode() : 0);
        result = 31 * result + (getPercentYearly() != null ? getPercentYearly().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Deposit[" + super.toString() + ", " +
                "sumDeposit=" + sumDeposit +
                ", percentYearly=" + percentYearly +
                ']';
    }

    @Override
    public Deposit clone() {
        Deposit deposit = (Deposit) super.clone();
        Cloner cloner = new Cloner();
        deposit.setSumDeposit(cloner.deepClone(this.getSumDeposit()));
        deposit.setPercentYearly(cloner.deepClone(this.getPercentYearly()));
        return deposit;
    }

    public BigDecimal getSumDeposit() {
        return sumDeposit;
    }

    public void setSumDeposit(BigDecimal sumDeposit) {
        this.sumDeposit = sumDeposit;
    }

    public BigDecimal getPercentYearly() {
        return percentYearly;
    }

    public void setPercentYearly(BigDecimal percentYearly) {
        this.percentYearly = percentYearly;
    }

}
