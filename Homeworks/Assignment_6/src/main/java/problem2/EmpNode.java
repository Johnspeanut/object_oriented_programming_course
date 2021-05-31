package problem2;

public class EmpNode implements IList{

  public EmpNode(){

  }
  /**
   * Counts number of non empty nodes.
   * @return number of non empty nodes.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Gets the rest linked list.
   * @return the rest of linked list.
   */
  @Override
  public IList getRest() {
    return null;
  }


  /**
   * Gets the String value of the element.
   * @return the priority of the node.
   */
  @Override
  public String getString() {
    return null;
  }

  @Override
  public Boolean contains(String s) {
    return false;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public String toString() {
    return "." ;
  }
}
