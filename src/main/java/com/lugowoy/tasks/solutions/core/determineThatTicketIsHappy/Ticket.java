package com.lugowoy.tasks.solutions.core.determineThatTicketIsHappy;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 18.08.2017.
 */

public class Ticket implements Serializable, Cloneable {

    private int number;

    public Ticket() {
    }

    public Ticket(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        return number == ticket.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    protected Ticket clone() throws CloneNotSupportedException {
        Ticket ticket = (Ticket) super.clone();
        ticket.setNumber(this.getNumber());
        return ticket;
    }

    @Override
    public String toString() {
        return "Ticket[" +
                "number=" + number +
                ']';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
