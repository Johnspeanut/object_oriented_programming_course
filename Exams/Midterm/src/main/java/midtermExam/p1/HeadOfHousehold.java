package midtermExam.p1;

/**
 * A concrete class representing head of household tax filer.
 */
public class HeadOfHousehold extends GroupFiler{

  public HeadOfHousehold(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation,
      Integer numOfDependants, Integer numOfMinorChildren, Double childcareExpense,
      Double dependentCareExpenses) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation,
        numOfDependants, numOfMinorChildren, childcareExpense, dependentCareExpenses);
  }

  @Override
  public String toString() {
    return "HeadOfHousehold{" +
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
}
