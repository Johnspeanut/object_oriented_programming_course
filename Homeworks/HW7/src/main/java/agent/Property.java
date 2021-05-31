package agent;

/**
 * A abstract class representing Property with two features: address and size.
 */
public abstract class Property {
  protected String address;
  protected Integer size;

  /**
   * Constructor for the Property class.
   * @param address The address of the property.
   * @param size The size of the property.
   */
  public Property(String address, Integer size) {
    this.address = address;
    this.size = size;
  }

  /**
   * Gets the address of the property.
   * @return the address of the property.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets the size of the property.
   * @return the size of the property.
   */
  public Integer getSize() {
    return size;
  }

}
