package problem1;

/**
 * MakeOrder interface for all food items. Implemented at Nonperishable and Perishable level
 * Because the maximum quantity for these two kinds are different.
 */
public interface MakeOrder {

  public boolean makeOrder(int numItem);

}
