package problem_2;

/**
 * An interface that regulates methods that are required.
 */
public interface ILinkedList {

  /**
   * Checks if the list is empty.
   * @return True if the list is empty.
   */
  public boolean isEmpty();

  /**
   * Gets the list size.
   * @return size of the list.
   */
  public int size();

  /**
   * Checks if the list contains an element.
   * @param element The element to be checked.
   * @return True if the list contains the element.
   */
  public boolean contains(String element);

  /**
   * Checks if the list contains all elements of another list.
   * @param linkedlist The linked list to be examined.
   * @return True if the list contains all the elements of another list.
   */
  public boolean containsAll(LinkedList linkedlist);

  /**
   * Filters a list based on string length of elements in the list.
   * @param length The length threshold.
   * @return A new list that matches the requirements.
   */
  public LinkedList filterLargerThan(int length);

  /**
   * Checks if the list has duplicated elements.
   * @return True if there is any duplicated element in the list.
   */
  public boolean hasDuplicates();

  /**
   * Removes duplicated elements and return a new list.
   * @return a list that does not have any duplicated element in the list.
   */
  public LinkedList removeDuplicates();


}
