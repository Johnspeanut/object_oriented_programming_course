package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipientTest {
    Recipient recipient;

    @Before
    public void setUp() throws Exception {
        recipient = new Recipient("Amy","Lee","AmyLee@neu.edu");
    }

    @Test
    public void getFirstName() {
        assertEquals("Amy",recipient.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Lee",recipient.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals("AmyLee@neu.edu",recipient.getEmail());
    }

    @Test
    public void assertRecipientEquals(){
        Recipient recipientA = new Recipient("Amy","Lee","AmyLee@neu.edu");
        Recipient recipientB = new Recipient("John","Lee","JohnLee@neu.edu");
        Recipient.assertRecipientEquals(recipientA,recipientB);
    }

    @Test
    public void validEquals(){
        Recipient recipientA = new Recipient("Amy","Lee","AmyLee@neu.edu");
        Recipient recipientB = new Recipient("Amy","Lee","AmyLee@neu.edu");
        assertEquals(true,recipientA.equals(recipientB));
    }

    @Test
    public void unequals(){
        Recipient recipientA = new Recipient("Amy","Lee","AmyLee@neu.edu");
        Recipient recipientB = new Recipient("John","Lee","JohnLee@neu.edu");
        assertEquals(false,recipientA.equals(recipientB));
    }
}