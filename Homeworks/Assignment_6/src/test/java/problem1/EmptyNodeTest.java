package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyNodeTest {
  EmptyNode node;
  EmptyNode nodeCopy;
  EmptyNode node2;
  @Before
  public void setUp() throws Exception {
    node = new EmptyNode();
    nodeCopy = new EmptyNode();
  }

  @Test
  public void count() {
    assertTrue(node.count().equals(0));
  }

  @Test
  public void getPriorityValue() {
    assertEquals(null,node.getPriorityValue());
  }

  @Test
  public void getRest() {
    assertEquals(null,node.getRest());
  }


  @Test
  public void getPriority() {
    assertTrue(node.getPriority().equals(0));
  }
}