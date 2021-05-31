package midtermExam.p1;

import java.util.Objects;

/**
 * A concrete class representing individual tax filer.
 */
public class IndividualFiler extends TaxFile {
  private static final double RETIRE_HEALTH_FACTOR = 0.7;
  private static final double STUDENT_LOAN_DEDUCTION_UPPER_CUTOFF = 75000;
  private static final double STUDENT_LOAN_DEDUCTION_LOWER_CUTOFF = 5000;
  private static final double EDUCATION_DEDUCTION = 1500;
  private static final double TAXABLE_INCOME_CUTOFF = 55000;


  public IndividualFiler(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
  }

  protected Double estimateRetireDeduction(){
    return (this.getContributionHealth() + this.getContributionRetirement()) * RETIRE_HEALTH_FACTOR;
  }

  protected Double estimateStudentDeduction(){
    if(this.studentLoadPaid < STUDENT_LOAN_DEDUCTION_UPPER_CUTOFF && this.studentLoadPaid > STUDENT_LOAN_DEDUCTION_LOWER_CUTOFF){
      return EDUCATION_DEDUCTION;
    }
    return 0.0;
  }

  @Override
  public String toString() {
    return "IndividualFiler{" +
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
   * Method to calculate tax amount.
   * @return tax amount.
   */
  @Override
  public Double calculateTax(){
    double taxableIncome = this.estimateBasicTaxableIncome() - this.estimateDonationDeduction() - this.estimateMortgagePropertyDeduction() - this.estimateRetireDeduction() - this.estimateStudentDeduction();
    double taxableFactor;
    if(taxableIncome < TAXABLE_INCOME_CUTOFF){
      taxableFactor = 0.15;
    }else{
      taxableFactor = 0.19;
    }
    return taxableIncome * taxableFactor;
 }


}
