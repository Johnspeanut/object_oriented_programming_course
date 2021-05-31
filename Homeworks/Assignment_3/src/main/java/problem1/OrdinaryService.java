package problem1;

import java.util.Objects;

/**
 * An abstract class representing an ordinary service.
 * @author  John Peng
 * @version v1.0
 */
public abstract class OrdinaryService extends Service implements CalculateHours,ApplyDiscountRate{
  private static final int BASERATE = 80; // Base rate for all Interior classes.
  private double discountPercent;
  private boolean is10thService = false;

  /**
   * Constructor for the ordinary service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   */
  public OrdinaryService(String address, enumOfSize size, boolean serviceMonthly, int numPreviousServices) {
    super(address, size, serviceMonthly, numPreviousServices);
  }

  /**
   * Gets base rate of hour salary.
   * @return the number of base rate.
   */
  public static int getBASERATE() {
    return BASERATE;
  }

  /**
   * Gets discount percent (double data type).
   * @return discount.
   */
  public double getDiscountPercent() {
    apply10thDiscountRate();
    applyDiscountRate();
    return discountPercent;
  }

  /**
   * Checks if the service is the 10th service.
   * @return true if the service is the 10th service.
   */
  public boolean isIs10thService() {
    apply10thDiscountRate();
    return is10thService;
  }

  /**
   * Override equals method.
   * @param o Object to be checked.
   * @return True if attributes of two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    OrdinaryService that = (OrdinaryService) o;
    return Double.compare(that.discountPercent, discountPercent) == 0
        && is10thService == that.is10thService;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), discountPercent, is10thService);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "OrdinaryService{" +
        ", discountPercent=" + discountPercent +
        ", is10thService=" + is10thService + super.toString() +
        '}';
  }

  /**
   * Checks if the service is the 10th service.
   */
  @Override
  public void apply10thDiscountRate() {
    if(getNumPreviousServices() % 10 == 9){
      this.is10thService = true;
    }
  }

  /**
   * Calculates discount rate based on 10th service and service monthly.
   */
  @Override
  public void applyDiscountRate() {
    if(this.is10thService){
      this.discountPercent = 0.5;
    }else{
      if(this.isServiceMonthly()){
        this.discountPercent = 0.1;
      }
    }
  }
}
