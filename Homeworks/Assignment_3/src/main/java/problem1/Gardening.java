package problem1;

/**
 * A concrete class representing a gardening service.
 * @author  John Peng
 * @version v1.0
 */
public class Gardening extends ExteriorService{
  private double price;
  private static final int WASTE_REMOVAL_FEE = 20;

  /**
   * Constructor for the gardening service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   */
  public Gardening(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices) {
    super(address, size, serviceMonthly, numPreviousServices);
  }

  /**
   * Gets the price of the service.
   * @return price of the service.
   */
  public double getPrice() {
    calculatePrice();
    return price;
  }

  /**
   * Gets waste removal fee.
   * @return waste removal fee.
   */
  public int getWasteRemovalFee() {
    return WASTE_REMOVAL_FEE;
  }

  /**
   * Calculate price of the service.
   */
  @Override
  public void calculatePrice() {
    getDiscountPercent();
    getHours();
    this.price = (getHours() * getBASERATE())  * (1 - getDiscountPercent()) + WASTE_REMOVAL_FEE;
  }
}
