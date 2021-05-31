package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FruitTest {
  Fruit apple;
  Fruit appleCopy;
  String appleName = "Apple";
  double applePrice = 20.0;
  int appleQuantity = 1000;
  int appleOrderDate = 15;
  int appleExpirationDate = 5;

  @Before
  public void setUp() throws Exception {
    apple= new Fruit(appleName,applePrice,appleQuantity,appleOrderDate,appleExpirationDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructor() throws IllegalArgumentException{
    appleCopy= new Fruit(appleName,applePrice,-3,appleOrderDate,appleExpirationDate);
  }
}