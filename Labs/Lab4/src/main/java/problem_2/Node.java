package problem_2;

import java.util.Objects;

/**
 * Represents a singly-linked node for a Linked List.
 */
public class Node {
  private String item;
  private Node nextNode;

  /**
   * Construcotr for a Node.
   * @param item The item to store.
   * @param nextNode A reference to the next Node, if any.
   */
  public Node(String item, Node nextNode){
    this.item = item;
    this.nextNode = nextNode;
  }

  /**
   * Gets the item in the Node.
   * @return The item.
   */
  public String getItem() {
    return item;
  }

  /**
   * Gets the next Node.
   * @return The next Node, if present. Returns null if this is the end of the list.
   */
  public Node getNextNode() {
    return nextNode;
  }

  /**
   * Sets the next Node.
   * @param nextNode The next Node in the list. This will be null if the current Node is to be the end of the list.
   */
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  /**
   * Override the equals method.
   * @param o An object to be compared.
   * @return True if two objects are equals in values.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(item, node.item) && Objects
        .equals(nextNode, node.nextNode);
  }

  /**
   * Compares hashcode of two nodes.
   * @return True if two nodes are equals in values.
   */
  @Override
  public int hashCode() {
    return Objects.hash(item, nextNode);
  }

  /**
   * Converts the fields to string.
   * @return the string.
   */
  @Override
  public String toString() {
    return "Node{" +
        "item='" + item + '\'' +
        ", nextNode=" + nextNode +
        '}';
  }
}
