package problem_1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit nonProfit;
  NonProfit nonProfitCopy;
  NonProfit nonProfitVary;
  String orgName = "WHO";
  LocalDateTime donateDate = LocalDateTime.of(2015,10,1,12,00);
  LocalDateTime currentDate = LocalDateTime.now();
  float donateAmount = 1000;
  Donation oneTimeDonation = new OneTimeDonation(donateAmount ,donateDate);
  Donation oneTimeDonationVary = new OneTimeDonation(500 ,donateDate);
  Donation pledgeDonation = new PledgeDonation(donateAmount ,donateDate);
  Donation monthlyDonation= new MonthlyDonation(donateAmount ,donateDate);
  ArrayList<Donation> donationList = new ArrayList<>(Arrays.asList(oneTimeDonation,pledgeDonation,monthlyDonation));

  @Before
  public void setUp() throws Exception {
    nonProfit = new NonProfit(orgName);
    nonProfitCopy = new NonProfit(orgName);
    nonProfitVary = new NonProfit("NGO");
    nonProfitVary.receiveDonation(oneTimeDonation);
    nonProfit.receiveDonation(oneTimeDonation);
    nonProfit.receiveDonation(pledgeDonation);
    nonProfit.receiveDonation(monthlyDonation);
    nonProfitCopy.receiveDonation(oneTimeDonation);
    nonProfitCopy.receiveDonation(pledgeDonation);
    nonProfitCopy.receiveDonation(monthlyDonation);
  }

  @Test
  public void getOrganizationName() {
    assertEquals(orgName,nonProfit.getOrganizationName());
  }

  @Test
  public void getDonationCollection() {
    assertTrue(donationList.equals(nonProfit.getDonationCollection()));
  }

  @Test
  public void receiveDonation() {
    assertTrue(donationList.equals(nonProfit.getDonationCollection()));
  }

  @Test
  public void donationContain() {
    assertTrue(nonProfit.donationContain(oneTimeDonation));
    assertFalse(nonProfit.donationContain(oneTimeDonationVary));
  }

  @Test
  public void searchDonation() {
    ArrayList<Donation> donationListVary = new ArrayList<>(Arrays.asList(oneTimeDonation));
    assertTrue(donationListVary.equals(nonProfit.searchDonation(oneTimeDonation)));
  }

  @Test
  public void testSearchDonation() {
    assertTrue(donationList.equals(nonProfit.searchDonation(donateDate)));
  }

  @Test
  public void testSearchDonation1() {
    assertTrue(donationList.equals(nonProfit.searchDonation(donateAmount)));
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(5000,nonProfit.getTotalDonationsForYear(2015),0.000001);
    assertEquals(12000,nonProfit.getTotalDonationsForYear(2016),0.000001);
    assertEquals(0,nonProfit.getTotalDonationsForYear(2014),0.000001);
  }

  @Test
  public void testEquals() {
    assertTrue(nonProfit.equals(nonProfitCopy));
    assertFalse(nonProfit.equals(nonProfitVary ));
    assertFalse(nonProfit.equals(null));
    assertFalse(nonProfit.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(nonProfit.equals(nonProfitCopy));
    assertFalse(nonProfit.equals(nonProfitVary ));
    assertTrue(nonProfit.hashCode() == nonProfitCopy.hashCode());
    assertFalse(monthlyDonation.hashCode() == nonProfitVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(nonProfit.toString().equals(nonProfitCopy.toString()));
    assertFalse(nonProfit.toString().equals(nonProfitVary.toString()));
  }
}