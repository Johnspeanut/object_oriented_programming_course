package problem_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
LinkedList list;
LinkedList listCopy;
LinkedList listRachel;
  @Before
  public void setUp() throws Exception {
    list = LinkedList.createEmpty();
    listCopy = LinkedList.createEmpty();
    listRachel = LinkedList.createEmpty();
  }

  @Test
  public void createEmpty() {
    LinkedList listEason = LinkedList.createEmpty();
    assertTrue(listEason.isEmpty());
  }

  @Test
  public void addNode() {
    list.addNode("Amy");
    assertEquals(1,list.size());
    list.addNode("Jackie");
    assertEquals(2,list.size());
  }

  @Test
  public void isEmpty() {
    assertTrue(list.isEmpty());
    list.addNode("Amy");
    assertFalse(list.isEmpty());
  }

  @Test
  public void size() {
    list.addNode("Amy");
    assertEquals(1,list.size());
    list.addNode("Jackie");
    assertEquals(2,list.size());
    list.addNode("Steven");
    assertEquals(3,list.size());
  }

  @Test
  public void contains() {
    list.addNode("Amy");
    list.addNode("Jackie");
    list.addNode("Steven");
    assertTrue(list.contains("Amy"));
    assertFalse(list.contains("Chen"));
  }

  @Test
  public void containsAll() {
    list.addNode("Amy");
    list.addNode("Jackie");
    list.addNode("Steven");
    listRachel.addNode("Jackie");
    listRachel.addNode("Steven");
    assertTrue(list.containsAll(listRachel));
    assertFalse(listRachel.containsAll(list));
  }

  @Test
  public void filterLargerThan() {
    list.addNode("Amy");
    list.addNode("Jackie");
    list.addNode("Steven");
    list.addNode("Steven Bush");
    assertEquals(3,list.filterLargerThan(7).size());
    assertEquals(1,list.filterLargerThan(4).size());
  }

  @Test
  public void hasDuplicates() {
    list.addNode("Amy");
    list.addNode("Jackie");
    list.addNode("Steven");
    list.addNode("Steven Bush");
    assertFalse(list.hasDuplicates());
    list.addNode("Amy");
    assertTrue(list.hasDuplicates());
  }

  @Test
  public void removeDuplicates() {
    list.addNode("Amy");
    list.addNode("Jackie");
    list.addNode("Steven");
    list.addNode("Steven Bush");
    list.addNode("Amy");
    assertEquals(4,list.removeDuplicates().size());
  }
}