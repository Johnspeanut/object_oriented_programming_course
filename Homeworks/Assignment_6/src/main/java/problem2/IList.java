package problem2;

public interface IList {
  /**
   * Counts number of non empty nodes.
   * @return number of non empty nodes.
   */
  Integer count();

  /**
   * Gets the rest linked list.
   * @return the rest of linked list.
   */
  IList getRest();

  /**
   * Gets the String value of the element.
   * @return the priority of the node.
   */
  String getString();

  /**
   * Checks if the node and it's lined nodes contain string s.
   * @param s The string to be checked.
   * @return true if containing s.
   */
  Boolean contains(String s);

  /**
   * Checks if the node is empty node.
   * @return false if the node is non empty.
   */
  Boolean isEmpty();


}
