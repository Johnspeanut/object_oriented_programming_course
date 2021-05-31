package agent;

import java.util.Objects;

/**
 * A concrete class representing rental contract.
 */
public class Rental extends Contract{
  protected Integer termInMonths;

  /**
   * Constructor for Rental class object.
   * @param askingPrice The asking price of the property.
   * @param isNegotiable If the price is negotiable.
   * @param termInMonths The terms in months of the contract.
   */
  public Rental(double askingPrice, boolean isNegotiable, Integer termInMonths) {
    super(askingPrice, isNegotiable);
    this.termInMonths = termInMonths;
  }

  /**
   * Gets the terms in months of the contract.
   * @return the terms in months of the contract.
   */
  public Integer getTermInMonths() {
    return termInMonths;
  }


  @Override
  public Double getCommission(Double commissionRate) {
    return super.getCommission(commissionRate) * this.termInMonths;
  }

  /**
   * Override the equals method.
   * @param o Object to be compared.
   * @return true if two objects are equals in attributes.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rental)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(termInMonths, rental.termInMonths) &&
        Objects.equals(askingPrice, rental.askingPrice) &&
        Objects.equals(isNegotiable, rental.isNegotiable);
  }

  /**
   * Override hashcode.
   * @return hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(termInMonths,askingPrice, isNegotiable);
  }

  /**
   * Override toString method.
   * @return string of the object.
   */
  @Override
  public String toString() {
    return "Rental{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        ", termInMonths=" + termInMonths +
        '}';
  }
}
