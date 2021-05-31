package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PaintersTest {
  Painters John;
  Painters John_copy;
  Painters Amy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  ArrayList<String> exhibits = new ArrayList(Arrays.asList("Green Book","Birdman"));

  @Before
  public void setUp() throws Exception {
    John = new Painters("John", 30,"actor",awards,exhibits);
    John_copy = new Painters("John", 30,"actor",awards,exhibits);
    Amy = new Painters("John", 50,"actor",awards,exhibits);
  }

  @Test
  public void getExhibits() {
    assertEquals(exhibits,John.getExhibits());

  }

  @Test
  public void addExhibits() {
    John.addExhibits("Parasites");
    ArrayList<String> exhibitsUpdate = new ArrayList(Arrays.asList("Green Book","Birdman","Parasites"));
    assertEquals(exhibitsUpdate,John.getExhibits());
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
}