package problem1;

/**
 * A concrete class representing a window cleaning service.
 * @author  John Peng
 * @version v1.0
 */
public class WindowCleaning extends ExteriorService {
  private double windowCleaningExtraFeeRate = 0;
  private int floor;
  private double price;

  /**
   * Constructor for the window cleaning service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   * @param floor The floor of the property.
   */
  public WindowCleaning(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices, int floor) {
    super(address, size, serviceMonthly, numPreviousServices);
    if(floor > 3 || floor <= 0){
      throw new IllegalArgumentException("The floor your entered is invalid.");
    }
    this.floor = floor;
    calculateWindowExtraFeeRate();
  }

  /**
   * Gets extra fee rate for window cleaning.
   * @return extra fee rate for window cleaning.
   */
  public double getWindowCleaningExtraFeeRate() {
    calculateWindowExtraFeeRate();
    return windowCleaningExtraFeeRate;
  }

  /**
   * Gets floor of the property.
   * @return floor of the property.
   */
  public int getFloor() {
    return floor;
  }

  /**
   * Calculate extra window fee rate for the window cleaning service.
   */
  private void calculateWindowExtraFeeRate(){
    if(floor > 1){
      windowCleaningExtraFeeRate = 0.05;
    }
  }

  /**
   * Calculate price of the service.
   */
  @Override
  public void calculatePrice() {
    getDiscountPercent();
    getHours();
    this.price = (getHours() * getBASERATE()) * (1 + windowCleaningExtraFeeRate)* (1 - getDiscountPercent());
  }

  /**
   * Gets the price of the service.
   * @return price of the service.
   */
  public double getPrice() {
    calculatePrice();
    return price;
  }
}
