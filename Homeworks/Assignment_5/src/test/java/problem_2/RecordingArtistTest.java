package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
  RecordingArtist recordingArtist;
  RecordingArtist recordingArtistCopy;
  RecordingArtist recordingArtistVary;
  String firstName = "John";
  String lastName = "Lee";

  @Before
  public void setUp() throws Exception {
    recordingArtist = new RecordingArtist(firstName, lastName);
    recordingArtistVary = new RecordingArtist(firstName, "Xu");
    recordingArtistCopy = new RecordingArtist(firstName, lastName);
  }


  @Test
  public void testEquals() {
    assertTrue(recordingArtist.equals(recordingArtist));
    assertTrue(recordingArtist.equals(recordingArtistCopy));
    assertFalse(recordingArtist.equals(recordingArtistVary));
    assertFalse(recordingArtist.equals(null));
    assertFalse(recordingArtist.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(recordingArtist.hashCode() == recordingArtistCopy.hashCode());
    assertFalse(recordingArtist.hashCode() == recordingArtistVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(recordingArtist.toString().equals(recordingArtistCopy.toString()));
    assertFalse(recordingArtist.toString().equals(recordingArtistVary.toString()));
  }
}