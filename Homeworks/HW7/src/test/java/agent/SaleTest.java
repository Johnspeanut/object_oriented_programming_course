package agent;

import static org.junit.Assert.*;

import agent.Sale;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {
  Sale sale;
  Sale saleCopy;
  Sale saleVary;
  double askingPrice = 1000000;
  boolean isNegotiable = true;

  @Before
  public void setUp() throws Exception {
    sale = new Sale(askingPrice, isNegotiable);
    saleCopy = new Sale(askingPrice, isNegotiable);
    saleVary = new Sale(860000, isNegotiable);
  }

  @Test
  public void getAskingPrice() {
    assertEquals(askingPrice, sale.getAskingPrice(),0.00001);
  }

  @Test
  public void isNegotiable() {
    assertEquals(isNegotiable, sale.isNegotiable);
  }

  @Test
  public void getCommission(){
    assertEquals(10000,sale.getCommission(0.01),0.0001);
  }

  @Test
  public void testEquals() {
    assertTrue(sale.equals(saleCopy));
    assertFalse(sale.equals(saleVary));
    assertFalse(sale.equals(saleVary));
    assertFalse(sale.equals(null));
    assertFalse(sale.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(sale.hashCode() == saleCopy.hashCode());
    assertFalse(sale.hashCode() == saleVary.hashCode());
    assertFalse(sale.hashCode() == saleVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(sale.toString().equals(saleCopy.toString()));
    assertFalse(sale.toString().equals(saleVary.toString()));
  }
}