package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  Book book;
  Book bookCopy;
  Book bookVary;
  String firstName = "John";
  String lastName = "Lee";
  Author author = new Author(firstName, lastName);
  RecordingArtist artist = new RecordingArtist(firstName, lastName);
  Author authorVary = new Author(firstName, "Xu");
  int year = 1960;
  String title = "Gone With Wind";
  @Before
  public void setUp() throws Exception {
    book = new Book(author,title,year);
    bookCopy = new Book(author,title,year);
    bookVary = new Book(author,title,1998);
  }

  @Test
  public void getAuthor() {
    assertTrue(author.equals(book.getAuthor()));
  }

  @Test
  public void getYear() {
    assertEquals(year,book.getYear());
  }

  @Test
  public void search() {
    assertTrue(book.search("Wind"));
    assertTrue(book.search("wind"));
    assertFalse(book.search("Dog"));
  }

  @Test
  public void testSearch() {
    assertTrue(book.search(author));
    assertFalse(book.search(authorVary));
  }

  @Test
  public void testSearch1() {
    assertFalse(book.search(artist));
  }

  @Test
  public void getTitle() {
    assertTrue(title.equals(book.getTitle()));
  }

  @Test
  public void testEquals() {
    assertTrue(book.equals(book));
    assertTrue(book.equals(bookCopy));
    assertFalse(book.equals(bookVary));
    assertFalse(book.equals(null));
    assertFalse(book.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(book.hashCode() == bookCopy.hashCode());
    assertFalse(book.hashCode() == bookVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(book.toString().equals(bookCopy.toString()));
    assertFalse(book.toString().equals(bookVary.toString()));
  }
}