package problem1;

/**
 * A class representing a non perishable item.
 * @author  John Peng
 * @version v1.0
 */
public abstract class NonPerishable extends FoodItem implements MakeOrder{
  private static final int MAX_ALLOWED_QUANTITY = 250;

  /**
   * Construcotr for a non perishable item.
   * @param name Name of the non perishable food.
   * @param currentPricePerUnit Current price of the non perishable food per unit.
   * @param currentAvailableQuantity Current available quantity of the food.
   */
  public NonPerishable(String name, double currentPricePerUnit, int currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }

  /**
   * Get maximum of allowed quantity of food item.
   * @return Maximum of allowed quantity of food item.
   */
  public int getMaxAllowedQuantity() {
    return MAX_ALLOWED_QUANTITY;
  }


  /**
   * Override string method.
   * @return String describing food item.
   */
  @Override
  public String toString() {
    return "NonPerishable{" + "name" + getName() +
        "currentPricePerUnit=" + currentPricePerUnit +
        ", currentAvailableQuantity=" + currentAvailableQuantity +
        '}';
  }

  /**
   * Make order of a particular food item.
   * @param numItem Number of food item.
   * @return True if making an order.
   */
  @Override
  public boolean makeOrder(int numItem) {
    if(numItem <= MAX_ALLOWED_QUANTITY && numItem <= currentAvailableQuantity){
      currentAvailableQuantity -= numItem;
      incomeKindsFood = numItem * getCurrentPricePerUnit();
      companyIncome += incomeKindsFood;
      return true;
    }
      return false;
  }


}
