package com.lugowoy.tasks.searchNthPrimeNumber;

/**
 * Created by Konstantin Lugowoy on 19.11.2016.
 */

public class FindPrimeNumber implements FindingPrimeNumber {

    private static final int LIMIT_SEARCH_PRIME_NUMBER = 224738;

    @Override
    public int findPrimeNumber(int countingNumber) {
        int count = 0;
        int resultPrimeNumber = 0;

        for (int i = 2; i < LIMIT_SEARCH_PRIME_NUMBER; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                if (count == countingNumber) {
                    resultPrimeNumber = i;
                    break;
                }
            }
        }
        return resultPrimeNumber;
    }

}

