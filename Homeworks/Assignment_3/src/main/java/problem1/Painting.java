package problem1;

import java.util.Objects;

/**
 * A concrete class representing an painting service.
 * @author  John Peng
 * @version v1.0
 */
public class Painting extends InteriorService{
  private int hours;
  private double price;

  /**
   * Constructor for the painting service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   * @param numOfPets Number of pets in the property.
   */
  public Painting(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices, int numOfPets) {
    super(address, size, serviceMonthly, numPreviousServices, numOfPets);
  }

  /**
   * Gets hours needed.
   * @return hours.
   */
  public int getHours() {
    this.calculateHours();
    return hours;
  }

  /**
   * Gets the price of the service.
   * @return price of the service.
   */
  public double getPrice() {
    this.calculatePrice();
    return price;
  }

  /**
   * Implements calculation of hours based on size of the property.
   */
  @Override
  public void calculateHours() {
    switch (getSize()){
      case SMALL:
      case MEDIUM:
        this.hours = 16;
        break;
      case LARGE:
        this.hours = 24;
        break;
      default:
        this.hours = 0;
    }
  }

  /**
   * Calculate price of the service.
   */
  @Override
  public void calculatePrice() {
    getExtraInteriorFee();
    this.getHours();
    this.price = (this.hours * getBASERATE()) * (1 + getExtraInteriorFee()) * (1 - getDiscountPercent());

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
    Painting painting = (Painting) o;
    return hours == painting.hours && Double.compare(painting.price, price) == 0;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), hours, price);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Painting{" +
        "hours=" + hours +
        ", price=" + price + super.toString() +
        '}';
  }
}
