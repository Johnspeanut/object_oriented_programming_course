package agent;

import java.util.Objects;

/**
 * A concrete class representing Residential property.
 */
public class Residential extends Property{
  private Integer numOfBedroom;
  private double numOfBathroom;

  /**
   * Constructor for the residential class object.
   * @param address The address of the property.
   * @param size The size of the property.
   * @param numOfBedroom Number of bedrooms in the property.
   * @param numOfBathroom Number of bathrooms in the property.
   */
  public Residential(String address, Integer size, Integer numOfBedroom, double numOfBathroom) {
    super(address, size);
    this.numOfBedroom = numOfBedroom;
    this.numOfBathroom = numOfBathroom;
  }

  /**
   * Gets the number of bedrooms
   * @return number of bedrooms.
   */
  public Integer getNumOfBedroom() {
    return numOfBedroom;
  }

  /**
   * Gets the number of bathrooms.
   * @return the number of bathrooms.
   */
  public double getNumOfBathroom() {
    return numOfBathroom;
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
    if (!(o instanceof Residential)) {
      return false;
    }
    Residential that = (Residential) o;
    return Double.compare(that.numOfBathroom, numOfBathroom) == 0 && Objects
        .equals(numOfBedroom, that.numOfBedroom) && Objects.equals(address,that.address)
        && Objects.equals(size, that.size);
  }

  /**
   * Override hashcode.
   * @return hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(numOfBedroom, numOfBathroom, address, size);
  }

  /**
   * Override toString method.
   * @return string of the object.
   */
  @Override
  public String toString() {
    return "Residential{" +
        "address='" + address + '\'' +
        ", size=" + size +
        ", numOfBedroom=" + numOfBedroom +
        ", numOfBathroom=" + numOfBathroom +
        '}';
  }
}
