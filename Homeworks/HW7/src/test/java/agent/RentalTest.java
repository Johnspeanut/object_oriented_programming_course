package agent;

import static org.junit.Assert.*;

import agent.Rental;
import org.junit.Before;
import org.junit.Test;

public class RentalTest {
  Rental rental;
  Rental rentalCopy;
  Rental rentalVary;
  double askingPrice = 1000000;
  boolean isNegotiable = true;
  Integer termInMonths = 10;

  @Before
  public void setUp() throws Exception {
    rental = new Rental(askingPrice, isNegotiable, termInMonths);
    rentalCopy = new Rental(askingPrice, isNegotiable, termInMonths);
    rentalVary = new Rental(860000, isNegotiable, 5);
  }

  @Test
  public void getAskingPrice() {
    assertEquals(askingPrice, rental.getAskingPrice(),0.00001);
  }

  @Test
  public void isNegotiable() {
    assertEquals(isNegotiable, rental.isNegotiable);
  }

  @Test
  public void getTermInMonths() {
    assertEquals(termInMonths, rental.getTermInMonths());
  }

  @Test
  public void getCommission(){
    assertEquals(100000,rental.getCommission(0.01),0.0001);
  }

  @Test
  public void testEquals() {
    assertTrue(rental.equals(rentalCopy));
    assertFalse(rental.equals(rentalVary));
    assertFalse(rental.equals(rentalVary));
    assertFalse(rental.equals(null));
    assertFalse(rental.equals(""));

  }

  @Test
  public void testHashCode() {
    assertTrue(rental.hashCode() == rentalCopy.hashCode());
    assertFalse(rental.hashCode() == rentalVary.hashCode());
    assertFalse(rental.hashCode() == rentalVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(rental.toString().equals(rentalCopy.toString()));
    assertFalse(rental.toString().equals(rentalVary.toString()));
  }
}