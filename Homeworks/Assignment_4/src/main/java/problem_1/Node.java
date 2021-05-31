package problem_1;

import java.util.Objects;

/**
 * A class representing Node with Course and next node reference.
 */
public class Node {
  private Course course;
  private Node nextNode;

  /**
   * Constructor for the Node class.
   * @param course Course object.
   * @param nextNode next node.
   */
  public Node(Course course, Node nextNode){
    this.course = course;
    this.nextNode = nextNode;
  }

  /**
   * Gets course of the node.
   * @return The course of the node.
   */
  public Course getCourse() {
    return course;
  }

  /**
   * Gets the next node of the node.
   * @return the next ndoe of the node.
   */
  public Node getNextNode() {
    return nextNode;
  }

  /**
   * Sets the next node of the node.
   * @param nextNode The next node of the node.
   */
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  /**
   * Override the equals method.
   * @param o an object to be compared.
   * @return true if objects are equals.
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
    return Objects.equals(course, node.course) && Objects
        .equals(nextNode, node.nextNode);
  }

  /**
   * Override the hashcode method.
   * @return true if two nodes have the same hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(course, nextNode);
  }

  /**
   * Override the toString method.
   * @return true if two nodes have the same strings.
   */
  @Override
  public String toString() {
    return "Node{" +
        "course=" + course +
        ", nextNode=" + nextNode +
        '}';
  }
}
