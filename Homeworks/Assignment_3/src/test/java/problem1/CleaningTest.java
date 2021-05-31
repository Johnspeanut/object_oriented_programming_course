package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningTest {
    Cleaning cleaning;
    Cleaning cleaningRed;
    Cleaning cleaningBlue;
    String addressRed = "255 Terry Ave";
    String addressBlue = "2713 Peace RD";
    boolean serviceMonthlyRed = true;
    boolean serviceMonthlyBlue = false;
    enumOfSize sizeRed = enumOfSize.SMALL;
    enumOfSize sizeBlue = enumOfSize.LARGE;
    int numPreviousServiceRed = 8;
    int numPreviousServiceBlue = 9;
    int numOfPetsRed = 3;
    int numOfPetsBlue = 1;

    @Before
    public void setUp() throws Exception {
      cleaning = new Cleaning(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,numOfPetsRed);
      cleaningRed = new Cleaning(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,numOfPetsRed);
      cleaningBlue = new Cleaning(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue,numOfPetsBlue);
      cleaningRed.getPrice();
      cleaningBlue.getPrice();
      cleaning.getPrice();
    }

    @Test
    public void getNumOfPets() {
      assertEquals(numOfPetsRed,cleaningRed.getNumOfPets());
    }

  @Test
  public void interiorExtraPercentFee() {
      assertEquals(0.07,cleaningRed.getExtraInteriorFee(),0.0000001);
    assertEquals(0.05,cleaningBlue.getExtraInteriorFee(),0.0000001);
  }

  @Test
  public void getBASERATE() {
      assertEquals(80,cleaningRed.getBASERATE());
  }
  @Test
  public void isIs10thService() {
      assertTrue(cleaningBlue.isIs10thService());
    assertFalse(cleaningRed.isIs10thService());
  }

  @Test
  public void applyDiscountRate() {
    assertEquals(0.5,cleaningBlue.getDiscountPercent(),0.0000001);
    assertEquals(0.1,cleaningRed.getDiscountPercent(),0.0000001);
  }

  @Test
  public void getAddress() {
      assertEquals(addressRed,cleaningRed.getAddress());
  }

  @Test
  public void getSize() {
      assertEquals(sizeRed, cleaningRed.getSize());
  }

  @Test
  public void isServiceMonthly() {
      assertTrue(cleaningRed.isServiceMonthly());
      assertFalse(cleaningBlue.isServiceMonthly());
  }

  @Test
  public void getNumPreviousServices() {
      assertEquals(numPreviousServiceRed,cleaningRed.getNumPreviousServices());
      assertEquals(numPreviousServiceBlue,cleaningBlue.getNumPreviousServices());
  }

  @Test
  public void getHours() {
assertEquals(1,cleaningRed.getHours());
    assertEquals(3,cleaningBlue.getHours());
  }

  @Test
  public void getPrice() {
      assertEquals(77.04,cleaningRed.getPrice(), 0.00001);
    assertEquals(126.0,cleaningBlue.getPrice(),0.00001);
  }

  @Test
  public void testEquals() {
    assertTrue(cleaning.equals(cleaningRed));
    assertFalse(cleaningBlue.equals(cleaningRed));
  }

  @Test
  public void testHashCode() {
      assertEquals(cleaning.hashCode(),cleaningRed.hashCode());
  }

  @Test
  public void testToString() {
      assertEquals(cleaning.toString(),cleaningRed.toString());
  }
}