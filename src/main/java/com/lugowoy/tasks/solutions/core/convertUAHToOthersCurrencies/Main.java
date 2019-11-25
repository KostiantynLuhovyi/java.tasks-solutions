package com.lugowoy.tasks.convertUAHToOthersCurrencies;

import com.lugowoy.helper.converting.Converter;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;

/**
 * Write a program that allows the user to enter the number using the keypad UAH, and convert it into USD, EUR and RUB.
 * <p>
 * Created by Konstantin Lugowoy on 15-Dec-16.
 */

public class Main {

    private static final Reader reader = Reader.getReader(new ReadingConsole());

    private static final double EUR_EXCHANGE_RATE = 29.11;
    private static final double USD_EXCHANGE_RATE = 27.21;
    private static final double RUB_EXCHANGE_RATE = 2.20;

    public static void main(String[] args) {

        Account account = new Account();

        System.out.println("Enter the amount in UAH : ");
        account.setUAH(new BigDecimal(reader.readDouble()));

        Converter<Account> converter = new Converter<>(new ConvertorUAHToOtherCurrencies(EUR_EXCHANGE_RATE,
                                                                                         USD_EXCHANGE_RATE,
                                                                                         RUB_EXCHANGE_RATE));

        converter.convert(account);

        System.out.println("In the UAH : " + account.getUAH());
        System.out.println("In the USD : " + account.getUSD());
        System.out.println("In the EUR : " + account.getEUR());
        System.out.println("In the RUB : " + account.getRUB());

    }

}
