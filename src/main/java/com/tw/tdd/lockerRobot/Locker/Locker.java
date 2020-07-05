package com.tw.tdd.lockerRobot.Locker;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Exception.InvalidTicketException;
import com.tw.tdd.lockerRobot.Ticket.Ticket;
import com.tw.tdd.lockerRobot.Ticket.lSizeTicket;

import java.util.HashMap;
import java.util.Map;

public abstract class Locker {
    private int capacity;
    protected Map<Ticket, Bag> lockerMap = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Bag pickUp(Ticket ticket) {
        if (isValidTicket( ticket))
            return lockerMap.get(ticket);
        throw new InvalidTicketException();
    }

    public boolean isValidTicket(Ticket ticket) {
        return lockerMap.get(ticket) != null;
    }

    public  int getValidCapacity() {
        return capacity - lockerMap.size();
    }

    public abstract Ticket store(Bag bag);
}
