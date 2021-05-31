package problem1;

/**
 * A class representing a pasta item.
 * @author  John Peng
 * @version v1.0
 */
public class Pasta extends NonPerishable{

  /**
   * Construcotr for a food item.
   * @param name Name of the food.
   * @param currentPricePerUnit Current price of the food per unit.
   * @param currentAvailableQuantity Current available quantity of the food.
   */
  public Pasta(String name, double currentPricePerUnit, int currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }


}
