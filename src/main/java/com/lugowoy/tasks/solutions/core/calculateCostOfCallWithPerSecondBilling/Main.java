package com.lugowoy.tasks.calculateCostOfCallWithPerSecondBilling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_DOWN;

/**
 * The user enters the start time and the end time of the telephone conversation from the keyboard (hours, minutes and seconds).
 * Calculate the cost of the call, if the cost of the minute is 15 cents, taking into account per second charging.
 * <p>
 * Created by Konstantin Lugowoy on 06.06.2017.
 */

public class Main {

    private static final int MINUTES_OF_HOUR = 60;

    public static void main(String[] args) {

        long timeOfStartCallInSeconds = enterCallTimeInSeconds("Enter the start time of the call.");
        long timeOfFinishCallInSeconds = enterCallTimeInSeconds("Enter the finish time of the call.");

        System.out.println("Enter the cost of the minutes : ");
        BigDecimal costOfMinutes = new BigDecimal(Reader.getReader(new ReadingConsole()).readDouble());

        BigDecimal costOfTheCall = calculateCostOfCall(costOfMinutes, timeOfStartCallInSeconds, timeOfFinishCallInSeconds);

        System.out.println("The cost of the call is : " + costOfTheCall);

    }

    private static BigDecimal calculateCostOfCall(BigDecimal costOfMinutes, long timeOfStartCallInSeconds,
                                                                            long timeOfFinishCallInSeconds) {
        BigDecimal timeToCall = new BigDecimal(timeOfFinishCallInSeconds - timeOfStartCallInSeconds);
        return new BigDecimal(timeToCall.doubleValue()).multiply(costOfMinutes.divide(new BigDecimal(MINUTES_OF_HOUR), 3, HALF_DOWN));
    }

    private static long enterCallTimeInSeconds(String msg) {
        Reader reader = Reader.getReader(new ReadingConsole());
        System.out.println(msg);
        int hours, minutes, seconds;
        while (true) {
            System.out.println("Hours : ");
            hours = reader.readInt();
            System.out.println("Minutes : ");
            minutes = reader.readInt();
            System.out.println("Seconds : ");
            seconds = reader.readInt();
            if ((minutes > 60) && (seconds > 60)) {
                System.out.println("Incorrect input. Re-enter : ");
            } else {
                break;
            }
        }
        return (long) (hours * 3600 + minutes * 60 + seconds);
    }

}
