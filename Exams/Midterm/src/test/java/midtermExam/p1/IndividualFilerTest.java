package midtermExam.p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividualFilerTest {
  IndividualFiler individualFiler;
  IndividualFiler individualFilerCopy;
  IndividualFiler individualFilerVary;
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

  @Before
  public void setUp() throws Exception {
    individualFiler = new IndividualFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation);
    individualFilerCopy = new IndividualFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation);
    individualFilerVary = new IndividualFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,500.0,charitableDonation);
  }

  @Test
  public void getTaxID() {
    assertTrue(individualFiler.taxID.equals(taxID));
  }

  @Test
  public void getContactInfo() {
    assertTrue(individualFiler.contactInfo.equals(contactInfo));
  }

  @Test
  public void getLastYearEarnings() {
    assertTrue(individualFiler.lastYearEarnings.equals(lastYearEarnings));
  }

  @Test
  public void getTotalIncomeTaxPaid() {
    assertTrue(individualFiler.totalIncomeTaxPaid.equals(totalIncomeTaxPaid));
  }

  @Test
  public void getMortgageInterestPaid() {
    assertTrue(individualFiler.mortgageInterestPaid.equals(mortgageInterestPaid));
  }

  @Test
  public void getStudentLoadPaid() {
    assertTrue(individualFiler.studentLoadPaid.equals(studentLoanPaid));
  }

  @Test
  public void getContributionRetirement() {
    assertTrue(individualFiler.contributionRetirement.equals(contributionRetirement));
  }

  @Test
  public void getContributionHealth() {
    assertTrue(individualFiler.contributionHealth.equals(contributionHealth));
  }

  @Test
  public void getCharitableDonation() {
    assertTrue(individualFiler.charitableDonation.equals(charitableDonation));
  }

  @Test
  public void testEquals() {
    assertTrue(individualFiler.equals(individualFilerCopy));
    assertTrue(individualFiler.equals(individualFiler));
    assertFalse(individualFiler.equals(individualFilerVary));
    assertFalse(individualFiler.equals(null));
    assertFalse(individualFiler.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(individualFiler.hashCode() == individualFilerCopy.hashCode());
    assertFalse(individualFiler.hashCode() == individualFilerVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(individualFiler.toString().equals(individualFilerCopy.toString()));
    assertFalse(individualFiler.toString().equals(individualFilerVary.toString()));
  }

  @Test
  public void estimateBasicTaxableIncome() {
    assertEquals(170000.0,individualFiler.estimateBasicTaxableIncome(),0.0001);
  }

  @Test
  public void estimateDonationDeduction() {
    assertEquals(charitableDonation,individualFiler.estimateDonationDeduction(),0.0001);
  }

  @Test
  public void estimateMortgagePropertyDeduction() {
    assertEquals(0.0,individualFiler.estimateMortgagePropertyDeduction(),0.0001);
  }

  @Test
  public void estimateRetireDeduction() {
    assertEquals(21000.0,individualFiler.estimateRetireDeduction(),0.0001);
  }

  @Test
  public void estimateStudentDeduction() {
    assertEquals(1500.0,individualFiler.estimateStudentDeduction(),0.0001);
  }


  @Test
  public void calculateTax() {
    assertEquals(27455.0,individualFiler.calculateTax(),0.0001);
  }
}