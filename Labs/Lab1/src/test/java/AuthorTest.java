import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author author;
    Person person;

    public static boolean personEquals(Person person1, Person person2){
        if(person1 == person2){
            return true;
        }
        return person1.getFirstName() == person2.getFirstName() && person1.getLastName() == person2.getLastName();
    }

    @Before
    public void setUp() throws Exception {
        person = new Person("John","Lee");
        author = new Author(person,"person@northeastern.edu","255 Terry Ave");
    }

    @Test
    public void getPerson() {
        personEquals(new Person("John","Lee"),author.getPerson());
    }

    @Test
    public void getEmail() {
        assertEquals("person@northeastern.edu",author.getEmail());
    }

    @Test
    public void getAddress() {
        assertEquals("255 Terry Ave",author.getAddress());
    }
}