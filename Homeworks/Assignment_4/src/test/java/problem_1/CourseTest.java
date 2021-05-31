package problem_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
  Course cs5004;
  Course cs5004Copy;
  Course cs5008;
  @Before
  public void setUp() throws Exception {
    cs5004 = new Course("CS5004","CCIS",5004);
    cs5004Copy = new Course("CS5004","CCIS",5004);
    cs5008 = new Course("CS5008","CCIS",5008);
  }
  @Test
  public void testToString() {
    assertTrue(cs5004.toString().equals(cs5004Copy.toString()));
    assertFalse(cs5004.toString().equals(cs5008.toString()));
  }

  @Test
  public void testEquals() {
    assertTrue(cs5004.equals(cs5004));
    assertFalse(cs5004.equals(cs5008));
    assertFalse(cs5008.equals(null));
    assertFalse(cs5008.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(cs5004.hashCode() == cs5004Copy.hashCode());
    assertFalse(cs5004.hashCode() == cs5008.hashCode());
  }
}