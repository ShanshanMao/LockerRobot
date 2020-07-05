package com.tw.tdd.lockerRobot.Robot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Locker.Locker;
import com.tw.tdd.lockerRobot.Locker.lSizeLocker;
import com.tw.tdd.lockerRobot.Ticket.Ticket;

import java.util.List;

public class SuperLockerRobot extends LockerRobot{
    public SuperLockerRobot(List<Locker> lockers) {
        super(lockers);
    }
    public Ticket store(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.getValidCapacity() > 0) {
                return locker.store(bag);
            }
        }
        throw new NoRoomException();
    }
}
