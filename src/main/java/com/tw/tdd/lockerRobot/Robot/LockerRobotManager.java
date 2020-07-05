package com.tw.tdd.lockerRobot.Robot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.mSizeBag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Locker.mSizeLocker;
import com.tw.tdd.lockerRobot.Locker.sSizeLocker;
import com.tw.tdd.lockerRobot.Ticket.Ticket;
import com.tw.tdd.lockerRobot.Ticket.mSizeTicket;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

import java.util.List;

public class LockerRobotManager {
    private  List<sSizeLocker> sSizeLockers;
    private  List<PrimaryLockerRobot> primaryLockerRobot;
    private  List<SuperLockerRobot> superLockerRobot;

    public LockerRobotManager(List<sSizeLocker> lockers, List<PrimaryLockerRobot> primaryLockerRobot, List<SuperLockerRobot> superLockerRobot) {
        this.sSizeLockers = lockers;
        this.primaryLockerRobot = primaryLockerRobot;
        this.superLockerRobot = superLockerRobot;
    }


    public Ticket store(Bag bag) {
        if (bag instanceof sSizeBag) {
            for (sSizeLocker sSizelocker : sSizeLockers) {
                if (sSizelocker.getValidCapacity() > 0) {
                    return sSizelocker.store(bag);
                }
            }
        }

        if (bag instanceof mSizeBag) {
            for ( PrimaryLockerRobot primaryLockerRobot : primaryLockerRobot) {
                if (primaryLockerRobot.getValidCapacity() > 0) {
                    return primaryLockerRobot.store(bag);
                }
            }
        }
        throw new NoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
        if (ticket instanceof sSizeTicket) {
            for (sSizeLocker locker : sSizeLockers) {
                return locker.pickUp(ticket);
            }
        }

        if (ticket instanceof mSizeTicket) {
            for (LockerRobot primaryLockerRobot : primaryLockerRobot) {
                if (primaryLockerRobot.isValidTicket(ticket)) {
                    return primaryLockerRobot.pickUp(ticket);
                }
            }
        }
        return null;
    }


}
