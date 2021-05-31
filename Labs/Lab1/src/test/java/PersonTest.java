import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("John","Lee");
    }

    @Test
    public void getFirstName() {
        assertEquals("John",person.getFirstName());
    }

    @Test
    public void setFirstName() {
        person.setFirstName("Amy");
        assertEquals("Amy",person.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Lee",person.getLastName());
    }

    @Test
    public void setLastName() {
        person.setLastName("Peng");
        assertEquals("Peng",person.getLastName());
    }
}