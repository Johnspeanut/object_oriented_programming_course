package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class MusicianTest {
  Musician John;
  Musician John_copy;
  Musician Amy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  String recordingCompany = "CBS";
  String lastRecordAlbum = "The Blues";

  @Before
  public void setUp() throws Exception {
    John = new Musician("John", 30,"actor",awards,recordingCompany,lastRecordAlbum);
    John_copy = new Musician("John", 30,"actor",awards,recordingCompany,lastRecordAlbum);
    Amy = new Musician("John", 50,"actor",awards,recordingCompany,lastRecordAlbum);
  }

  @Test
  public void getRecordingCompany() {
    assertEquals(recordingCompany,John.getRecordingCompany());
  }

  @Test
  public void getLastRecordAlbum() {
    assertEquals(lastRecordAlbum,John.getLastRecordAlbum());
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
  public void testToString() {
    assertEquals(John_copy.toString(),John.toString());
  }
}