package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.util.filling;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory.Factory;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.factory.FactoryBank;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Bank;

import java.util.List;

/**
 * Created by LugowoyKonstantin on 18.03.2017.
 */

public abstract class FillingBankList {

    private static final int QUANTITY_OF_BANKS = 10;

    private static final Factory<Bank> BANK_FACTORY = FactoryBank::createBank;

    public static void fillingBankList(List<Bank> bankList) {
        for (int indexBank = 1; indexBank <= QUANTITY_OF_BANKS; indexBank++) {

            Bank bank = BANK_FACTORY.create();
            bank.setBankName("bank:" + indexBank);

            bankList.add(bank);
        }
    }

}
