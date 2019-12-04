package com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * Created by Konstantin Lugowoy on 10-Feb-17.
 */

public class CalculatingOfMonthlyPaymentsOnDeposit {

    private static final int SCALE = 2;

    public BigDecimal calculateOfMonthlyPaymentsOnDeposit(User user) {
        Deposit deposit = this.getDepositServiceOnPersonalAccount(user.getPersonalAccount());

        Calendar calendar = Calendar.getInstance();
        int dayOfActualMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return new BigDecimal(deposit.getSumDeposit().multiply(new BigDecimal(deposit.getPercentYearly().doubleValue())
                                                     .divide(new BigDecimal(100), SCALE, RoundingMode.HALF_DOWN))
                                                     .multiply(new BigDecimal(dayOfActualMonth))
                                                     .divide(new BigDecimal(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)), SCALE, RoundingMode.DOWN)
                                                     .doubleValue());
    }

    private Deposit getDepositServiceOnPersonalAccount(PersonalAccount account) {
        return (Deposit) account.getBankingServices().stream()
                                                     .findAny()
                                                     .filter(bankingService -> bankingService instanceof Deposit)
                                                     .orElse(null);
    }

}
