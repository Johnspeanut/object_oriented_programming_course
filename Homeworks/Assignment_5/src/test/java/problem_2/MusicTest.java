package problem_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  Music music;
  Music musicCopy;
  Music musicVary;
  String firstName = "John";
  String lastName = "Lee";
  Author author = new Author(firstName, lastName);
  RecordingArtist johnLennon = new RecordingArtist("John", "Lennon");
  RecordingArtist paulMcCartney = new RecordingArtist("Paul", "McCartney");
  RecordingArtist ringoStarr = new RecordingArtist("Ringo", "Starr");
  int year = 1969;
  String bandName = "The Beatles";
  String title = "Abbey Road";
  ArrayList<RecordingArtist> recordingArtists = new ArrayList<RecordingArtist>(Arrays.asList(johnLennon,paulMcCartney,ringoStarr));
  ArrayList<RecordingArtist> recordingArtistsSingle = new ArrayList<RecordingArtist>(Arrays.asList(johnLennon));
  @Before
  public void setUp() throws Exception {
    music = new Music(bandName,recordingArtists,title,year);
    musicCopy = new Music(bandName,recordingArtists,title,year);
    musicVary = new Music(recordingArtistsSingle,title,1998);
  }
  @Test
  public void getBandName() {
    assertEquals(bandName,music.getBandName());
  }

  @Test
  public void getRecordingArtists() {
    assertTrue(recordingArtists.equals(music.getRecordingArtists()));
    assertTrue(recordingArtistsSingle.equals(musicVary.getRecordingArtists()));
  }

  @Test
  public void getYear() {
    assertEquals(year,music.getYear());
  }

  @Test
  public void search() {
    assertTrue(music.search("Road"));
    assertTrue(music.search("road"));
    assertFalse(music.search("Dog"));
  }

  @Test
  public void testSearch() {
    assertTrue(music.search(johnLennon));
    assertTrue(music.search(ringoStarr));
  }

  @Test
  public void testSearch1() {
    assertFalse(music.search(author));
  }

  @Test
  public void getTitle() {
    assertTrue(title.equals(music.getTitle()));
  }

  @Test
  public void testEquals() {
    assertTrue(music.equals(music));
    assertTrue(music.equals(musicCopy));
    assertFalse(music.equals(musicVary));
    assertFalse(music.equals(null));
    assertFalse(music.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(music.hashCode() == musicCopy.hashCode());
    assertFalse(music.hashCode() == musicVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(music.toString().equals(musicCopy.toString()));
    assertFalse(music.toString().equals(musicVary.toString()));
  }
}