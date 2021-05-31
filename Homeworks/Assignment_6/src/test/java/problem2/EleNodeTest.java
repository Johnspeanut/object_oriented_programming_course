package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EleNodeTest {
  IList node;
  IList nodeCopy;
  IList nodeVary;
  IList nodeEmpty;
  String value ="John";

  @Before
  public void setUp() throws Exception {
    node = new EleNode(value,new EmpNode());
    nodeCopy = new EleNode(value,new EmpNode());
    nodeVary = new EleNode("Tom",new EmpNode());
    nodeEmpty = new EmpNode();
  }

  @Test
  public void isEmpty() {
    assertTrue(nodeEmpty.isEmpty());
    assertFalse(node.isEmpty());
  }

  @Test
  public void contains() {
    assertTrue(node.contains(value));
  }

  @Test
  public void count() {
    assertTrue(node.count().equals(1));
  }

  @Test
  public void getRest() {
    assertTrue(node.getRest() instanceof EmpNode);
  }

  @Test
  public void getString() {
    assertTrue(value.equals(node.getString()));
  }

  @Test
  public void testEquals() {
    assertTrue(node.equals(node));
    assertTrue(node.equals(nodeCopy));
    assertFalse(node.equals(nodeVary));
    assertFalse(node.equals(null));
    assertFalse(node.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(node.hashCode() == nodeCopy.hashCode());
    assertFalse(node.hashCode() == nodeVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(node.toString().equals(nodeCopy.toString()));
    assertFalse(node.toString().equals(nodeVary.toString()));
    System.out.println(node);
    System.out.println(nodeCopy);
  }
}