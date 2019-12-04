package com.lugowoy.tasks.solutions.core.calculationOfMonthlyPaymentsOnDeposit;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Write a program that asks the user enter sum cash deposit , as well as a percentage per yearly, which pays the bank.
 * Determine the amount of money paid by the bank in the current month
 * <p>
 * Created by Konstantin Lugowoy on 10-Feb-17.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        Bank bank = new Bank();
        User user = new User();
        PersonalAccount personalAccount = new PersonalAccount();
        Deposit deposit = new Deposit();

        personalAccount.setBank(bank);
        personalAccount.setBankingServices(new ArrayList<>());
        personalAccount.setUser(user);

        personalAccount.getBankingServices().add(deposit);

        user.setPersonalAccount(personalAccount);

        System.out.println("Enter first name : ");
        user.setFirstName(READER.readString());

        System.out.println("Enter second name : ");
        user.setSecondName(READER.readString());

        System.out.println("Enter sum of the deposit : ");
        deposit.setSumDeposit(new BigDecimal(READER.readDouble()));

        System.out.println("Enter percent of yearly : ");
        deposit.setPercentYearly(new BigDecimal(READER.readDouble()));

        CalculatingOfMonthlyPaymentsOnDeposit calculatingOfMonthlyPaymentsOnDeposit = new CalculatingOfMonthlyPaymentsOnDeposit();

        System.out.printf("The amount of payments for deposit percent for this month is equal : %f",
                calculatingOfMonthlyPaymentsOnDeposit.calculateOfMonthlyPaymentsOnDeposit(user));

    }

}
