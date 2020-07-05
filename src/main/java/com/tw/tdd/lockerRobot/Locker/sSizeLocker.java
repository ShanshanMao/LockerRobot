package com.tw.tdd.lockerRobot.Locker;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Ticket.Ticket;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

public class sSizeLocker extends Locker{
    public sSizeLocker(int capacity) {
        super(capacity);
    }
    public Ticket store(Bag bag) {
        if (getValidCapacity() > 0) {
            sSizeTicket ticket = new sSizeTicket();
            lockerMap.put(ticket, bag);
            return ticket;
        }
        throw new NoRoomException();
    }
}
