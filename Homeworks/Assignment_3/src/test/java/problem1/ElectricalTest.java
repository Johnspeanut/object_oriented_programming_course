package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalTest {
  Electrical electrical;
  Electrical electricalRed;
  Electrical electricalBlue;
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
    electrical = new Electrical(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,licenseRequiredRed,complexRed);
    electricalRed = new Electrical(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,licenseRequiredRed,complexRed);
    electricalBlue = new Electrical(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue,licenseRequiredBlue,complexBlue);
    electricalRed.getPrice();
    electricalBlue.getPrice();
    electrical.getPrice();
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor() throws IllegalArgumentException{
    Electrical electricaInvalid = new Electrical(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,-1,complexRed);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor2() throws IllegalArgumentException{
    Electrical electricaInvalid2 = new Electrical(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,5,complexRed);
  }

  @Test
  public void getBASERATE() {
    assertEquals(200,electrical.getBASERATE());
  }

  @Test
  public void getNumLicensedEmployeeRequired() {
    assertEquals(2,electricalRed.getNumLicensedEmployeeRequired());
    assertEquals(1,electricalBlue.getNumLicensedEmployeeRequired());
  }

  @Test
  public void isComplex() {
    assertTrue(electricalRed.isComplex());
    assertFalse(electricalBlue.isComplex());
  }

  @Test
  public void testEquals() {
    assertTrue(electrical.equals(electricalRed));
    assertFalse(electricalBlue.equals(electricalRed));
  }

  @Test
  public void testHashCode() {
    assertEquals(electrical.hashCode(),electricalRed.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(electrical.toString(),electricalRed.toString());
  }

  @Test
  public void getMaxLicensed() {
    assertEquals(4,electrical.getMaxLicensed());
  }

  @Test
  public void getExtraPermittingFee() {
    assertEquals(50,electricalRed.getExtraPermittingFee());
  }

  @Test
  public void getPrice() {
    assertEquals(450.0,electricalRed.getPrice(), 0.00001);
    assertEquals(250.0,electricalBlue.getPrice(),0.00001);
  }
}