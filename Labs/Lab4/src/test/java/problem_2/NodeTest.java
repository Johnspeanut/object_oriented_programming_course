package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
Node node;
Node nodeCopy;
Node nodeRachel;
  @Before
  public void setUp() throws Exception {
    node = new Node("happy",null);
    nodeCopy = new Node("happy",null);
    nodeRachel = new Node("Year",null);
  }

  @Test
  public void getItem() {
    assertEquals("happy",node.getItem());
  }

  @Test
  public void getNextNode() {
    assertEquals(null,node.getNextNode());
  }

  @Test
  public void setNextNode() {
    Node newNode = new Node("New",null);
    node.setNextNode(newNode);
    assertEquals(newNode,node.getNextNode());
  }

  @Test
  public void testEquals() {
    assertTrue(node.equals(nodeCopy));
    assertFalse(node.equals(nodeRachel));
    assertFalse(node.equals(null));
    assertFalse(node.equals(""));
  }

  @Test
  public void testHashCode() {
    assertEquals(node.hashCode(),nodeCopy.hashCode());
    assertFalse(nodeCopy.hashCode() == nodeRachel.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(node.toString(),nodeCopy.toString());
  }
}