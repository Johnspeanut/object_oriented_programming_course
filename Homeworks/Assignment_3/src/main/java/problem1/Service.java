package problem1;

import java.util.Objects;

/**
 * An abstract class representing a service.
 * @author  John Peng
 * @version v1.0
 */
public abstract class Service implements CalculatePrice {
  private String address;
  private enumOfSize size;
  private boolean isServiceMonthly;
  private int numPreviousServices;

  /**
   * Constructor for the service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   */
  public Service(String address, enumOfSize size, boolean serviceMonthly, int numPreviousServices) {
    if(numPreviousServices < 0){
      throw new IllegalArgumentException("THe number of previous service should not be negative.");
    }
    this.address = address;
    this.size = size;
    this.isServiceMonthly = serviceMonthly;
    this.numPreviousServices = numPreviousServices;
  }

  /**
   * Gets address of the property.
   * @return Address of the property.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets size of the property.
   * @return size of the property.
   */
  public enumOfSize getSize() {
    return size;
  }

  /**
   * Checks if service monthly.
   * @return true if service monthly.
   */
  public boolean isServiceMonthly() {
    return isServiceMonthly;
  }

  /**
   * Gets the number of previous services.
   * @return number of previous services.
   */
  public int getNumPreviousServices() {
    return numPreviousServices;
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
    Service service = (Service) o;
    return isServiceMonthly == service.isServiceMonthly
        && numPreviousServices == service.numPreviousServices && address.equals(service.address)
        && size == service.size;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, size, isServiceMonthly, numPreviousServices);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Service{" +
        "address='" + address + '\'' +
        ", size=" + size +
        ", serviceMonthly=" + isServiceMonthly +
        ", numPreviousServices=" + numPreviousServices +
        '}';
  }
}
