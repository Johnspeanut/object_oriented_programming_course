package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PastaTest {
  Pasta chepolli;
  Pasta chepolliCopy;
  String chepolliName = "Apple";
  double chepolliPrice = 20.0;
  int chepolliQuantity = 1000;

  @Before
  public void setUp() throws Exception {
    chepolli= new Pasta(chepolliName,chepolliPrice,chepolliQuantity);
  }
  @Test(expected = IllegalArgumentException.class)
  public void getOrderDate() throws IllegalArgumentException{
    chepolliCopy= new Pasta(chepolliName,0,chepolliQuantity);
  }
}