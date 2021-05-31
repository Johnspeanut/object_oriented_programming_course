package midtermExam.p1;

import java.util.Objects;

/**
 * A concrete class representing self-employer tax filer.
 */
public class SelfEmployedFiler extends IndividualFiler{
  private Double homeOfficeExpenses;
  private Double healthInsuranceExpenses;
  private Double TravelExpenses;
  private Double businessExpenses;

  public SelfEmployedFiler(String taxID, ContactInfo contactInfo, Double lastYearEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double studentLoadPaid,
      Double contributionRetirement, Double contributionHealth, Double charitableDonation,
      Double homeOfficeExpenses, Double healthInsuranceExpenses, Double travelExpenses,
      Double businessExpenses) {
    super(taxID, contactInfo, lastYearEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        studentLoadPaid, contributionRetirement, contributionHealth, charitableDonation);
    this.homeOfficeExpenses = homeOfficeExpenses;
    this.healthInsuranceExpenses = healthInsuranceExpenses;
    TravelExpenses = travelExpenses;
    this.businessExpenses = businessExpenses;
  }

  public Double getHomeOfficeExpenses() {
    return homeOfficeExpenses;
  }

  public Double getHealthInsuranceExpenses() {
    return healthInsuranceExpenses;
  }

  public Double getTravelExpenses() {
    return TravelExpenses;
  }

  public Double getBusinessExpenses() {
    return businessExpenses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SelfEmployedFiler)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SelfEmployedFiler that = (SelfEmployedFiler) o;
    return Objects.equals(homeOfficeExpenses, that.homeOfficeExpenses) && Objects
        .equals(healthInsuranceExpenses, that.healthInsuranceExpenses) && Objects
        .equals(TravelExpenses, that.TravelExpenses) && Objects
        .equals(businessExpenses, that.businessExpenses);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), homeOfficeExpenses, healthInsuranceExpenses, TravelExpenses,
            businessExpenses);
  }

  @Override
  public String toString() {
    return "selfEmployedFiler{" +
        "taxID='" + taxID + '\'' +
        ", contactInfo=" + contactInfo +
        ", lastYearEarnings=" + lastYearEarnings +
        ", totalIncomeTaxPaid=" + totalIncomeTaxPaid +
        ", mortgageInterestPaid=" + mortgageInterestPaid +
        ", studentLoadPaid=" + studentLoadPaid +
        ", contributionRetirement=" + contributionRetirement +
        ", contributionHealth=" + contributionHealth +
        ", charitableDonation=" + charitableDonation +
        ", homeOfficeExpenses=" + homeOfficeExpenses +
        ", healthInsuranceExpenses=" + healthInsuranceExpenses +
        ", TravelExpenses=" + TravelExpenses +
        ", businessExpenses=" + businessExpenses +
        '}';
  }


}
