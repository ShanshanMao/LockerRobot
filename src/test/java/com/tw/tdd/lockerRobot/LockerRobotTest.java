package com.tw.tdd.lockerRobot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.lSizeBag;
import com.tw.tdd.lockerRobot.Bag.mSizeBag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Exception.InvalidTicketException;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Locker.lSizeLocker;
import com.tw.tdd.lockerRobot.Locker.mSizeLocker;
import com.tw.tdd.lockerRobot.Locker.sSizeLocker;
import com.tw.tdd.lockerRobot.Robot.LockerRobotManager;
import com.tw.tdd.lockerRobot.Robot.PrimaryLockerRobot;
import com.tw.tdd.lockerRobot.Robot.SuperLockerRobot;
import com.tw.tdd.lockerRobot.Ticket.lSizeTicket;
import com.tw.tdd.lockerRobot.Ticket.mSizeTicket;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotTest {

    @Test
    void should_store_ordinary_user_sSizeBag_in_sSizeLocker_and_return_sSizeTicket_when_xiaoying_store_bag_given_sSizeLocker_have_capacity() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_store_ordinary_user_sSizeBag_in_sSizeLocker_fail_when_xiaoying_store_bag_given_sSizeLocker_is_full() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        xiaoying.store(bag);

        assertThrows(NoRoomException.class, () -> xiaoying.store(bag));
    }

    @Test
    void should_pick_up_ordinary_user_sSizeBag_in_sSizeLocker_success_when_xiaoying_pick_up_bag_given_valid_sSizeTicket() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);

        Bag returnBag = xiaoying.pickUp(ticket);
        assertEquals(bag, returnBag);
    }
    @Test
    void should_pick_up_ordinary_user_sSizeBag_in_sSizeLocker_fail_when_xiaoying_pick_up_bag_given_PrimaryLockerRobot_manage_mSizeLocker_get_valid_mSizeTicket() {
        Bag bag = new sSizeBag();
        mSizeLocker primaryLockerRobot = new mSizeLocker(1);
        PrimaryLockerRobot xiaoying = new PrimaryLockerRobot(singletonList(primaryLockerRobot));
        mSizeTicket ticket = (mSizeTicket) xiaoying.store(bag);

        Bag returnBag = primaryLockerRobot.pickUp(ticket);
        assertEquals(bag, returnBag);
    }

    @Test
    void should_store_VIP_user_sSizeBag_in_sSizeLocker_and_return_sSizeTicket_when_LockerRobotManager_store_bag_given_sSizeLocker_have_capacity() {
        sSizeLocker sSizelocker = new sSizeLocker(1);
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizeLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(singletonList(superSizeLocker));
        LockerRobotManager manager = new LockerRobotManager(singletonList(sSizelocker), singletonList(primaryLockerRobot), singletonList(superLockerRobot));

        Bag bag = new sSizeBag();
        sSizeTicket ticket = (sSizeTicket) manager.store(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_store_VIP_user_sSizeBag_in_sSizeLocker_fail_when_LockerRobotManager_store_bag_given_sSizeLocker_is_full() {
        sSizeLocker sSizelocker = new sSizeLocker(1);
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizeLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(singletonList(superSizeLocker));
        LockerRobotManager manager = new LockerRobotManager(singletonList(sSizelocker), singletonList(primaryLockerRobot), singletonList(superLockerRobot));

        Bag bag = new sSizeBag();
        manager.store(bag);

        assertThrows(NoRoomException.class, () -> manager.store(new Bag()));
    }

    @Test
    void should_pick_up_VIP_user_sSizeBag_in_sSizeLocker_success_when_LockerRobotManager_pick_up_bag_given_valid_sSizeTicket() {
        Bag bag = new sSizeBag();
        sSizeLocker locker = new sSizeLocker(1);
        LockerRobotManager manager = new LockerRobotManager(singletonList(locker), null, null);
        sSizeTicket ticket = (sSizeTicket) manager.store(bag);

        Bag returnBag = manager.pickUp(ticket);

        assertEquals(bag, returnBag);
    }

    @Test
    void should_store_ordinary_user_mSizeBag_in_mSizeLocker_and_return_mSizeTicket_when_xiaoying_store_bag_given_PrimaryLockerRobot_manage_mSizeLocker_have_capacity() {
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        PrimaryLockerRobot xiaoying = new PrimaryLockerRobot(singletonList(primarySizeLocker));

        Bag bag = new mSizeBag();
        mSizeTicket mSizeticket = (mSizeTicket) xiaoying.store(bag);

        Assertions.assertNotNull(mSizeticket);
    }

    @Test
    void should_store_ordinary_user_mSizeBag_in_mSizeLocker_fail_when_xiaoying_store_bag_given_PrimaryLockerRobot_manage_mSizeLocker_is_full() {
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        PrimaryLockerRobot xiaoying = new PrimaryLockerRobot(singletonList(primarySizeLocker));

        Bag bag = new mSizeBag();
        xiaoying.store(bag);
        Bag myBag = new mSizeBag();

        assertThrows(NoRoomException.class, () -> xiaoying.store(myBag));
    }

    @Test
    void should_pick_up_ordinary_user_mSizeBag_in_mSizeLocker_success_when_xiaoying_pick_up_bag_given_valid_mSizeTicket() {
        Bag bag = new mSizeBag();
        mSizeLocker primaryLocker = new mSizeLocker(1);
        PrimaryLockerRobot xiaoying = new PrimaryLockerRobot(singletonList(primaryLocker));
        mSizeTicket ticket = (mSizeTicket) xiaoying.store(bag);

        Bag returnBag = primaryLocker.pickUp(ticket);

        assertEquals(bag, returnBag);
    }

    @Test
    void should_pick_up_ordinary_user_mSizeBag_in_mSizeLocker_fail_when_xiaoying_pick_up_bag_given_valid_sSizeTicket() {
        mSizeLocker primarySizelocker = new mSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizelocker));

        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);

        assertThrows(InvalidTicketException.class, () -> primaryLockerRobot.pickUp(ticket));
    }

    @Test
    void should_store_VIP_user_mSizeBag_in_mSizeLocker_and_return_mSizeTicket_when_LockerRobotManager_store_bag_given_mSizeLocker_have_capacity() {
        sSizeLocker sSizelocker = new sSizeLocker(1);
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizeLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(singletonList(superSizeLocker));
        LockerRobotManager manager = new LockerRobotManager(singletonList(sSizelocker),singletonList(primaryLockerRobot), singletonList(superLockerRobot));

        Bag bag = new mSizeBag();
        mSizeTicket ticket = (mSizeTicket) manager.store(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_store_VIP_user_mSizeBag_in_mSizeLocker_fail_when_LockerRobotManager_store_bag_given_mSizeLocker_is_full() {
        sSizeLocker sSizelocker = new sSizeLocker(1);
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizeLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(singletonList(superSizeLocker));
        LockerRobotManager manager = new LockerRobotManager(singletonList(sSizelocker), singletonList(primaryLockerRobot), singletonList(superLockerRobot));

        Bag bag = new mSizeBag();
        manager.store(bag);

        assertThrows(NoRoomException.class, () -> manager.store(new Bag()));
    }

    @Test
    void should_pick_up_VIP_user_mSizeBag_in_mSizeLocker_success_when_LockerRobotManager_pick_up_bag_given_valid_mSizeTicket() {
        Bag bag = new mSizeBag();
        mSizeLocker primarySizeLocker = new mSizeLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(primarySizeLocker));
        LockerRobotManager manager = new LockerRobotManager(null, singletonList(primaryLockerRobot), null);
        mSizeTicket ticket = (mSizeTicket) manager.store(bag);

        Bag returnBag = manager.pickUp(ticket);

        assertEquals(bag, returnBag);
    }
    @Test
    void should_store_ordinary_user_lSizeBag_in_lSizeLocker_and_return_lSizeTicket_when_xiaoying_store_bag_given_SuperLockerRobot_manage_lSizeLocker_have_capacity() {
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        SuperLockerRobot xiaoying = new SuperLockerRobot(singletonList(superSizeLocker));

        Bag bag = new lSizeBag();
        lSizeTicket lSizeticket = (lSizeTicket) xiaoying.store(bag);

        Assertions.assertNotNull(lSizeticket);
    }

    @Test
    void should_store_ordinary_user_lSizeBag_in_lSizeLocker_fail_when_xiaoying_store_bag_given_SuperLockerRobot_manage_lSizeLocker_is_full() {
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        SuperLockerRobot xiaoying = new SuperLockerRobot(singletonList(superSizeLocker));

        Bag bag = new lSizeBag();
        xiaoying.store(bag);
        Bag myBag = new lSizeBag();

        assertThrows(NoRoomException.class, () -> xiaoying.store(myBag));
    }

    @Test
    void should_pick_up_ordinary_user_lSizeBag_in_lSizeLocker_success_when_xiaoying_pick_up_bag_given_valid_lSizeTicket() {
        Bag bag = new lSizeBag();
        lSizeLocker superSizeLocker = new lSizeLocker(1);
        SuperLockerRobot xiaoying = new SuperLockerRobot(singletonList(superSizeLocker));
        lSizeTicket ticket = (lSizeTicket) xiaoying.store(bag);

        Bag returnBag = superSizeLocker.pickUp(ticket);

        assertEquals(bag, returnBag);
    }

    @Test
    void should_pick_up_ordinary_user_lSizeBag_in_lSizeLocker_fail_when_xiaoying_pick_up_bag_given_valid_sSizeTicket() {
        lSizeLocker superSizelocker = new lSizeLocker(1);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(singletonList(superSizelocker));

        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);

        assertThrows(InvalidTicketException.class, () -> superLockerRobot.pickUp(ticket));
    }


}
