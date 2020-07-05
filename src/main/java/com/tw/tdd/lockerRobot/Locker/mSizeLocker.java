package com.tw.tdd.lockerRobot.Locker;


import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Ticket.Ticket;
import com.tw.tdd.lockerRobot.Ticket.mSizeTicket;

import java.awt.datatransfer.SystemFlavorMap;

public class mSizeLocker extends Locker {
    public mSizeLocker(int capacity) {
        super(capacity);
    }
    public Ticket store(Bag bag) {
        mSizeTicket ticket = new mSizeTicket();
        lockerMap.put(ticket, bag);
        return ticket;
    }
}
