package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MailItemTest {
    MailItem mailItem;

    @Before
    public void setUp() throws Exception {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        mailItem = new MailItem(12,16,18,recipientAmy);
    }

    @Test(expected = IllegalInchesException.class)
    public void invalidInches() throws IllegalInchesException {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        MailItem mailItemInvalid = new MailItem(0,-3,5,recipientAmy);
    }

    @Test
    public void getWidthItem() {
        assertEquals(12,mailItem.getWidthItem());
    }

    @Test
    public void getHeightItem() {
        assertEquals(16,mailItem.getHeightItem());
    }

    @Test
    public void getDepthItem() {
        assertEquals(18,mailItem.getDepthItem());
    }

    @Test
    public void getRecipient() {
        Recipient recipientAmy = new Recipient("Amy","Lee","Amy@neu.edu");
        Recipient.assertRecipientEquals(recipientAmy,mailItem.getRecipient());
    }

    @Test
    public void assertItemEquals() throws IllegalInchesException {
        Recipient recipient = new Recipient("Amy","Lee","AmyLee@neu.edu");
        MailItem mailItemA = new MailItem(12,16,18,recipient);
        MailItem mailItemB = new MailItem(12,16,18,recipient);
        MailItem.assertItemEquals(mailItemA,mailItemB);
    }

    @Test
    public void assertItemUnequals() throws IllegalInchesException {
        Recipient recipient = new Recipient("Amy","Lee","AmyLee@neu.edu");
        MailItem mailItemA = new MailItem(12,16,18,recipient);
        MailItem mailItemB = new MailItem(5,16,18,recipient);
        assertEquals(false,MailItem.assertItemEquals(mailItemA,mailItemB));
    }

    @Test
    public void validEquals() throws IllegalInchesException {
        Recipient recipient = new Recipient("Amy","Lee","AmyLee@neu.edu");
        MailItem mailItemA = new MailItem(12,16,18,recipient);
        MailItem mailItemB = new MailItem(12,16,18,recipient);
        assertEquals(true,mailItemA.equals(mailItemB));
        assertEquals(true,mailItemA.equals(mailItemA));
    }

    @Test
    public void invalidEquals() throws IllegalInchesException {
        Recipient recipient = new Recipient("Amy","Lee","AmyLee@neu.edu");
        MailItem mailItemA = new MailItem(12,16,18,recipient);
        MailItem mailItemB = new MailItem(5,5,18,recipient);
        assertEquals(false,mailItemA.equals(mailItemB));
    }
}