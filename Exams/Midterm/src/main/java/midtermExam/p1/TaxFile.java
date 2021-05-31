package midtermExam.p1;

import java.util.Objects;

/**
 * A abstract class representing a general tax filer.
 */
public abstract class TaxFile implements ITax{
  protected String taxID;
  protected ContactInfo contactInfo;
  protected Double lastYearEarnings;
  protected Double totalIncomeTaxPaid;
  protected Double mortgageInterestPaid;
  protected Double studentLoadPaid;
  protected Double contributionRetirement;
  protected Double contributionHealth;
  protected Double charitableDonation;
  private static final Double MORTGAGE_PROPERTY_INCOME_CUTOFF = 150000.0;
  private static final Double MORTGAGE_PROPERTY_DEDUCTION_CUTOFF = 12500.0;
  private static final Double MORTGAGE_PROPERTY_DEDUCTION = 2500.0;


  public TaxFile(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation) {
    this.taxID = taxID;
    this.contactInfo = contactInfo;
    this.lastYearEarnings = lastYearEarnings;
    this.totalIncomeTaxPaid = totalIncomeTaxPaid;
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.studentLoadPaid = studentLoadPaid;
    this.contributionRetirement = contributionRetirement;
    this.contributionHealth = contributionHealth;
    this.charitableDonation = charitableDonation;
  }

  public String getTaxID() {
    return taxID;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public Double getLastYearEarnings() {
    return lastYearEarnings;
  }

  public Double getTotalIncomeTaxPaid() {
    return totalIncomeTaxPaid;
  }

  public Double getMortgageInterestPaid() {
    return mortgageInterestPaid;
  }

  public Double getStudentLoadPaid() {
    return studentLoadPaid;
  }

  public Double getContributionRetirement() {
    return contributionRetirement;
  }

  public Double getContributionHealth() {
    return contributionHealth;
  }

  public Double getCharitableDonation() {
    return charitableDonation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TaxFile)) {
      return false;
    }
    TaxFile taxFile = (TaxFile) o;
    return Objects.equals(taxID, taxFile.taxID) && Objects
        .equals(contactInfo, taxFile.contactInfo) && Objects
        .equals(lastYearEarnings, taxFile.lastYearEarnings) && Objects
        .equals(totalIncomeTaxPaid, taxFile.totalIncomeTaxPaid) && Objects
        .equals(mortgageInterestPaid, taxFile.mortgageInterestPaid) && Objects
        .equals(studentLoadPaid, taxFile.studentLoadPaid) && Objects
        .equals(contributionRetirement, taxFile.contributionRetirement) && Objects
        .equals(contributionHealth, taxFile.contributionHealth) && Objects
        .equals(charitableDonation, taxFile.charitableDonation);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
            studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
  }

  @Override
  public String toString() {
    return "TaxFile{" +
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

  /**
   * Method estimates basic taxable income
   * @return taxable amount
   */
  protected Double estimateBasicTaxableIncome(){
    return this.lastYearEarnings - this.totalIncomeTaxPaid;
  }

  /**
   * Method estimates  deducting charitable donations.
   * @return  deduction amount.
   */
  protected Double estimateDonationDeduction(){
    return this.charitableDonation;
  }

  protected Double estimateMortgagePropertyDeduction(){
    if(this.getLastYearEarnings() < MORTGAGE_PROPERTY_INCOME_CUTOFF && this.getMortgageInterestPaid() > MORTGAGE_PROPERTY_DEDUCTION_CUTOFF){
      return MORTGAGE_PROPERTY_DEDUCTION;
    }
    return 0.0;
  }

}
