package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PhotographersTest {
  Photographers John;
  Photographers John_copy;
  Photographers Amy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  ArrayList<String> exhibits = new ArrayList(Arrays.asList("Green Book","Birdman"));

  @Before
  public void setUp() throws Exception {
    John = new Photographers("John", 30,"actor",awards,exhibits);
    John_copy = new Photographers("John", 30,"actor",awards,exhibits);
    Amy = new Photographers("John", 50,"actor",awards,exhibits);
  }

  @Test
  public void testToString() {
    assertEquals(John_copy.toString(),John.toString());
  }
}