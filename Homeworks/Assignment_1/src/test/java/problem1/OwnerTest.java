package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner eason;
    Owner rachel;
    Owner john;

    @Before
    public void setUp() throws Exception {
        eason = new Owner("Eason", "Lee","3012654560");
        rachel = new Owner("Rachel","Lee","2053032640");
//        john = new Owner("John","Lee","122120");
//        assertEquals(null,john);
    }

    @Test
    public void getFirstName() {
        assertEquals("Eason", eason.getFirstName());
        assertEquals("Rachel",rachel.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Lee", eason.getLastName());
        assertEquals("Lee",rachel.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("3012654560",eason.getPhoneNumber());
        assertEquals("2053032640",rachel.getPhoneNumber());
    }

    @Test
    public void setFirstName() {
        eason.setFirstName("Amy");
        assertEquals("Amy", eason.getFirstName());
    }

    @Test
    public void setLastName() {
        eason.setLastName("Peng");
        assertEquals("Peng",eason.getLastName());
    }

    @Test
    public void setPhoneNumber() {
        eason.setPhoneNumber("0000000000");
        assertEquals("0000000000",eason.getPhoneNumber());
    }
}