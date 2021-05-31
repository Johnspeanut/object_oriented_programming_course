package agent;

/**
 * A abstract class representing contract with two features.
 */
public abstract class Contract {
  protected Double askingPrice;
  protected Boolean isNegotiable;

  /**
   * Constructor for Contract class.
   * @param askingPrice asking price of the property.
   * @param isNegotiable Whether the price is negotiable.
   */
  public Contract(double askingPrice, boolean isNegotiable) {
    this.askingPrice = askingPrice;
    this.isNegotiable = isNegotiable;
  }

  /**
   * Gets the asking price.
   * @return asking price.
   */
  public double getAskingPrice() {
    return askingPrice;
  }

  /**
   * Checks if the asking price is negotiable.
   * @return true if it is. O.W. false.
   */
  public boolean isNegotiable() {
    return isNegotiable;
  }

  /**
   * Gets commission
   * @param commissionRate Commission rate
   * @return commission.
   */
  public Double getCommission(Double commissionRate){
    return this.askingPrice * commissionRate;
  }
}
