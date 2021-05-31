package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {
    Locker locker;

    @Before
    public void setUp() throws Exception {
        locker = new Locker(12,14,16);
    }

    @Test(expected = IllegalInchesException.class)
    public void invalidInchesLocker() throws IllegalInchesException {
        Locker invalidLocker = new Locker(1,14,16);
    }

    @Test(expected = IllegalInchesException.class)
    public void invalidInchesLockerZero() throws IllegalInchesException {
        Locker invalidLocker = new Locker(2,0,16);
    }

    @Test(expected = IllegalInchesException.class)
    public void invalidInchesLockerNega() throws IllegalInchesException {
        Locker invalidLocker = new Locker(2,3,-1);
    }

    @Test
    public void getWidthLocker() {
        assertEquals(12,locker.getWidthLocker());
    }

    @Test
    public void getHeightLocker() {
        assertEquals(14,locker.getHeightLocker());

    }

    @Test
    public void getDepthLocker() {
        assertEquals(16,locker.getDepthLocker());
    }

    @Test
    public void getItem() throws IllegalInchesException {
        assertEquals(null,locker.getItem());
    }

    @Test
    public void addMail() throws IllegalInchesException, InvalidItemAddException {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        MailItem item = new MailItem(5,5,5,recipientAmy);
        locker.addMail(item);
        MailItem.assertItemEquals(item ,locker.getItem());
    }

    @Test(expected = InvalidItemAddException.class)
    public void invalidAddMail() throws IllegalInchesException, InvalidItemAddException {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        MailItem item = new MailItem(12,16,18,recipientAmy);
        MailItem newItem = new MailItem(16,16,20,recipientAmy);
        locker.addMail(item);
        locker.addMail(newItem);
    }

    @Test(expected = InvalidPickupException.class)
    public void invalidPickupMail() throws IllegalInchesException, InvalidPickupException {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        locker.pickupMail(recipientAmy);
    }

    @Test
    public void pickupMail() throws IllegalInchesException, InvalidItemAddException, InvalidPickupException {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        MailItem item = new MailItem(3,3,3,recipientAmy);
        locker.addMail(item);
        MailItem.assertItemEquals(item,locker.pickupMail(recipientAmy));
    }
}