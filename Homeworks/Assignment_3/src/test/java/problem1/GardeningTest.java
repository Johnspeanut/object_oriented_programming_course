package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningTest {
  Gardening gardening;
  Gardening gardeningRed;
  Gardening gardeningBlue;
  String addressRed = "255 Terry Ave";
  String addressBlue = "2713 Peace RD";
  boolean serviceMonthlyRed = true;
  boolean serviceMonthlyBlue = false;
  enumOfSize sizeRed = enumOfSize.SMALL;
  enumOfSize sizeBlue = enumOfSize.LARGE;
  int numPreviousServiceRed = 8;
  int numPreviousServiceBlue = 9;

  @Before
  public void setUp() throws Exception {
    gardening = new Gardening(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed);
    gardeningRed = new Gardening(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed);
    gardeningBlue = new Gardening(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue);
    gardeningRed.getPrice();
    gardeningBlue.getPrice();
    gardening.getPrice();
  }

  @Test
  public void getHours() {
    assertEquals(1,gardeningRed.getHours());
    assertEquals(3,gardeningBlue.getHours());
  }

  @Test
  public void testEquals() {
    assertTrue(gardening.equals(gardeningRed));
    assertFalse(gardeningBlue.equals(gardeningRed));
  }

  @Test
  public void testHashCode() {
      assertEquals(gardening.hashCode(),gardeningRed.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(gardening.toString(),gardeningRed.toString());
  }

  @Test
  public void getPrice() {
    assertEquals(92.0,gardeningRed.getPrice(), 0.00001);
    assertEquals(140.0,gardeningBlue.getPrice(),0.00001);
  }

  @Test
  public void getWasteRemovalFee() {
    assertEquals(20,gardening.getWasteRemovalFee());
  }

}