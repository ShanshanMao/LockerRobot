package com.tw.tdd.lockerRobot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Locker.sSizeLocker;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class LockerRobotTest {

    @Test
    void should_store_ordinary_user_sSizeBag_in_sSizeLocker_and_return_sSizeTicket_when_xiaoying_store_bag_given_sSizeLocker_have_capacity() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);
        assertNotNull(ticket);
    }
}
