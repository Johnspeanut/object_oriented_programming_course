package problem_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
  Course cs5004 = new Course("CS5004","CCIS",5004);
  Course cs5008 = new Course("CS5008","CCIS",5008);
  Node node1;
  Node node1Copy;
  Node node2;
@Before
  public void setUp() throws Exception {
    node1 = new Node(cs5004,null);
    node1Copy = new Node(cs5004,null);

  }
  @Test
  public void testGetCourse() {
    assertEquals(cs5004,node1.getCourse());
  }
  @Test
  public void testGetNextNode() {
    assertEquals(null,node1.getNextNode());
    node2 = new Node(cs5008,node1);
    assertEquals(node1,node2.getNextNode());
  }


  @Test
  public void setNextNode() {
    node2 = new Node(cs5008,null);
    node2.setNextNode(node1);
    assertEquals(node1,node2.getNextNode());
  }

  @Test
  public void testEquals() {
    node2 = new Node(cs5008,null);
    assertTrue(node1.equals(node1));
    assertFalse(node1.equals(node2));
    assertFalse(node1.equals(null));
    assertFalse(node1.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(node1Copy.hashCode() == node1.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(node1Copy.toString().equals(node1.toString()));
    node2 = new Node(cs5008,null);
    assertFalse(node2.toString().equals(node1.toString()));
  }
}