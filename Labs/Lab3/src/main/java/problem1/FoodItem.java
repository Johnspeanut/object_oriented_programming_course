package problem1;

import java.util.Objects;

/**
 * A class representing a food item.
 * @author  John Peng
 * @version v1.0
 */
public abstract class FoodItem implements MakeOrder{
  public static double companyIncome;
  double incomeKindsFood;
  private String name;
  double currentPricePerUnit;
  int currentAvailableQuantity;

  /**
   * Constructor for the FoodItem class. This is an abstract class.
   * @param name Name of the food.
   * @param currentPricePerUnit Current price of the food per unit.
   * @param currentAvailableQuantity Current available quantity of the food.
   */

  public FoodItem(String name, double currentPricePerUnit, int currentAvailableQuantity){
    if(currentPricePerUnit <= 0 || currentAvailableQuantity <= 0){
      throw new IllegalArgumentException("The price or quantity you enter is invalid.");
    }
    this.name = name;
    this.currentPricePerUnit = currentPricePerUnit;
    this.currentAvailableQuantity = currentAvailableQuantity;
  }

  /**
   * Get company total income. This is a static method.
   * @return Total income of the company.
   */
  public static double getCompanyIncome() {
    return companyIncome;
  }

  /**
   * Get the name of the food.
   * @return Name of the food.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the current price per unit of the food.
   * @return current price per unit of the food.
   */
  public double getCurrentPricePerUnit() {
    return currentPricePerUnit;
  }

  /**
   * Gets the current available quantity of the food.
   * @return the current available quantity of the food.
   */
  public int getCurrentAvailableQuantity() {
    return currentAvailableQuantity;
  }

  /**
   * Gets the income for a specific food item.
   * @return income for a specific food item.
   */
  public double getIncomeKindsFood() {
    return incomeKindsFood;
  }

  /**
   * Override equals.
   * @param o Object to be checked.
   * @return True if equal. O.W. false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return Double.compare(foodItem.currentPricePerUnit, currentPricePerUnit) == 0
        && currentAvailableQuantity == foodItem.currentAvailableQuantity && Objects
        .equals(name, foodItem.name);
  }

  /**
   * Override hashcode.
   * @return Hashcode value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, currentPricePerUnit, currentAvailableQuantity);
  }


}
