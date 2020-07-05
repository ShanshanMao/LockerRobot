package com.tw.tdd.lockerRobot.Locker;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Ticket.Ticket;
import com.tw.tdd.lockerRobot.Ticket.lSizeTicket;

public class lSizeLocker extends Locker {
    public lSizeLocker(int capacity) {
        super(capacity);
    }
    public Ticket store(Bag bag){
        lSizeTicket ticket = new lSizeTicket();
        lockerMap.put(ticket, bag);
        return ticket;
    }
}
