package problem2;

import java.util.Objects;

/**
 * A class representing Element node.
 */
public class EleNode implements IList{
  private String stringValue;
  private IList rest;

  /**
   * constructor for the non empty linked list node.
   * @param stringValue The value associated with priority.
   * @param rest The next ILinkedList.
   */
  public EleNode(String stringValue, IList rest) {
    this.stringValue = stringValue;
    this.rest = rest;
  }

  /**
   * Checks if the node is empty node.
   * @return false if the node is non empty.
   */
  @Override
  public Boolean isEmpty(){
    return false;
  }

  /**
   * Checks if the node and it's lined nodes contain string s.
   * @param s The string to be checked.
   * @return true if containing s.
   */
  @Override
  public Boolean contains(String s){
    if(this.isEmpty()){
return false;
    }else{
      return this.stringValue.equals(s) || this.getRest().contains(s);
    }
  }
  /**
   * Counts number of non empty nodes.
   * @return number of non empty nodes.
   */
  @Override
  public Integer count() {
    return 1 + this.rest.count() ;
  }

  /**
   * Gets the rest linked list.
   * @return the rest of linked list.
   */
  @Override
  public IList getRest() {
    return this.rest;
  }

  /**
   * Gets the String value of the element.
   *
   * @return the priority of the node.
   */
  @Override
  public String getString() {
    return this.stringValue;
  }

  /**
   * Override equals method.Only checks current attributes.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EleNode)) {
      return false;
    }
    EleNode eleNode = (EleNode) o;
    return Objects.equals(stringValue, eleNode.stringValue);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(stringValue);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    if(this.isEmpty()){
      return ".";
    }else{
      return this.stringValue + ";" + this.getRest().toString();
    }
  }
}
