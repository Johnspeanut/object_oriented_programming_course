package midtermExam.p1;

import java.util.Objects;

/**
 * A concrete class representing group tax filer.
 */
public class GroupFiler extends TaxFile{
  protected Integer numOfDependants;
  protected Integer numOfMinorChildren;
  protected Double childcareExpense;
  protected Double dependentCareExpenses;
  private static final double RETIRE_HEALTH_FACTOR = 0.65;
  private static final Integer HEALTH_RETIREMENT_DEDUCTION_FLOOR = 17500;
  private static final double STUDENT_LOAN_DEDUCTION_UPPER_CUTOFF = 200000;
  private static final double STUDENT_LOAN_DEDUCTION_LOWER_CUTOFF = 7500;
  private static final double EDUCATION_DEDUCTION = 2500;
  private static final Integer CHILDCARE_REDUCTION = 1250;
  private static final Integer CHILDCARE_REDUCTION_INCOME_CUTOFF = 200000;
  private static final Integer CHILDCARE_REDUCTION_EXPENSE_CUTOFF = 5000;
  private static final Integer CHILDCARE_CREDIT_INCOME_CUTOFF = 75000;
  private static final Integer CHILDCARE_CREDIT = 750;
  private static final Integer TAXABLE_INCOME_CUTOFF = 90000;

  public GroupFiler(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation,
      Integer numOfDependants, Integer numOfMinorChildren, Double childcareExpense,
      Double dependentCareExpenses) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
    this.numOfDependants = numOfDependants;
    this.numOfMinorChildren = numOfMinorChildren;
    this.childcareExpense = childcareExpense;
    this.dependentCareExpenses = dependentCareExpenses;
  }

  public Integer getNumOfDependants() {
    return numOfDependants;
  }

  public Integer getNumOfMinorChildren() {
    return numOfMinorChildren;
  }

  public Double getChildcareExpense() {
    return childcareExpense;
  }

  public Double getDependentCareExpenses() {
    return dependentCareExpenses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GroupFiler)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    GroupFiler that = (GroupFiler) o;
    return Objects.equals(numOfDependants, that.numOfDependants) && Objects
        .equals(numOfMinorChildren, that.numOfMinorChildren) && Objects
        .equals(childcareExpense, that.childcareExpense) && Objects
        .equals(dependentCareExpenses, that.dependentCareExpenses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfDependants, numOfMinorChildren, childcareExpense,
        dependentCareExpenses);
  }

  @Override
  public String toString() {
    return "GroupFiler{" +
        "numOfDependants=" + numOfDependants +
        ", numOfMinorChildren=" + numOfMinorChildren +
        ", childcareExpense=" + childcareExpense +
        ", dependentCareExpenses=" + dependentCareExpenses +
        ", taxID='" + taxID + '\'' +
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


  protected Double estimateRetireDeduction(){
    double est = (this.getContributionHealth() + this.getContributionRetirement()) * RETIRE_HEALTH_FACTOR;
    return Math.min(est,HEALTH_RETIREMENT_DEDUCTION_FLOOR);
  }

  protected Double estimateStudentDeduction(){
    if(this.studentLoadPaid < STUDENT_LOAN_DEDUCTION_UPPER_CUTOFF && this.studentLoadPaid > STUDENT_LOAN_DEDUCTION_LOWER_CUTOFF){
      return EDUCATION_DEDUCTION;
    }
    return 0.0;
  }

  protected int estimateChildcareDeduction(){
    if(this.getLastYearEarnings() < CHILDCARE_REDUCTION_INCOME_CUTOFF && this.childcareExpense > CHILDCARE_REDUCTION_EXPENSE_CUTOFF){
      return CHILDCARE_REDUCTION;
    }
    return 0;
  }

  /**
   * This tax credit amount is subtracted from the tax amount.
   * @return estimated childcare credit.
   */
  protected int estimateChildCredit(){
    if(this.getLastYearEarnings() < CHILDCARE_CREDIT_INCOME_CUTOFF){
      return CHILDCARE_CREDIT * this.numOfMinorChildren;
    }
    return 0;
  }

  /**
   * Method to estimate tax amount.
   * @return the tax amount.
   */
  @Override
  public Double calculateTax(){
    double taxableIncome = this.estimateBasicTaxableIncome() - this.estimateDonationDeduction() - this.estimateMortgagePropertyDeduction() - this.estimateRetireDeduction() - this.estimateStudentDeduction() - this.estimateChildcareDeduction();
    double taxableFactor = 0;
    if(taxableIncome < TAXABLE_INCOME_CUTOFF){
      taxableFactor = 0.145;
    }else{
      taxableFactor = 0.19;
    }
    return taxableIncome * taxableFactor + this.estimateChildCredit();
  }
}
