package problem1;

import java.util.Objects;

/**
 * A class representing a perishable item.
 * @author  John Peng
 * @version v1.0
 */
public abstract class PerishableFood extends FoodItem{
  private static final int MAX_ALLOWED_QUANTITY = 100;
  private int orderDate;
  private int expirationData;

  /**
   * Construcotr for a perishable item.
   * @param name Name of the perishable food.
   * @param currentPricePerUnit Current price of the perishable food per unit.
   * @param currentAvailableQuantity Current available quantity of the food.
   * @param orderDate Order date of the food.
   * @param expirationData Expiration of the food.
   */
  public PerishableFood(String name, double currentPricePerUnit, int currentAvailableQuantity,
      int orderDate, int expirationData) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
    this.orderDate = orderDate;
    this.expirationData = expirationData;
  }

  /**
   * Get maximum of allowed quantity of food item.
   * @return Maximum of allowed quantity of food item.
   */
  public int getMaxAllowedQuantity() {
    return MAX_ALLOWED_QUANTITY;
  }

  /**
   * Gets order date.
   * @return order date.
   */
  public int getOrderDate() {
    return orderDate;
  }

  /**
   * Get expiration date.
   * @return expiration date.
   */
  public int getExpirationData() {
    return expirationData;
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

  /**
   * Overrides the equals method.
   * @param o Object to be checked.
   * @return True if attributes are equals for food items.
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
    PerishableFood that = (PerishableFood) o;
    return orderDate == that.orderDate && expirationData == that.expirationData;
  }

  /**
   * Override hashcode.
   * @return Hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderDate, expirationData);
  }

  /**
   * Override string method.
   * @return String describing food item.
   */
  @Override
  public String toString() {
    return "PerishableFood{" + "name" + getName() +
        "currentPricePerUnit=" + currentPricePerUnit +
        ", currentAvailableQuantity=" + currentAvailableQuantity +
        ", orderDate=" + orderDate +
        ", expirationData=" + expirationData +
        '}';
  }
}
