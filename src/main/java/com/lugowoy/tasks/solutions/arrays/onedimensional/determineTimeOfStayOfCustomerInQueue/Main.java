package com.lugowoy.tasks.solutions.arrays.onedimensional.determineTimeOfStayOfCustomerInQueue;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * At the counter of the store, a line of n customers lined up.
 * The service time of the i-th customer is tj (i = 1, ..., n).
 * Determine the time Ci of the stay of the i-th customer in the queue.
 *
 * <p> Created by Konstantin Lugowoy on 16.03.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number customer in the queue : ");
        int numberOfCustomersInTheQueue = READER.readInt();

        Queue<Customer> customerQueue = new Queue<>();

        fillCustomerQueue(customerQueue, numberOfCustomersInTheQueue);

        System.out.println("Result queue : ");
        Arrays.stream(customerQueue.getQueue()).forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("Enter time of service for the customer : ");
        Queue.setTimeService(new BigDecimal(READER.readDouble()));

        Determinant<Customer, BigDecimal> determinant = Determinant::determineTimeOfStayCustomerInTheQueue;

        BigDecimal resultTime = determinant.determine(customerQueue, numberOfCustomersInTheQueue);

        System.out.printf("Result time : %f", resultTime.setScale(2, RoundingMode.DOWN).doubleValue());

    }

    private static void fillCustomerQueue(Queue<Customer> customerQueue, int quantityCustomers) {
        Customer[] customers = new Customer[quantityCustomers];
        for (int i = 0; i < quantityCustomers; i++) {
            customers[i] = new Customer();
        }
        customerQueue.setQueue(customers);
    }

}
