package problem1;

import java.util.Objects;

/**
 * An abstract class representing a specialist service.
 * @author  John Peng
 * @version v1.0
 */
public abstract class SpecialistService extends Service{
  private static final int BASERATE = 200;
  private int numLicensedRequired;
  private boolean isComplex;

  /**
   * Constructor for the specialist service class. Have checked the input of numLicensedRequired.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   * @param numLicensedRequired Number of licensed required.
   * @param isComplex If the property is complex, true. O.W. false.
   */
  public SpecialistService(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices, int numLicensedRequired, boolean isComplex) {
    super(address, size, serviceMonthly, numPreviousServices);
    this.isComplex = isComplex;
    if(numLicensedRequired< 0){
      throw new IllegalArgumentException("The licensed employee you entered is invalid.");
    }
    this.calculateMinRequiredLicenses();
    if(numLicensedRequired > this.numLicensedRequired){
      this.numLicensedRequired = numLicensedRequired;
    }
  }

  /**
   * Calculates minimum licenses required.
   */
  private void calculateMinRequiredLicenses(){
    if(isComplex && (getSize().equals(enumOfSize.SMALL)||getSize().equals(enumOfSize.MEDIUM))){
      this.numLicensedRequired = 2;
    }else if(isComplex && getSize().equals(enumOfSize.LARGE)){
      this.numLicensedRequired = 3;
    }else{
    this.numLicensedRequired = 1;}
  }

  /**
   * Gets base rate per license.
   * @return Base rate per license.
   */
  public int getBASERATE() {
    return BASERATE;
  }

  /**
   * Gets number of licensed employees required.
   * @return number of licensed employees required.
   */
  public int getNumLicensedEmployeeRequired() {
    calculateMinRequiredLicenses();
    return numLicensedRequired;
  }

  /**
   * Checks if the property is complex.
   * @return true if the property is complex.
   */
  public boolean isComplex() {
    return isComplex;
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
    SpecialistService that = (SpecialistService) o;
    return numLicensedRequired == that.numLicensedRequired
        && isComplex == that.isComplex;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numLicensedRequired, isComplex);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "SpecialistService{" +
        "numLicensedEmployeeRequired=" + numLicensedRequired +
        ", isComplex=" + isComplex +
        '}';
  }
}
