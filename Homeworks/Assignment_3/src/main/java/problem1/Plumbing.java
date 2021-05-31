package problem1;

import java.util.Objects;

/**
 * A concrete class representing an plumbing service.
 * @author  John Peng
 * @version v1.0
 */
public class Plumbing extends SpecialistService{
  private static final int EXTRA_PERMITTING_FEE = 20;
  private double price;

  /**
   * Constructor for the plumbing service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   * @param numLicensedRequired Number of licensed required.
   * @param isComplex If the property is complex, true. O.W. false.
   */
  public Plumbing(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices, int numLicensedRequired, boolean isComplex) {
    super(address, size, serviceMonthly, numPreviousServices, numLicensedRequired, isComplex);
  }

  /**
   * Gets extra permitting fee.
   * @return the extra permitting fee.
   */
  public int getExtraPermittingFee() {
    return EXTRA_PERMITTING_FEE;
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
   * Calculate price of the service.
   */
  @Override
  public void calculatePrice() {
    getNumLicensedEmployeeRequired();
    this.price = (getNumLicensedEmployeeRequired() * getBASERATE()) + EXTRA_PERMITTING_FEE;
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
    Plumbing plumbing = (Plumbing) o;
    return Double.compare(plumbing.price, price) == 0;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), price);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Plumbing{" +
        "price=" + price + super.toString() +
        '}';
  }
}
