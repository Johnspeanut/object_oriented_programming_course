package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  Painting painting;
  Painting paintingRed;
  Painting paintingBlue;
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
    painting = new Painting(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,numOfPetsRed);
    paintingRed = new Painting(addressRed,sizeRed,serviceMonthlyRed,numPreviousServiceRed,numOfPetsRed);
    paintingBlue = new Painting(addressBlue,sizeBlue,serviceMonthlyBlue,numPreviousServiceBlue,numOfPetsBlue);
    paintingRed.getPrice();
    paintingBlue.getPrice();
    painting.getPrice();
  }

  @Test
  public void getHours() {
    assertEquals(16,paintingRed.getHours());
    assertEquals(24,paintingBlue.getHours());
  }

  @Test
  public void getPrice() {
    assertEquals(1232.64,paintingRed.getPrice(), 0.00001);
    assertEquals(1008.0,paintingBlue.getPrice(),0.00001);
  }

  @Test
  public void testEquals() {
    assertTrue(painting.equals(paintingRed));
    assertFalse(paintingBlue.equals(paintingRed));
  }

  @Test
  public void testHashCode() {
    assertEquals(painting.hashCode(),paintingRed.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(painting.toString(),paintingRed.toString());
  }
}