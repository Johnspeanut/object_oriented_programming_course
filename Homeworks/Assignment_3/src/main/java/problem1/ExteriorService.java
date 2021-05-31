package problem1;

/**
 * An abstract class representing an interior service.
 * @author  John Peng
 * @version v1.0
 */
public abstract class ExteriorService extends OrdinaryService implements CalculateHours{
  private int hours;

  /**
   * Constructor for the exterior service class.
   * @param address Address of the a property.
   * @param size Size of the property.
   * @param serviceMonthly If service monthly.
   * @param numPreviousServices Number of previous services ordered.
   */
  public ExteriorService(String address, enumOfSize size, boolean serviceMonthly,
      int numPreviousServices) {
    super(address, size, serviceMonthly, numPreviousServices);
  }

  /**
   * Gets hours needed.
   * @return hours.
   */
  public int getHours() {
    calculateHours();
    return hours;
  }

  /**
   * Implements calculation of hours based on size of the property.
   */
  @Override
  public void calculateHours() {
    switch (getSize()){
      case SMALL:
        this.hours = 1;
        break;
      case MEDIUM:
        this.hours = 2;
        break;
      case LARGE:
        this.hours = 3;
        break;
      default:
        this.hours = 0;
    }
  }
}
