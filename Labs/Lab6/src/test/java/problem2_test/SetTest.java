package problem2_test;

import static org.junit.Assert.*;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.Before;
import org.junit.Test;
import problem2_recursiveSet.ISet;
import problem2_recursiveSet.Set;

public class SetTest {
  Set set;

  @Before
  public void setUp() throws Exception {

    set = Set.emptySet();
  }

  @Test
  public void isEmpty() {
    assertTrue(set.isEmpty());
  }

  @Test
  public void add() {
    ISet newSet = set.add(20);
    assertFalse(newSet.isEmpty());
  }


  @Test
  public void contains() {
    ISet newSet = set.add(20);
    assertTrue(newSet.contains(20));
  }

  @Test
  public void remove() {
    ISet newSet = set.add(20);
    assertFalse(newSet.remove(20).contains(20));
  }

  @Test(expected = ValueException.class)
  public void remove2() {
    ISet newSet = set.add(20);
    newSet.remove(20).remove(20);
  }

  @Test
  public void size() {
    assertTrue(set.size().equals(0));
    ISet newSet = set.add(20);
    assertTrue(newSet.size().equals(1));
  }
}