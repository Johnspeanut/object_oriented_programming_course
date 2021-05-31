package midtermExam.p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class selfEmployedFilerTest {
  SelfEmployedFiler selfEmployedFiler;
  SelfEmployedFiler selfEmployedFilerCopy;
  SelfEmployedFiler selfEmployedFilerVary;
  String taxID = "001";
  Name name = new Name("John","Lee");
  String phoneNumber = "4512563021";
  String address = "255 Terry Ave";
  String email = "CS5004@northeastern.edu";
  ContactInfo contactInfo = new ContactInfo(name,address,phoneNumber,email);
  Double lastYearEarnings = 200000.0;
  Double totalIncomeTaxPaid = 30000.0;
  Double mortgageInterestPaid = 30000.0;
  Double studentLoanPaid = 10000.0;
  Double contributionRetirement = 20000.0;
  Double contributionHealth = 10000.0;
  Double charitableDonation = 3000.0;
  Double homeOfficeExpenses = 1000.0;
  Double healthInsuranceExpenses = 1000.0;
  Double travelExpenses = 1000.0;
  Double businessExpenses = 1000.0;
  @Before
  public void setUp() throws Exception {
    selfEmployedFiler = new SelfEmployedFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation,homeOfficeExpenses,healthInsuranceExpenses,travelExpenses,businessExpenses);
    selfEmployedFilerCopy = new SelfEmployedFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation,homeOfficeExpenses,healthInsuranceExpenses,travelExpenses,businessExpenses);
    selfEmployedFilerVary = new SelfEmployedFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,500.0,charitableDonation,homeOfficeExpenses,healthInsuranceExpenses,travelExpenses,businessExpenses);
  }

  @Test
  public void getHomeOfficeExpenses() {
    assertTrue(selfEmployedFiler.getHomeOfficeExpenses().equals(homeOfficeExpenses));
  }

  @Test
  public void getHealthInsuranceExpenses() {
    assertTrue(selfEmployedFiler.getHealthInsuranceExpenses().equals(healthInsuranceExpenses));
  }

  @Test
  public void getTravelExpenses() {
    assertTrue(selfEmployedFiler.getTravelExpenses().equals(travelExpenses));
  }

  @Test
  public void getBusinessExpenses() {
    assertTrue(selfEmployedFiler.getBusinessExpenses().equals(businessExpenses));
  }

  @Test
  public void testEquals() {
    assertTrue(selfEmployedFiler.equals(selfEmployedFilerCopy));
    assertTrue(selfEmployedFiler.equals(selfEmployedFiler));
    assertFalse(selfEmployedFiler.equals(selfEmployedFilerVary));
    assertFalse(selfEmployedFiler.equals(null));
    assertFalse(selfEmployedFiler.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(selfEmployedFiler.hashCode() == selfEmployedFilerCopy.hashCode());
    assertFalse(selfEmployedFiler.hashCode() == selfEmployedFilerVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(selfEmployedFiler.toString().equals(selfEmployedFilerCopy.toString()));
    assertFalse(selfEmployedFiler.toString().equals(selfEmployedFilerVary.toString()));
  }

  @Test
  public void calculateTax() {
    assertEquals(27455.0,selfEmployedFiler.calculateTax(),0.0001);
  }

}