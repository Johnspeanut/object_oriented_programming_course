package equality_in_java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTest {
  private Integer x = 5;
  private Integer y = 10;
  private Posn posn;

  @Before
  public void setUp() throws Exception {
    posn = new Posn(x,y);
  }

  @Test
  public void getX() {
    assertEquals(x,posn.getX());
  }

  @Test
  public void getY() {
    assertEquals(y,posn.getY());
  }

  @Test
  public void testEqualsSameObject() {
    assertEquals(true,posn.equals(posn));
  }

  @Test
  public void testEqualsSameValue() {
    Posn posnNew = new Posn(x,y);
    assertEquals(true,posnNew.equals(posn));
  }

  @Test
  public void testHashCode() {
    Posn posnNew = new Posn(x,y);
    assertEquals(posnNew.hashCode(),posn.hashCode());
  }

  @Test
  public void testToString() {
    Posn posnNew = new Posn(x,y);
    assertEquals(posn.toString(),posnNew.toString());
  }
}