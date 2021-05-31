package problem_2;

/**
 * An interface to define the ADT methods.
 */
public interface ISet {

  /**
   * Creates and returns an empty Set.
   */
  public Set emptySet();

  /**
   * Checks if the Set is empty.
   * @return true if the Set contains no items, false otherwise.
   */
  public Boolean isEmpty();

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n An Integer object.
   * @return A Set having Integer n object.
   */
  public Set add(Integer n);

  /**
   * Check if the Set contains n object.
   * @param n The Integer object.
   * @return true if the given Integer is in the Set, false otherwise.
   */
  public Boolean contains(Integer n);

  /**
   * Remove the Integer object.
   * @param n The Integer object.
   * @return a copy of the Set with the given Integer removed.If the given Integer is not in the Set,
   * returns the Set as it.
   */
  public Set remove(Integer n);

  /**
   * Gets the number of items in the Set.
   * @return the number of items in the Set.
   */
  public Integer size();

}
