package agent;

import static org.junit.Assert.*;

import agent.Residential;
import org.junit.Before;
import org.junit.Test;

public class ResidentialTest {
  Residential residential;
  Residential residentialCopy;
  Residential residentialVary;
  String address = "255 Terry Ave";
  Integer size = 6000;
  Integer numOfBedroom = 5;
  double numOfBathroom= 2.5;

  @Before
  public void setUp() throws Exception {
    residential = new Residential(address, size, numOfBedroom, numOfBathroom);
    residentialCopy = new Residential(address, size, numOfBedroom, numOfBathroom);
    residentialVary = new Residential(address, 8000, 3, 1.5);
  }

  @Test
  public void getAddress() {
    assertEquals(address, residential.getAddress());
  }

  @Test
  public void getSize() {
    assertEquals(size, residential.getSize());
  }

  @Test
  public void getNumOfBedroom() {
    assertEquals(numOfBedroom, residential.getNumOfBedroom());
  }

  @Test
  public void getNumOfBathroom() {
    assertEquals(numOfBathroom, residential.getNumOfBathroom(),0.00001);
  }

  @Test
  public void testEquals() {
    assertTrue(residential.equals(residentialCopy));
    assertFalse(residential.equals(residentialVary));
    assertFalse(residential.equals(residentialVary));
    assertFalse(residential.equals(null));
    assertFalse(residential.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(residential.hashCode() == residentialCopy.hashCode());
    assertFalse(residential.hashCode() == residentialVary.hashCode());
    assertFalse(residential.hashCode() == residentialVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(residential.toString().equals(residentialCopy.toString()));
    assertFalse(residential.toString().equals(residentialVary.toString()));
  }
}