package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

  Author author;
  Author authorCopy;
  Author authorVary;
  String firstName = "John";
  String lastName = "Lee";

  @Before
  public void setUp() throws Exception {
    author = new Author(firstName, lastName);
    authorVary = new Author(firstName, "Xu");
    authorCopy = new Author(firstName, lastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(firstName, author.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(lastName, author.getLastName());
  }

  @Test
  public void testEquals() {
    assertTrue(author.equals(author));
    assertTrue(author.equals(authorCopy));
    assertFalse(author.equals(authorVary));
    assertFalse(author.equals(null));
    assertFalse(author.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(author.hashCode() == authorCopy.hashCode());
    assertFalse(author.hashCode() == authorVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(author.toString().equals(authorCopy.toString()));
    assertFalse(author.toString().equals(authorVary.toString()));
  }
}