package midtermExam.p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeFilerTest {
  EmployeeFiler employeeFiler;
  EmployeeFiler employeeFilerCopy;
  EmployeeFiler employeeFilerVary;
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
    employeeFiler = new EmployeeFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation);
    employeeFilerCopy = new EmployeeFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,contributionHealth,charitableDonation);
    employeeFilerVary = new EmployeeFiler(taxID,contactInfo,lastYearEarnings,totalIncomeTaxPaid,mortgageInterestPaid,studentLoanPaid,contributionRetirement,500.0,charitableDonation);
  }

  @Test
  public void testToString() {
    assertTrue(employeeFiler.toString().equals(employeeFilerCopy.toString()));
    assertFalse(employeeFiler.toString().equals(employeeFilerVary.toString()));
  }

  @Test
  public void calculateTax() {
    assertEquals(27455.0,employeeFiler.calculateTax(),0.0001);
  }
}