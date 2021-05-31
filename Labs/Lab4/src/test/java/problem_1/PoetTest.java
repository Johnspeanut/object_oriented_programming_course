package problem_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PoetTest {
  Poet John;
  Poet John_copy;
  Poet Amy;
  ArrayList<String> awards = new ArrayList(Arrays.asList("Oscar","Grammy"));
  String publishingCompany = "Harvard University Press";
  String lastPublishedCollection = "The Sea and Land";
  @Before
  public void setUp() throws Exception {
    John = new Poet("John", 30,"actor",awards,publishingCompany,lastPublishedCollection);
    John_copy = new Poet("John", 30,"actor",awards,publishingCompany,lastPublishedCollection);
    Amy = new Poet("John", 50,"actor",awards,publishingCompany,lastPublishedCollection);
  }

  @Test
  public void getPublishingCompany() {
    assertEquals(publishingCompany,John.getPublishingCompany());
  }

  @Test
  public void getLastPublishedCollection() {
    assertEquals(lastPublishedCollection,John.getLastPublishedCollection());
  }

  @Test
  public void testEquals() {
    assertTrue(John.equals(John));
    assertFalse(John.equals(Amy));
    assertFalse(John.equals(null));
    assertFalse(John.equals(""));
  }

  @Test
  public void testHashCode() {
    assertEquals(John_copy.hashCode(),John.hashCode());
    assertFalse(John_copy.hashCode() == Amy.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(John_copy.toString(),John.toString());
  }
}