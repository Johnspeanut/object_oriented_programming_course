package problem1;

public interface IPQ {

//  public static PriorityQueue createEmpty();

  /**
   * Checks if the queue is empty. Whether it has only empty node.
   * @return true if it only has empty node.
   */
  public Boolean isEmpty();

  /**
   * Adds the given element(the priority and its associated value) to the PQ
   * The priority queue is constructed like this. Arranging the queue based on
   * priority and then priority value alphabetically. So the top of the PQ is
   * the node having highest priority.
   * If priority are equal. The order of the list is alphabetically.
   * @param priority Priority.
   * @param value Value associated with the priority.
   * @return
   */
  public PriorityQueue add(Integer priority, String value);

  /**
   * Gets value of highest PQ. Taking multiple elements sharing the same priority into account
   * If priority is the same, then priority value is peak by its value alphabetically.
   * @return priority value of highest PQ
   */
  public String peak();

  /**
   * If priority is equal,pop the element based on its value alphabetically.
   * @return a copy of the PQ without the element with the highest priority.
   */
  public PriorityQueue pop();

  /**
   * Gets the size of the queue.
   * @return the size of the queue.
   */
  public Integer size();
}
