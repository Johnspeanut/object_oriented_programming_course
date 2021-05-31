package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class ActorsTest {
  Actors John;
  Actors John_copy;
  Actors Amy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  ArrayList<String> movies = new ArrayList(Arrays.asList("Green Book","Birdman"));
  ArrayList<String> series = new ArrayList(Arrays.asList("Breaking Bad","Big Bang Theory"));
  ArrayList<String> otherMultimedia = new ArrayList(Arrays.asList("NYT","Washington Post"));
  @Before
  public void setUp() throws Exception {
    John = new Actors("John", 30,"actor",awards,movies,series,otherMultimedia );
    John_copy = new Actors("John", 30,"actor",awards,movies,series,otherMultimedia );
    Amy = new Actors("John", 50,"actor",awards,movies,series,otherMultimedia );
  }

  @Test
  public void addMovies() {
    John.addMovies("Parasites");
    ArrayList<String> moviesUpdate = new ArrayList(Arrays.asList("Green Book","Birdman","Parasites"));
    assertEquals(moviesUpdate,John.getMovies());
  }

  @Test
  public void addSeries() {
    John.addSeries("Parasites");
    ArrayList<String> seriesUpdate = new ArrayList(Arrays.asList("Breaking Bad","Big Bang Theory","Parasites"));
    assertEquals(seriesUpdate,John.getSeries());
  }

  @Test
  public void addOtherMultimedia() {
    John.addOtherMultimedia("Parasites");
    ArrayList<String> otherMultimediaUpdate = new ArrayList(Arrays.asList("NYT","Washington Post","Parasites"));
    assertEquals(otherMultimediaUpdate,John.getOtherMultimedia());
  }

  @Test
  public void getMovies() {
    assertEquals(movies, John.getMovies());
  }

  @Test
  public void getSeries() {
    assertEquals(series, John.getSeries());
  }

  @Test
  public void getOtherMultimedia() {
    assertEquals(otherMultimedia, John.getOtherMultimedia());
  }

  @Test
  public void testEquals() {
    assertTrue(John.equals(John));
    assertFalse(John.equals(Amy));
    assertFalse(John.equals(null));
    assertFalse(John.equals(""));
  }

  @Test
  public void testHashCode() {
    assertEquals(John_copy.hashCode(),John.hashCode());
    assertFalse(John_copy.hashCode() == Amy.hashCode());
  }

  @Test
  public void getName() {
    assertEquals("John",John.getName());
  }

  @Test
  public void getAge() {
    assertEquals(30,John.getAge());
  }

  @Test
  public void getGenres() {
    assertEquals("actor",John.getGenres());
  }

  @Test
  public void getAwards() {
    assertEquals(awards,John.getAwards());
  }

  @Test
  public void receiveAward() {
    John.receiveAward("Golden Bear");
    ArrayList<String> awardUpdate = new ArrayList(Arrays.asList("Oscar","Grammy","Golden Bear"));
    assertEquals(awardUpdate,John.getAwards());
  }

  @Test
  public void testToString() {
    assertEquals(John_copy.toString(),John.toString());
  }
}