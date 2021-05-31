package agent;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class ListingTest {
  String name = "Amy Lee";
  double commissionRate = 0.05;


  String address = "255 Terry Ave";
  Integer size = 6000;
  Integer numOfBedroom = 5;
  double numOfBathroom= 2.5;
  Residential residential = new Residential(address, size, numOfBedroom, numOfBathroom);

  double askingPrice = 1000000;
  Integer termInMonths = 10;
  Rental rental = new Rental(askingPrice, true, termInMonths);

  Integer numOfOffice = 5;
  Commercial commercial = new Commercial(address, size, numOfOffice, true);

  boolean isNegotiable = true;
  Sale sale = new Sale(askingPrice, true);
  Sale sale2 = new Sale(30000, true);
  Listing<Residential, Rental> listResidentialRental;
  Listing<Residential, Rental> listResidentialRentalCopy;
  Listing<Residential, Sale> listResidentialSale2;


  @Before
  public void setUp() throws Exception {
    listResidentialRental = new Listing<>(residential, rental);
    listResidentialRentalCopy = new Listing<>(residential, rental);
    listResidentialSale2 = new Listing<>(residential, sale2);
  }

  @Test
  public void getProperty() {
    assertEquals(residential, listResidentialRental.getProperty());
  }

  @Test
  public void getContract() {
    assertEquals(rental, listResidentialRental.getContract());
  }

  @Test
  public void testEquals() {
    assertTrue(listResidentialRental.equals(listResidentialRentalCopy));
    assertFalse(listResidentialRental.equals(listResidentialSale2));
    assertFalse(listResidentialRental.equals(listResidentialSale2));
    assertFalse(listResidentialRental.equals(null));
    assertFalse(listResidentialRental.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(listResidentialRental.hashCode() == listResidentialRentalCopy.hashCode());
    assertFalse(listResidentialRental.hashCode() == listResidentialSale2.hashCode());
    assertFalse(listResidentialRental.hashCode() == listResidentialSale2.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(listResidentialRental.toString().equals(listResidentialRentalCopy.toString()));
    assertFalse(listResidentialRental.toString().equals(listResidentialSale2.toString()));
  }
}