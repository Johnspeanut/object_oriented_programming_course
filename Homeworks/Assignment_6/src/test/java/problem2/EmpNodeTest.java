package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.EmptyNode;

public class EmpNodeTest {
  EmpNode node;
  EmpNode nodeCopy;
  EmpNode node2;

  @Before
  public void setUp() throws Exception {
    node = new EmpNode();
    nodeCopy = new EmpNode();
  }

  @Test
  public void count() {
    assertTrue(node.count().equals(0));
  }

  @Test
  public void getRest() {
    assertEquals(null,node.getRest());
  }

  @Test
  public void getString() {
    assertEquals(null,node.getString());
  }

  @Test
  public void contains() {
    assertFalse(node.contains("String"));
  }

  @Test
  public void isEmpty() {
    assertTrue(node.isEmpty());
  }
}