package com.tw.tdd.lockerRobot.Locker;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

public class sSizeLocker extends Locker{
    public sSizeLocker(int capacity) {
        super(capacity);
    }
    public sSizeTicket store(Bag bag) {
        if (bag instanceof sSizeBag){
            sSizeTicket ticket = new sSizeTicket();
            lockerMap.put(ticket,bag);
            return ticket;
        }
        return null;
    }
}
