package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.determination.DeterminerCurrencyProfitabilityOfBanksList;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Bank;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Currency;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.util.filling.Filling;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.util.filling.FillingBankCurrency;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.util.filling.FillingBankList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Identify the bank from the available for the most beneficial exchange of selected currencies and amounts.
 * <p>
 * Created by LugowoyKonstantin on 09.03.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Filling<Bank> FILLING_BANK = FillingBankList::fillingBankList;
    private static final Filling<Bank> FILLING_CURRENCY = FillingBankCurrency::fillingBankCurrency;

    public static void main(String[] args) {

        List<Bank> banksListInTheCity = new ArrayList<>();

        FILLING_BANK.filling(banksListInTheCity);
        FILLING_CURRENCY.filling(banksListInTheCity);

        Currency currency = new Currency(selectTypeOfCurrencyForExchange());
        System.out.println();

        BigDecimal sumToBeExchanged = enterTheSumToBeExchanged();
        System.out.println();

        TypeOfCurrency currencyInWhichYouWantToExchange = selectTheCurrencyInWhichYouWantToExchange();
        System.out.println();

        DeterminerCurrencyProfitabilityOfBanksList determinerCurrencyProfitability =
                new DeterminerCurrencyProfitabilityOfBanksList();

        List<Bank> banks =
                determinerCurrencyProfitability.determineBanksListHaveCorrectnessOfSumOnBalanceForCurrencyExchange(banksListInTheCity,
                        currencyInWhichYouWantToExchange,
                        sumToBeExchanged);
        if (!banks.isEmpty()) {
            System.out.println("List of banks that have the amount to exchange money : ");
            banks.forEach(System.out::println);
            System.out.println();
        }

        Bank bank = determinerCurrencyProfitability.determineBankToBestRateForConcreteCurrencyExchange(banks,
                currency.getTypeOfCurrency(),
                currencyInWhichYouWantToExchange);

        if (Objects.nonNull(bank)) {
            System.out.println("The most profitable bank for the exchange of funds you choose : ");
            System.out.println(bank);
        }

    }

    private static TypeOfCurrency selectTypeOfCurrencyForExchange() {
        System.out.println("Select currency for exchange : ");
        return selectAndGetTypeOfCurrency();
    }

    private static TypeOfCurrency selectTheCurrencyInWhichYouWantToExchange() {
        System.out.println("Select the currency in which you want to exchange : ");
        return selectAndGetTypeOfCurrency();
    }

    private static TypeOfCurrency selectAndGetTypeOfCurrency() {
        TypeOfCurrency typeOfCurrency = null;
        System.out.println("UAH : 1 ,\n" +
                "USD : 2 ,\n" +
                "EUR : 3 ,\n" +
                "RUB : 4 .");
        int selectCurrencyForExchange = READER.readInt();

        if ((selectCurrencyForExchange >= 1) && (selectCurrencyForExchange <= 4)) {
            typeOfCurrency = TypeOfCurrency.getIndexTypeOfCurrency(selectCurrencyForExchange);
        } else {
            System.out.println("Incorrect selection.");
            System.out.println("Re-enter : ");
            selectAndGetTypeOfCurrency();
        }
        return typeOfCurrency;
    }

    private static BigDecimal enterTheSumToBeExchanged() {
        BigDecimal sumToBeExchanged = new BigDecimal(0);

        System.out.println("Select the sum to be exchanged : ");
        double enterSum = READER.readDouble();

        if (enterSum <= 0) {
            System.out.println("The amount was incorrectly entered.");
            System.out.println("The amount must be nonzero and positive.");
            enterTheSumToBeExchanged();
            System.out.println();
        } else {
            sumToBeExchanged = sumToBeExchanged.add(new BigDecimal(enterSum)).setScale(2, RoundingMode.HALF_DOWN);
        }
        return sumToBeExchanged;
    }

}
