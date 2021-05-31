package problem_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

  String firstName = "John";
  String lastName = "Lee";
  Author author = new Author(firstName, lastName);
  RecordingArtist johnLennon = new RecordingArtist("John", "Lennon");
  RecordingArtist paulMcCartney = new RecordingArtist("Paul", "McCartney");
  RecordingArtist ringoStarr = new RecordingArtist("Ringo", "Starr");
  RecordingArtist artist = new RecordingArtist(firstName, lastName);
  int year = 1969;
  String bandName = "The Beatles";
  String title = "Abbey Road";
  ArrayList<RecordingArtist> recordingArtists = new ArrayList<RecordingArtist>(Arrays.asList(johnLennon,paulMcCartney,ringoStarr));
  ArrayList<RecordingArtist> recordingArtistsSingle = new ArrayList<RecordingArtist>(Arrays.asList(johnLennon));
  /**
   * Polymorphism come into play.
   */
  ILibrary music = new Music(bandName,recordingArtists,title,year);
  ILibrary musicCopy = new Music(bandName,recordingArtists,title,year);
  ILibrary book = new Book(author,title,year);
  ILibrary bookNon = new Book(author,title,2028);
  Catalog catalog;
  Catalog catalogCopy;
  Catalog catalogVary;
  ArrayList<ILibrary> initialCollection = new ArrayList<>(Arrays.asList(music,book));

  @Before
  public void setUp() throws Exception {
    catalog = new Catalog();
    catalog.addItem(music);
    catalog.addItem(book);
    catalogCopy = new Catalog(initialCollection);
    catalogVary = new Catalog();
    catalogVary.addItem(music);
  }

  @Test
  public void getItemCollection() {
    assertTrue(initialCollection.equals(catalogCopy.getItemCollection()));
    assertFalse(initialCollection.equals(catalogVary.getItemCollection()));
  }

  @Test
  public void contains() {
    assertTrue(catalog.contains(music));
    assertTrue(catalog.contains(book));
    assertFalse(catalogVary.contains(book));
  }

  @Test
  public void testContains() {
    assertTrue(catalog.contains(title));
    assertTrue(catalogVary.contains(title));
  }

  @Test
  public void addItem() {
    catalogVary.addItem(book);
    assertTrue(catalogVary.contains(book));
  }

  @Test
  public void removeItem() {
    assertTrue(catalog.removeItem(music));
    assertFalse(catalog.contains(music));
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeItemError() {
    catalog.removeItem(bookNon);
  }
  @Test
  public void updateItem() {
    Book booknNew = new Book(author,title,2021);
    assertTrue(catalog.updateItem(booknNew));
    assertEquals(2021,booknNew.getYear());
  }

  @Test
  public void search() {
    ArrayList<ILibrary> resultCollection = new ArrayList<>(Arrays.asList(music,book));
     assertTrue(resultCollection.equals(catalog.search("road")));
  }

  @Test
  public void testSearch() {
    ArrayList<ILibrary> resultCollection = new ArrayList<>(Arrays.asList(book));
    assertTrue(resultCollection.equals(catalog.search(author)));
  }

  @Test
  public void testSearch1() {
    ArrayList<ILibrary> resultCollection = new ArrayList<>(Arrays.asList(music));
    assertTrue(resultCollection.equals(catalog.search(johnLennon)));
  }

  @Test
  public void testEquals() {
    assertTrue(catalog.equals(catalog));
    assertTrue(catalog.equals(catalogCopy));
    assertFalse(catalog.equals(catalogVary));
    assertFalse(catalog.equals(null));
    assertFalse(catalog.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(catalog.hashCode() == catalogCopy.hashCode());
    assertFalse(catalog.hashCode() == catalogVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(catalog.toString().equals(catalogCopy.toString()));
    assertFalse(catalog.toString().equals(catalogVary.toString()));
  }
}