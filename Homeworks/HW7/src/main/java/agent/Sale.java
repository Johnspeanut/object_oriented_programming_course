package agent;

import java.util.Objects;

/**
 * A concrete class representing sale contract.
 */
public class Sale extends Contract{

  /**
   * Constructor for Sale class object.
   * @param askingPrice The asking price of the property.
   * @param isNegotiable If the price is negotiable.
   */
  public Sale(double askingPrice, boolean isNegotiable) {
    super(askingPrice, isNegotiable);
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
    if (!(o instanceof Sale)) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(askingPrice, sale.askingPrice) &&
        Objects.equals(isNegotiable, sale.isNegotiable);
  }

  /**
   * Override hashcode.
   * @return hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(askingPrice, isNegotiable);
  }

  /**
   * Override toString method.
   * @return string of the object.
   */
  @Override
  public String toString() {
    return "Sale{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }
}
