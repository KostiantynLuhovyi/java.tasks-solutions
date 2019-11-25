package com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.determination;

import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Bank;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.Currency;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.CurrencyRate;
import com.lugowoy.tasks.determiningProfitableExchangeOfCurrencyInBank.models.TypeOfCurrency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 19.03.2017.
 */

public class DeterminerCurrencyProfitabilityOfBanksList implements DeterminatorBestRateForCurrencyExchange, DeterminatorBanksListCorrectnessOfSumOnBalanceForCurrencyExchange {

    @Override
    public Bank determineBankToBestRateForConcreteCurrencyExchange(List<Bank> banksList,
                                                                   TypeOfCurrency fromTypeOfCurrency,
                                                                   TypeOfCurrency inTypeOfCurrency) {
        Bank resultBank = null;

        double profitabilityValueRate = 0;
        double valueForComparisonOfRate;

        if (banksList.size() != 0) {
            for (Bank bank : banksList) {
                if ((bank != null) && (bank.getCurrencyList() != null) && (bank.getCurrencyList().size() > 0)) {
                    for (Currency currency : bank.getCurrencyList()) {

                        if ((currency != null) && (currency.getCurrencyRateList() != null) && (currency.getCurrencyRateList().size() > 0)) {

                            if (currency.getTypeOfCurrency() == fromTypeOfCurrency) {

                                for (int i = 0; i < currency.getCurrencyRateList().size(); i++) {

                                    if (currency.getCurrencyRateList().get(i) != null) {

                                        if (currency.getCurrencyRateList().get(i).getTypeOfCurrency() == inTypeOfCurrency) {
                                            valueForComparisonOfRate =
                                                    currency.getCurrencyRateList().get(i).getCurrencyRate().doubleValue();
                                            resultBank =
                                                    determineBankProfitabilityRate(fromTypeOfCurrency,
                                                            inTypeOfCurrency,
                                                            resultBank,
                                                            profitabilityValueRate,
                                                            valueForComparisonOfRate,
                                                            bank);

                                            if (resultBank != null) {
                                                for (Currency currencyOfResultBank : resultBank.getCurrencyList()) {
                                                    if (currencyOfResultBank.getTypeOfCurrency() == fromTypeOfCurrency) {
                                                        for (CurrencyRate currencyRate : currencyOfResultBank.getCurrencyRateList()) {
                                                            if (currencyRate.getTypeOfCurrency() == inTypeOfCurrency) {
                                                                profitabilityValueRate =
                                                                        currencyRate.getCurrencyRate().doubleValue();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("No banks on the balance of which there is a sufficient amount for the exchange of.");
        }
        return resultBank;
    }

    private Bank determineBankProfitabilityRate(TypeOfCurrency fromTypeOfCurrency, TypeOfCurrency inTypeOfCurrency,
                                                Bank resultBank, double profitabilityValueRate, double valueForComparison,
                                                Bank bank) {
        switch (fromTypeOfCurrency) {
            case UAH:
                resultBank = determineBankProfitabilityRateForExchangeCurrencyUAH(inTypeOfCurrency, resultBank,
                        profitabilityValueRate, valueForComparison,
                        bank);
                break;
            case EUR:
                resultBank = determineBankProfitabilityRateForExchangeCurrencyEUR(inTypeOfCurrency, resultBank,
                        profitabilityValueRate, valueForComparison,
                        bank);
                break;
            case USD:
                resultBank = determineBankProfitabilityRateForExchangeCurrencyUSD(inTypeOfCurrency, resultBank,
                        profitabilityValueRate, valueForComparison,
                        bank);
                break;
            case RUB:
                resultBank = determineBankProfitabilityRateForExchangeCurrencyRUB(inTypeOfCurrency, resultBank,
                        profitabilityValueRate, valueForComparison,
                        bank);
                break;
        }
        return resultBank;
    }

    private Bank determineBankProfitabilityRateForExchangeCurrencyRUB(TypeOfCurrency inTypeOfCurrency,
                                                                      Bank resultBank, double profitabilityValueRate,
                                                                      double valueForComparison,
                                                                      Bank bank) {
        switch (inTypeOfCurrency) {
            case EUR:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
            case USD:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
            case UAH:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
        }
        return resultBank;
    }

    private Bank getResultBankIfRateLowAsPossibleForBetterResult(Bank resultBank, double profitabilityValueRate,
                                                                 double valueForComparison, Bank bank) {
        if (profitabilityValueRate == 0) {
            profitabilityValueRate = valueForComparison;
            if (valueForComparison <= profitabilityValueRate) {
                resultBank = bank;
            }
        } else if (valueForComparison <= profitabilityValueRate) {
            resultBank = bank;
        }
        return resultBank;
    }

    private Bank determineBankProfitabilityRateForExchangeCurrencyUSD(TypeOfCurrency inTypeOfCurrency, Bank resultBank,
                                                                      double profitabilityValueRate, double valueForComparison, Bank bank) {
        switch (inTypeOfCurrency) {
            case EUR:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
            case UAH:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
            case RUB:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
        }
        return resultBank;
    }

    private Bank determineBankProfitabilityRateForExchangeCurrencyEUR(TypeOfCurrency inTypeOfCurrency, Bank resultBank,
                                                                      double profitabilityValueRate, double valueForComparison, Bank bank) {
        switch (inTypeOfCurrency) {
            case USD:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
            case UAH:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
            case RUB:
                if (valueForComparison > profitabilityValueRate) {
                    resultBank = bank;
                }
                break;
        }
        return resultBank;
    }

    private Bank determineBankProfitabilityRateForExchangeCurrencyUAH(TypeOfCurrency inTypeOfCurrency, Bank resultBank,
                                                                      double profitabilityValueRate, double valueForComparison,
                                                                      Bank bank) {
        switch (inTypeOfCurrency) {
            case EUR:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
            case USD:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
            case RUB:
                resultBank = getResultBankIfRateLowAsPossibleForBetterResult(resultBank, profitabilityValueRate,
                        valueForComparison, bank);
                break;
        }
        return resultBank;
    }


    @Override
    public List<Bank> determineBanksListHaveCorrectnessOfSumOnBalanceForCurrencyExchange(List<Bank> banksList, TypeOfCurrency inTypeOfCurrency,
                                                                                         BigDecimal sumForExchange) {
        List<Bank> resultBanksList = new ArrayList<>(0);
        if ((banksList != null) && (banksList.size() > 0)) {
            banksList.forEach(bank -> bank.getCurrencyBalanceList().forEach(currencyBalance -> {
                if (currencyBalance.getTypeOfCurrency() == inTypeOfCurrency) {
                    if (currencyBalance.getCurrencyBalance().doubleValue() > sumForExchange.doubleValue()) {
                        resultBanksList.add(bank);
                    }
                }
            }));
        } else {
            System.out.println("The list of banks is empty or not created");
        }
        return resultBanksList;
    }

}
