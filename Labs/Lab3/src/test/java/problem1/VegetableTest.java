package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VegetableTest {

  Vegetable choi;
  Vegetable choiCopy;
  String choiName = "Choi";
  double choiPrice = 20.0;
  int choiQuantity = 1000;
  int choiOrderDate = 15;
  int choiExpirationDate = 5;

  @Before
  public void setUp() throws Exception {
    choi = new Vegetable(choiName,choiPrice,choiQuantity,choiOrderDate,choiExpirationDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructor() throws IllegalArgumentException{
    choiCopy = new Vegetable(choiName,0,-3,choiOrderDate,choiExpirationDate);
  }
}