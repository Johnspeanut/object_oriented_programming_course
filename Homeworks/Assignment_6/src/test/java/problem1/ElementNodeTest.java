package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElementNodeTest {
  ElementNode node;
  ElementNode nodeCopy;
  ElementNode node2;
  EmptyNode emptyNode;

  @Before
  public void setUp() throws Exception {
    emptyNode = new EmptyNode();
    node = new ElementNode(3,"three",emptyNode);
    nodeCopy = new ElementNode(3,"three",emptyNode);
    node2 = new ElementNode(5,"five",emptyNode);
  }

  @Test
  public void count() {
    assertTrue(node.count().equals(1));
  }

  @Test
  public void getRest() {
    assertTrue( node.getRest() instanceof EmptyNode);
  }

  @Test
  public void setRest() {
    node.setRest(node2);
    assertEquals("five",node.getRest().getPriorityValue());
  }

  @Test
  public void getPriority() {
    assertTrue(node.getPriority().equals(3));
  }

  @Test
  public void getPriorityValue() {
    assertEquals("three",node.getPriorityValue());
  }

  @Test
  public void testEquals() {
    assertTrue(node.equals(node));
    assertTrue(node.equals(nodeCopy));
    assertFalse(node.equals(node2));
    assertFalse(node.equals(null));
    assertFalse(node.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(node.hashCode() == nodeCopy.hashCode());
    assertFalse(node.hashCode() == node2.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(node.toString().equals(nodeCopy.toString()));
    assertFalse(node.toString().equals(node2.toString()));
  }
}