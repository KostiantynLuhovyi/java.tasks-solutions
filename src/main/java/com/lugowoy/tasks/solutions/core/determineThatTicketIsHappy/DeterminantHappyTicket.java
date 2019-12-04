package com.lugowoy.tasks.solutions.core.determineThatTicketIsHappy;

/**
 * Created by Konstantin Lugowoy on 18.08.2017.
 */

public interface DeterminantHappyTicket {

    int MIN_VALUE_OF_NUMBER_TICKET = 100000;
    int MAX_VALUE_OF_NUMBER_TICKET = 999999;

    boolean determine(Ticket ticket);

    static boolean determineThatTicketIsHappyUsingString(Ticket ticket) {
        boolean result = false;
        if (ticket != null) {
            if (ticket.getNumber() > 0) {
                String valueNumberTicket = Integer.toString(ticket.getNumber());
                if (valueNumberTicket.length() > 6) {
                    int firstPartOfNumberTicket = valueNumberTicket.charAt(0) + valueNumberTicket.charAt(1) + valueNumberTicket.charAt(2);
                    int secondPartOfNumberTicket = valueNumberTicket.charAt(3) + valueNumberTicket.charAt(4) + valueNumberTicket.charAt(5);
                    if (firstPartOfNumberTicket == secondPartOfNumberTicket) {
                        result = true;
                    }
                }
            } else {
                System.err.println("The ticket has an incorrect number value.");
            }
        } else {
            System.err.println("Ticket is null.");
        }
        return result;
    }

    static boolean determineThatTicketIsHappyUsingArithmeticOperators(Ticket ticket) {
        boolean result = false;
        if (ticket != null) {
            if ((ticket.getNumber() > 0)
                    && ((ticket.getNumber() >= MIN_VALUE_OF_NUMBER_TICKET)
                    && (ticket.getNumber() <= MAX_VALUE_OF_NUMBER_TICKET))) {
                int firstDigitOfNumberTicket = ticket.getNumber() % 100000;
                int secondDigitOfNumberTicket = (ticket.getNumber() % 100000) / 10000;
                int thirdDigitOfNumberTicket = (ticket.getNumber() % 10000) / 1000;
                int fourthDigitOfNumberTicket = (ticket.getNumber() % 1000) / 100;
                int fifthDigitOfNumberTicket = (ticket.getNumber() % 100) / 10;
                int sixthDigitOfNumberTicket = (ticket.getNumber() % 10);

                if (sixthDigitOfNumberTicket + fifthDigitOfNumberTicket + fourthDigitOfNumberTicket
                        == firstDigitOfNumberTicket + secondDigitOfNumberTicket + thirdDigitOfNumberTicket) {
                    result = true;
                }

            } else {
                System.err.println("The ticket has an incorrect number value.");
            }
        } else {
            System.err.println("Ticket is null.");
        }
        return result;
    }

}
