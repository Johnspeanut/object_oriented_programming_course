package problem_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem_2.Set;

public class CourseCatalogTest {
CourseCatalog courseCatalog;
  CourseCatalog courseCatalogEmpty;
  Course cs5004 = new Course("CS5004","CCIS",5004);
  Course cs5008 = new Course("CS5008","CCIS",5008);
  @Before
  public void setUp() throws Exception {
    courseCatalog = CourseCatalog.createEmpty();
  }

  @Test
  public void createEmpty() {
    courseCatalogEmpty = CourseCatalog.createEmpty();
    assertTrue(courseCatalog.getHead() == courseCatalogEmpty.getHead());
    assertTrue(courseCatalog.getNumNodes() == courseCatalogEmpty.getNumNodes());
  }

  @Test
  public void append() {
    courseCatalog.append(cs5008);
    assertTrue(courseCatalog.getHead().equals(new Node(cs5008,null)));
  }

  @Test
  public void remove() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    courseCatalog.append(new Course("CS5500","CCIS",5500));
    courseCatalog.append(new Course("CS5800","CCIS",5500));
    assertTrue(courseCatalog.contains(cs5008));
    courseCatalog.remove(cs5008);
    assertFalse(courseCatalog.contains(cs5008));
    assertTrue(courseCatalog.contains(cs5004));
    courseCatalog.remove(cs5004);
    assertFalse(courseCatalog.contains(cs5004));
  }

  @Test
  public void contains() {
    assertFalse(courseCatalog.contains(cs5004));
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    assertTrue(courseCatalog.contains(cs5004));
    courseCatalog.remove(cs5004);
    assertFalse(courseCatalog.contains(cs5004));
    assertTrue(courseCatalog.contains(cs5008));
  }

  @Test
  public void indexOf() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    assertEquals(0,courseCatalog.indexOf(cs5004));
    assertEquals(1,courseCatalog.indexOf(cs5008));
    assertEquals(-1,courseCatalog.indexOf(new Course("CS5500","CCIS",5004)));
  }

  @Test
  public void count() {
    courseCatalog.append(cs5004);
    assertEquals(1,courseCatalog.count());
    courseCatalog.append(cs5008);
    assertEquals(2,courseCatalog.count());
    courseCatalog.remove(cs5004);
    assertEquals(1,courseCatalog.count());
  }

  @Test
  public void get() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    assertTrue(cs5004.equals(courseCatalog.get(0)));
    assertTrue(cs5004.equals(courseCatalog.get(1)));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getException(){
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    courseCatalog.get(2);
  }

  @Test
  public void isEmpty() {
    assertTrue(courseCatalog.isEmpty());
    courseCatalog.append(cs5004);
    assertFalse(courseCatalog.isEmpty());
  }

  @Test
  public void testEquals() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    CourseCatalog courseCatalogCopy = CourseCatalog.createEmpty();
    courseCatalogCopy.append(cs5004);
    courseCatalogCopy.append(cs5008);
    CourseCatalog courseCatalogEmpty= CourseCatalog.createEmpty();
    assertTrue(courseCatalog.equals(courseCatalogCopy));
    assertFalse(courseCatalogCopy.equals(courseCatalogEmpty));
    assertFalse(courseCatalog.equals(null));
    assertFalse(courseCatalog.equals(""));
  }

  @Test
  public void testHashCode() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    CourseCatalog courseCatalogCopy = CourseCatalog.createEmpty();
    courseCatalogCopy.append(cs5004);
    courseCatalogCopy.append(cs5008);
    CourseCatalog courseCatalogEmpty= CourseCatalog.createEmpty();
    assertTrue(courseCatalog.hashCode() == courseCatalogCopy.hashCode());
    assertFalse(courseCatalogCopy.hashCode() == courseCatalogEmpty.hashCode());
  }

  @Test
  public void testToString() {
    courseCatalog.append(cs5004);
    courseCatalog.append(cs5008);
    CourseCatalog courseCatalogCopy = CourseCatalog.createEmpty();
    courseCatalogCopy.append(cs5004);
    courseCatalogCopy.append(cs5008);
    CourseCatalog courseCatalogEmpty= CourseCatalog.createEmpty();
    assertTrue(courseCatalog.toString().equals(courseCatalogCopy.toString()));
    assertFalse(courseCatalogCopy.toString().equals(courseCatalogEmpty.toString()));
  }
}