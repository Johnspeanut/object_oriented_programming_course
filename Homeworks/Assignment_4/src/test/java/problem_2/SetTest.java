package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem_1.Node;

public class SetTest {
  Set set;
  @Before
  public void setUp() throws Exception {
    set = new Set();
  }

  @Test
  public void emptySet() {
    set.emptySet();
    assertEquals(0,set.numItems);
  }

  @Test
  public void isEmpty() {
    assertTrue(set.isEmpty());
    set.add(2);
    assertFalse(set.isEmpty());
  }

  @Test
  public void add() {
    set.add(2);
    set.add(2);
    assertEquals(1,set.numItems);
    set.add(3);
    assertEquals(2,set.numItems);
    set.add(21);
    set.add(22);
    set.add(23);
    set.add(24);
    set.add(25);
    set.add(26);
    set.add(27);
    set.add(28);
    set.add(29);
    set.add(30);
    set.add(31);
    set.add(32);
    set.add(33);
    set.add(34);
    set.add(35);
    set.add(36);
    set.add(37);
    set.add(38);
  }

  @Test
  public void contains() {
    set.add(2);
    set.add(3);
    assertTrue(set.contains(2));
    assertFalse(set.contains(0));
  }

  @Test
  public void remove() {
    set.add(2);
    set.add(3);
    set.add(0);
    assertTrue(set.contains(2));
    Set setNew = set.remove(2);
    assertFalse(setNew.contains(2));
  }

  @Test
  public void size() {
    set.add(2);
    set.add(3);
    set.add(0);
    assertTrue(set.size().equals(3));
  }

  @Test
  public void testEquals() {
    set.add(2);
    set.add(3);
    set.add(0);
    Set set2 = new Set();
    set2.add(2);
    set2.add(3);
    set2.add(0);
    Set setEmpty = new Set();

    assertTrue(set.equals(set2));
    assertFalse(set.equals(setEmpty));
    assertFalse(set.equals(null));
    assertFalse(set.equals(""));
  }

  @Test
  public void testHashCode() {
    set.add(2);
    set.add(3);
    set.add(0);
    Set set2 = new Set();
    set2.add(2);
    set2.add(3);
    set2.add(0);
    Set setEmpty = new Set();
    assertTrue(set.hashCode() == set2.hashCode());
    assertFalse(set.hashCode() == setEmpty.hashCode());
  }

  @Test
  public void testToString() {
    set.add(2);
    set.add(3);
    set.add(0);
    Set set2 = new Set();
    set2.add(2);
    set2.add(3);
    set2.add(0);
    Set set3 = new Set();
    set3.add(2);
    set3.add(3);
    assertTrue(set.toString().equals(set2.toString()));
    assertFalse(set.toString().equals(set3.toString()));
  }
}