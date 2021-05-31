package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MeatTest {
  Meat meatPork;
  Meat meatPorkCopy;
  Meat meatBeef;
  String meatPorkName = "Pork";
  String meatBeefName = "Beef";
  double meatPorkPrice = 10.0;
  double meatBeefPrice = 20.0;
  int porkAvailQuantity = 100;
  int beefAvailQuantity = 1000;
  int porkOrderDate = 20;
  int beefOrderDate = 15;
  int porkExpirationDate = 5;
  int beefExpirationDate = 5;
  @Before
  public void setUp() throws Exception {
    meatPork = new Meat(meatPorkName,meatPorkPrice,porkAvailQuantity,porkOrderDate,porkExpirationDate);
    meatPorkCopy = new Meat(meatPorkName,meatPorkPrice,porkAvailQuantity,porkOrderDate,porkExpirationDate);
    meatBeef = new Meat(meatBeefName,meatBeefPrice,beefAvailQuantity,beefOrderDate,beefExpirationDate);
  }

  @Test
  public void getMaxAllowedQuantity() {
    assertEquals(100,meatPork.getMaxAllowedQuantity());
  }

  @Test
  public void getOrderDate() {
    assertEquals(porkOrderDate,meatPork.getOrderDate());
  }

  @Test
  public void getExpirationData() {
    assertEquals(beefExpirationDate,meatBeef.getExpirationData());
  }

  @Test
  public void makeOrder() {
    assertFalse(meatPork.makeOrder(500));
    assertTrue(meatBeef.makeOrder(80));
  }
  @Test(expected = IllegalArgumentException.class)
  public void invalidMakeOrder() throws IllegalArgumentException{
    meatPork = new Meat(meatPorkName,meatPorkPrice,-1,porkOrderDate,porkExpirationDate);
  }

  @Test
  public void testEquals() {
    assertTrue(meatPorkCopy.equals(meatPork));
  }

  @Test
  public void testHashCode() {
    assertFalse(meatPork.hashCode() == meatBeef.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(meatPork.toString(),meatPorkCopy.toString());
  }

  @Test
  public void getCompanyIncome() {
    meatBeef.makeOrder(80);
    assertEquals(4800.0,FoodItem.getCompanyIncome(),0.00001);
  }

  @Test
  public void getName() {
    assertEquals(meatPorkName,meatPork.getName());
  }

  @Test
  public void getCurrentPricePerUnit() {
    assertEquals(meatPorkPrice,meatPork.getCurrentPricePerUnit(),0.00001);
  }

  @Test
  public void getCurrentAvailableQuantity() {
    meatBeef.makeOrder(80);
    assertEquals(920,meatBeef.getCurrentAvailableQuantity());
  }

  @Test
  public void getIncomeKindsFood() {
    meatBeef.makeOrder(80);
    assertEquals(1600.0,meatBeef.getIncomeKindsFood(),0.0001);
  }
}