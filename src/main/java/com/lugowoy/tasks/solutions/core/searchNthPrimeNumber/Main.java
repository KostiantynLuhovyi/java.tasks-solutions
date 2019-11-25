package com.lugowoy.tasks.searchNthPrimeNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Realization of the search n-th prime number.
 * <p>
 * Created by Konstantin Lugowoy on 19.11.2016.
 */

public class Main {

    private static final int MAX_ENTER_COUNTING_PRIME_NUMBER = 20001;

    private static final Reader reader = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = reader.readInt();

        FindingPrimeNumber finding = new FindPrimeNumber();

        while (true) {
            if (number < MAX_ENTER_COUNTING_PRIME_NUMBER) {
                int findPrimeNumber = finding.findPrimeNumber(number);
                System.out.printf("%dth prime number is : %d", number, findPrimeNumber);
                break;
            } else {
                System.out.println("Not correct counting prime number.");
                System.out.println("Re-enter (0 ... 20000) : ");
                number = reader.readInt();
            }
        }

    }

}
