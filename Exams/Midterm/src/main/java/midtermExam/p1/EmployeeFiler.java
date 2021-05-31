package midtermExam.p1;

/**
 * A concrete class representing individual tax filer.
 */
public class EmployeeFiler extends IndividualFiler{

  public EmployeeFiler(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
  }

  @Override
  public String toString() {
    return "EmployeeFiler{" +
        "taxID='" + taxID + '\'' +
        ", contactInfo=" + contactInfo +
        ", lastYearEarnings=" + lastYearEarnings +
        ", totalIncomeTaxPaid=" + totalIncomeTaxPaid +
        ", mortgageInterestPaid=" + mortgageInterestPaid +
        ", studentLoadPaid=" + studentLoadPaid +
        ", contributionRetirement=" + contributionRetirement +
        ", contributionHealth=" + contributionHealth +
        ", charitableDonation=" + charitableDonation +
        '}';
  }
}
