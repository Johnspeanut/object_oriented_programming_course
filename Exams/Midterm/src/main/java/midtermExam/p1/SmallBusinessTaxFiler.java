package midtermExam.p1;

import java.util.Objects;

/**
 * A concrete class representing small business tax filer.
 */
public class SmallBusinessTaxFiler extends TaxFile{
  private Integer numOfEmployees;
  private Double employeeExpenses;
  private Double businessExpenses;
  private static final Integer SMALL_BUSINESS_CREDIT = 2500;
  private static final Double SMALL_BUSINESS_TAX_FACTOR = 0.15;

  public SmallBusinessTaxFiler(String taxID, ContactInfo contactInfo,
      Double lastYearEarnings, Double totalIncomeTaxPaid, Double mortgageInterestPaid,
      Double studentLoadPaid, Double contributionRetirement, Double contributionHealth,
      Double charitableDonation, Integer numOfEmployees, Double employeeExpenses,
      Double businessExpenses) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
    this.numOfEmployees = numOfEmployees;
    this.employeeExpenses = employeeExpenses;
    this.businessExpenses = businessExpenses;
  }

  public Integer getNumOfEmployees() {
    return numOfEmployees;
  }

  public Double getEmployeeExpenses() {
    return employeeExpenses;
  }

  public Double getBusinessExpenses() {
    return businessExpenses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SmallBusinessTaxFiler)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SmallBusinessTaxFiler that = (SmallBusinessTaxFiler) o;
    return Objects.equals(numOfEmployees, that.numOfEmployees) && Objects
        .equals(employeeExpenses, that.employeeExpenses) && Objects
        .equals(businessExpenses, that.businessExpenses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfEmployees, employeeExpenses, businessExpenses);
  }

  @Override
  public String toString() {
    return "SmallBusinessTaxFiler{" +
        "numOfEmployees=" + numOfEmployees +
        ", employeeExpenses=" + employeeExpenses +
        ", businessExpenses=" + businessExpenses +
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

  /**
   * Method to estimate tax amount.
   * @return the tax amount.
   */
  @Override
  public Double calculateTax() {
    double est = this.estimateBasicTaxableIncome() - this.estimateDonationDeduction() - this.businessExpenses - this.employeeExpenses;
    est = est - SMALL_BUSINESS_CREDIT * this.numOfEmployees;
    return est * SMALL_BUSINESS_TAX_FACTOR;
  }
}
