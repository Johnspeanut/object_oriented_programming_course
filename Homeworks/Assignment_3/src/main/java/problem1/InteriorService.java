package problem1;

import java.util.Objects;

/**
 * An abstract class representing an interior service.
 * @author  John Peng
 * @version v1.0
 */
public abstract class InteriorService extends OrdinaryService implements InteriorExtraPercentFee{
  private int numOfPets;
  private double extraInteriorFee;

  /**
   * Constructor for the interior service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   * @param numOfPets Number of pets in the property.
   */
  public InteriorService(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices, int numOfPets) {
    super(address, size, serviceMonthly, numPreviousServices);
    if(numOfPets < 0){
      throw new IllegalArgumentException("The number of pets should be at least 0");
    }
    this.numOfPets = numOfPets;
  }

  /**
   * Gets number of pets in the property.
   * @return number of pets in the property.
   */
  public int getNumOfPets() {
    return numOfPets;
  }

  /**
   * Gets extra interior fee.
   * @return extra interior fee.
   */
  public double getExtraInteriorFee() {
    getDiscountPercent();
    interiorExtraPercentFee();
    return extraInteriorFee;
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
    InteriorService that = (InteriorService) o;
    return numOfPets == that.numOfPets;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfPets);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "InteriorService{" +
        "numOfPets=" + numOfPets + super.toString() +
        '}';
  }

  /**
   * Implements interior extra fee (double data type).
   */
  @Override
  public void interiorExtraPercentFee() {
    if(getNumOfPets() == 1 || getNumOfPets() == 2){
      this.extraInteriorFee = 0.05;
    }else if(getNumOfPets() >= 3){
      this.extraInteriorFee = 0.07;
    }
  }
}
