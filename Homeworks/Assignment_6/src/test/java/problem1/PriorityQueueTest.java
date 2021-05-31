package problem1;

import static org.junit.Assert.*;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
PriorityQueue pq;
  PriorityQueue pqCopy;
  @Before
  public void setUp() throws Exception {
    pq = PriorityQueue.createEmpty();
    pqCopy = pq.copyPQ();
  }

  @Test
  public void isEmpty() {
    assertTrue(pq.isEmpty());
  }

  @Test
  public void add() {
    pq.add(2,"two");
//    System.out.println(pq.);
  }

  @Test
  public void peak() {
    PriorityQueue pq1 = pq.add(10,"ten");
    PriorityQueue pq2 = pq1.add(8,"eight");
    PriorityQueue pq3 = pq2.add(4,"four");
assertEquals("ten",pq3.peak());
    PriorityQueue pq4 = pq3.add(10,"u");
    PriorityQueue pq5 = pq4.add(8,"a");
    pq5.printPQPriority();
//    System.out.println(pq5);
  }

  @Test(expected = ValueException.class)
  public void peakerror() {
pq.peak();

  }

  @Test
  public void pop() {
    PriorityQueue pq1 = pq.add(10,"ten");
    PriorityQueue pq2 = pq1.add(8,"eight");
    PriorityQueue pq3 = pq2.add(4,"four");
    PriorityQueue pq4 = pq3.add(10,"u");
    PriorityQueue pq5 = pq4.pop();
    pq3.printPQPriority();
    assertEquals("u",pq5.peak());
  }

  @Test
  public void testEquals() {
    PriorityQueue pq1 = pq.add(10,"ten");
    PriorityQueue pq1Copy = pq.add(10,"ten");
    PriorityQueue pq2 = pq1.add(8,"eight");
    assertTrue(pq1.equals(pq1));
    assertTrue(pq1.equals(pq1Copy));
    assertFalse(pq1.equals(pq2));
    assertFalse(pq1.equals(null));
    assertFalse(pq1.equals(""));
    System.out.println(pq1);
    System.out.println(pq1Copy);
  }

  @Test
  public void testHashCode() {
    PriorityQueue pq1 = pq.add(10,"ten");
    PriorityQueue pq1Copy = pq.add(10,"ten");
    PriorityQueue pq2 = pq1.add(8,"eight");
    assertTrue(pq1.hashCode() == pq1Copy.hashCode());
    assertFalse(pq1.hashCode() == pq2.hashCode());

  }

  @Test
  public void testToString() {
    PriorityQueue pq1 = pq.add(10,"ten");
    PriorityQueue pq1Copy = pq.add(10,"ten");
    PriorityQueue pq2 = pq1.add(8,"eight");
    assertTrue(pq1.toString().equals(pq1Copy.toString()));
    assertFalse(pq1.toString().equals(pq2.toString()));

//    System.out.println(pq);
//    System.out.println(pqCopy);
//    System.out.println(pq1);
  }
}