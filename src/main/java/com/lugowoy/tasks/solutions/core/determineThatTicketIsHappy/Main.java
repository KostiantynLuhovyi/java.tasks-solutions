package com.lugowoy.tasks.solutions.core.determineThatTicketIsHappy;

import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import static com.lugowoy.tasks.solutions.core.determineThatTicketIsHappy.DeterminantHappyTicket.MAX_VALUE_OF_NUMBER_TICKET;
import static com.lugowoy.tasks.solutions.core.determineThatTicketIsHappy.DeterminantHappyTicket.MIN_VALUE_OF_NUMBER_TICKET;

/**
 * To determine that the ticket is happy.
 * <p>
 * Created by Konstantin Lugowoy on 20.08.2017.
 */

public class Main {

    public static void main(String[] args) {

        Ticket ticket = new Ticket(GeneratorRandomNumber.generateInt(MIN_VALUE_OF_NUMBER_TICKET, MAX_VALUE_OF_NUMBER_TICKET));

        DeterminantHappyTicket determinant = DeterminantHappyTicket::determineThatTicketIsHappyUsingArithmeticOperators;

        if (determinant.determine(ticket)) {
            System.out.printf("Ticket number %d is \"happy\".", ticket.getNumber());
        } else {
            System.out.printf("Ticket number %d is not \"happy\".", ticket.getNumber());
        }


    }

}
