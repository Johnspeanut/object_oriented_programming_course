package agent;

import java.util.Objects;

/**
 * A concrete class representing commercial property.
  */
public class Commercial extends Property{
  private Integer numOfOffice;
  private boolean isSuitableRetail;

  /**
   * Constructor for the commercial class object.
   * @param address The address of the property.
   * @param size The size of the property.
   * @param numOfOffice Number of offices in the property.
   * @param isSuitableRetail If the property is suitable for retail.
   */
  public Commercial(String address, Integer size, Integer numOfOffice, boolean isSuitableRetail) {
    super(address, size);
    this.numOfOffice = numOfOffice;
    this.isSuitableRetail = isSuitableRetail;
  }

  /**
   * Gets the number of offices of the property.
   * @return the number of offices.
   */
  public Integer getNumOfOffice() {
    return numOfOffice;
  }

  /**
   * Checks if the property is suitable for retail.
   * @return true if it is suitable for retail. O.W. false.
   */
  public boolean isSuitableRetail() {
    return isSuitableRetail;
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
    if (!(o instanceof Commercial)) {
      return false;
    }
    Commercial that = (Commercial) o;
    return isSuitableRetail == that.isSuitableRetail && Objects
        .equals(numOfOffice, that.numOfOffice) && Objects.equals(address,that.address)
        && Objects.equals(size, that.size);
  }

  /**
   * Override hashcode.
   * @return hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(numOfOffice, isSuitableRetail, address, size);
  }

  /**
   * Override toString method.
   * @return string of the object.
   */
  @Override
  public String toString() {
    return "Commercial{" +
        "numOfOffice=" + numOfOffice +
        ", isSuitableRetail=" + isSuitableRetail +
        ", address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}
