package agent;

import static org.junit.Assert.*;

import agent.Commercial;
import org.junit.Before;
import org.junit.Test;

public class CommercialTest {
  Commercial commercial;
  Commercial commercialCopy;
  Commercial commercialVary;
  String address = "255 Terry Ave";
  Integer size = 6000;
  Integer numOfOffice = 5;
  boolean isSuitableRetail = true;

  @Before
  public void setUp() throws Exception {
    commercial = new Commercial(address, size, numOfOffice, isSuitableRetail);
    commercialCopy = new Commercial(address, size, numOfOffice, isSuitableRetail);
    commercialVary = new Commercial(address, 8000, 10, isSuitableRetail);
  }

  @Test
  public void getAddress() {
    assertEquals(address, commercial.getAddress());
  }

  @Test
  public void getSize() {
    assertEquals(size, commercial.getSize());
  }

  @Test
  public void getNumOfOffice() {
    assertEquals(numOfOffice, commercial.getNumOfOffice());
  }

  @Test
  public void isSuitableRetail() {
    assertEquals(isSuitableRetail, commercial.isSuitableRetail());
  }

  @Test
  public void testEquals() {
    assertTrue(commercial.equals(commercialCopy));
    assertFalse(commercial.equals(commercialVary));
    assertFalse(commercial.equals(commercialVary));
    assertFalse(commercial.equals(null));
    assertFalse(commercial.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(commercial.hashCode() == commercialCopy.hashCode());
    assertFalse(commercial.hashCode() == commercialVary.hashCode());
    assertFalse(commercial.hashCode() == commercialVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(commercial.toString().equals(commercialCopy.toString()));
    assertFalse(commercial.toString().equals(commercialVary.toString()));
  }
}