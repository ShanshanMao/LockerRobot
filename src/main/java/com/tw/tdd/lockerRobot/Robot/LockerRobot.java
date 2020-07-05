package com.tw.tdd.lockerRobot.Robot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Locker.Locker;
import com.tw.tdd.lockerRobot.Ticket.Ticket;

import java.util.List;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            return locker.pickUp(ticket);
        }
        throw null;
    }

    protected abstract Ticket store(Bag bag) ;
}
