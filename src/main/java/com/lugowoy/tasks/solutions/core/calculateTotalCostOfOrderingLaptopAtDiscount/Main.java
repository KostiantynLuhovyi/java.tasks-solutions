package com.lugowoy.tasks.calculateTotalCostOfOrderingLaptopAtDiscount;

import com.lugowoy.helper.calculating.CalculationThreeParameters;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * The user enters from the keyboard the cost of one laptop, their number and percentage discount.
 * Calculate the total cost of the order.
 * <p>
 * Created by Konstantin Lugowoy on 15.06.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int SCALE = 2;

    private static final int BOUND_OF_ID_LAPTOP = 10;

    private static final String BRAND_NAME_OF_LAPTOP = "Dell";

    public static void main(String[] args) {

        Laptop laptop = new Laptop(new Random().nextInt(BOUND_OF_ID_LAPTOP), BRAND_NAME_OF_LAPTOP, enterPrice());

        Integer numberOfLaptop = enterNumberOfLaptop();

        BigDecimal discount = enterTotalDiscountOnTheLaptop();

        System.out.println("The total cost of the order : " + CALCULATING.calculate(laptop, numberOfLaptop, discount).doubleValue());

    }

    private static final CalculationThreeParameters<BigDecimal, Laptop, Integer, BigDecimal> CALCULATING = (laptop,
                                                                                                            numberOfLaptop,
                                                                                                            discount) -> {
        BigDecimal sumPriceOfLaptop = new BigDecimal(laptop.getPrice().multiply(new BigDecimal(numberOfLaptop)).doubleValue());
        return new BigDecimal(sumPriceOfLaptop.subtract(sumPriceOfLaptop.multiply(discount)
                                                                        .divide(new BigDecimal(100), SCALE, RoundingMode.DOWN))
                                                                        .doubleValue());
    };

    private static int enterNumberOfLaptop() {
        int numberOfLaptop;
        System.out.println("Enter the number of laptops : ");
        while (true) {
            numberOfLaptop = READER.readInt();
            if (numberOfLaptop > 0) {
                break;
            } else {
                System.out.println("Number of laptop must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return numberOfLaptop;
    }

    private static BigDecimal enterTotalDiscountOnTheLaptop() {
        BigDecimal discount;
        System.out.println("Enter the total discount on the laptop : ");
        while (true) {
            double enterDiscount = READER.readDouble();
            if ((enterDiscount >= 0) && (enterDiscount <= 100)) {
                discount = new BigDecimal(enterDiscount);
                break;
            } else {
                System.out.println("The discount on the laptop must be a positive number or not exceed 100% .");
                System.out.println("Re-enter : ");
            }
        }
        return discount;
    }

    private static BigDecimal enterPrice() {
        BigDecimal price;
        System.out.println("Enter price of the laptop : ");
        while (true) {
            double enterPrice = READER.readDouble();
            if (enterPrice > 0) {
                price = new BigDecimal(enterPrice);
                break;
            } else {
                System.out.println("The price for a laptop must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return price;
    }

}
