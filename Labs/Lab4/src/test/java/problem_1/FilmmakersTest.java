package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class FilmmakersTest {
  Filmmakers John;
  Filmmakers John_copy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  ArrayList<String> movies = new ArrayList(Arrays.asList("Green Book","Birdman"));
  ArrayList<String> series = new ArrayList(Arrays.asList("Breaking Bad","Big Bang Theory"));
  ArrayList<String> otherMultimedia = new ArrayList(Arrays.asList("NYT","Washington Post"));
  @Before
  public void setUp() throws Exception {
    John = new Filmmakers("John", 30,"actor",awards,movies,series,otherMultimedia );
    John_copy = new Filmmakers("John", 30,"actor",awards,movies,series,otherMultimedia );
  }
  @Test
  public void testToString() {
    assertEquals(John_copy.toString(),John.toString());
  }
}