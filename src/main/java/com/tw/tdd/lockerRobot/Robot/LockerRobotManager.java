package com.tw.tdd.lockerRobot.Robot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Locker.sSizeLocker;
import com.tw.tdd.lockerRobot.Ticket.Ticket;

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
        throw new NoRoomException();
    }
}
