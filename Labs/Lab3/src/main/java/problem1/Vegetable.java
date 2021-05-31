package problem1;

/**
 * A class representing a vegetable item.
 * @author  John Peng
 * @version v1.0
 */
public class Vegetable extends PerishableFood{

  /**
   * Construcotr for a food item.
   * @param name Name of the food.
   * @param currentPricePerUnit Current price of the food per unit.
   * @param currentAvailableQuantity Current available quantity of the food.
   * @param orderDate Order date of the food.
   * @param expirationData Expiration of the food.
   */
  public Vegetable(String name, double currentPricePerUnit, int currentAvailableQuantity,
      int orderDate, int expirationData) {
    super(name, currentPricePerUnit, currentAvailableQuantity, orderDate, expirationData);
  }


}
