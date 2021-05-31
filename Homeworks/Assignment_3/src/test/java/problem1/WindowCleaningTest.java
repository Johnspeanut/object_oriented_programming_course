package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {
  WindowCleaning windowCleaning;
  WindowCleaning windowCleaningRed;
  WindowCleaning windowCleaningBlue;
  String addressRed = "255 Terry Ave";
  String addressBlue = "2713 Peace RD";
  boolean serviceMonthlyRed = true;
  boolean serviceMonthlyBlue = false;
  enumOfSize sizeRed = enumOfSize.SMALL;
  enumOfSize sizeBlue = enumOfSize.LARGE;
  int numPreviousServiceRed = 8;
  int numPreviousServiceBlue = 9;
  int floorRed = 2;
  int floorBlue = 1;

  @Before
  public void setUp() throws Exception {
    windowCleaning = new WindowCleaning(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,floorRed);
    windowCleaningRed = new WindowCleaning(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,floorRed);
    windowCleaningBlue = new WindowCleaning(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue,floorBlue);
    windowCleaningRed.getPrice();
    windowCleaningBlue.getPrice();
    windowCleaning.getPrice();
  }

  @Test
  public void getWindowCleaningExtraFeeRate() {
    assertEquals(0.05,windowCleaningRed.getWindowCleaningExtraFeeRate(),0.0001);
    assertEquals(0.0,windowCleaningBlue.getWindowCleaningExtraFeeRate(),0.0001);
  }

  @Test
  public void getFloor() {
    assertEquals(2,windowCleaningRed.getFloor());
    assertEquals(1,windowCleaningBlue.getFloor());
  }

  @Test
  public void getPrice() {
    assertEquals(75.6,windowCleaningRed.getPrice(), 0.00001);
    assertEquals(120.0,windowCleaningBlue.getPrice(),0.00001);
  }
}