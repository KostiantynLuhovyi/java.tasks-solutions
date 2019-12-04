package com.lugowoy.tasks.solutions.core.calculatingNumberProductsOfPurchasedFromCertainSum;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * How many products can be purchased for the cost of Y on X UAH and how much money will remain?
 * <p>
 * Created by Konstantin Lugowoy on 11-Feb-17.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        User user = new User();
        Product product = new Product();

        System.out.println("Enter available sum of money : ");
        user.setAvailableSumOfMoney(new BigDecimal(READER.readDouble()));

        System.out.println("Enter price of product : ");
        product.setPrice(new BigDecimal(READER.readDouble()));

        int numberOfProducts = user.getAvailableSumOfMoney().divide(product.getPrice(), RoundingMode.DOWN).intValue();

        user.setAvailableSumOfMoney(user.getAvailableSumOfMoney().subtract(product.getPrice().multiply(new BigDecimal(numberOfProducts))));

        System.out.printf("Is bought %d products", numberOfProducts);
        System.out.println();
        System.out.printf("There is money left : %.2f", user.getAvailableSumOfMoney());

    }

}
