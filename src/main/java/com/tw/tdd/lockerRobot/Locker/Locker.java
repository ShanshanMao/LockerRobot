package com.tw.tdd.lockerRobot.Locker;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    protected int capacity;
    protected Map<sSizeTicket, Bag> lockerMap = new HashMap<com.tw.tdd.lockerRobot.Ticket.sSizeTicket, Bag>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Bag pickUp(sSizeTicket ticket) {
        if (isValidTicket(ticket))
            return lockerMap.get(ticket);
        return null;
    }

    private boolean isValidTicket(sSizeTicket ticket) {
        return lockerMap.get(ticket) != null;
    }
}
