package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingTest {
  Plumbing plumbing;
  Plumbing plumbingRed;
  Plumbing plumbingBlue;
  String addressRed = "255 Terry Ave";
  String addressBlue = "2713 Peace RD";
  boolean serviceMonthlyRed = true;
  boolean serviceMonthlyBlue = false;
  enumOfSize sizeRed = enumOfSize.SMALL;
  enumOfSize sizeBlue = enumOfSize.LARGE;
  int numPreviousServiceRed = 8;
  int numPreviousServiceBlue = 9;
  int licenseRequiredRed = 4;
  int licenseRequiredBlue = 0;
  boolean complexRed = true;
  boolean complexBlue = false;

  @Before
  public void setUp() throws Exception {
    plumbing = new Plumbing(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,licenseRequiredRed,complexRed);
    plumbingRed = new Plumbing(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,licenseRequiredRed,complexRed);
    plumbingBlue = new Plumbing(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue,licenseRequiredBlue,complexBlue);
    plumbingRed.getPrice();
    plumbingBlue.getPrice();
    plumbing.getPrice();
  }

  @Test
  public void getExtraPermittingFee() {
    assertEquals(20,plumbingRed.getExtraPermittingFee());
  }

  @Test
  public void getPrice() {
    assertEquals(420.0,plumbingRed.getPrice(), 0.00001);
    assertEquals(220.0,plumbingBlue.getPrice(),0.00001);
  }

  @Test
  public void testEquals() {
    assertTrue(plumbing.equals(plumbingRed));
    assertFalse(plumbingBlue.equals(plumbingRed));
  }

  @Test
  public void testHashCode() {
    assertEquals(plumbing.hashCode(),plumbingRed.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(plumbing.toString(),plumbingRed.toString());
  }
}