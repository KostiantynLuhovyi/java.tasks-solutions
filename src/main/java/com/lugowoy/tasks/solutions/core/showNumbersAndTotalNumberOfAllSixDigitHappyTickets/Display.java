package com.lugowoy.tasks.showNumbersAndTotalNumberOfAllSixDigitHappyTickets;

/**
 * Created by Konstantin Lugowoy on 21.10.2017.
 */

@FunctionalInterface
public interface Display {

    void display();

    static void displayAllHappyTickets() {
        int ticket[] = new int[6];
        int countHappyTicketNumber = 0;
        System.out.println("Tickets : ");
        for (int i = 0; i < 999999; i++) {
            for (int k = i, j = 0; j < 6; j++, k /= 10) {
                ticket[j] = k % 10;
            }
            if (ticket[0] + ticket[1] + ticket[2] == ticket[3] + ticket[4] + ticket[5]) {
                for (int j = 0; j < ticket.length; j++) {
                    System.out.print(ticket[j] + " ");
                }
                countHappyTicketNumber++;
            }
        }
        System.out.println("Number of tickets : " + countHappyTicketNumber);
    }

}
