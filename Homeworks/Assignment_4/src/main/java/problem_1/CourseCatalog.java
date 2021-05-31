package problem_1;

import java.util.Objects;

/**
 * A class representing Course catalog using linked list implementation.
 */
public class CourseCatalog implements IcourseCatalog {
  private Node head;
  private int numNodes;

  /**
   * constructor for a CourseCatalog.
   */
  public CourseCatalog(){
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Static method to create an empty CourseCatalog.
   * @return a new empty CourseCatalog.
   */
  public static CourseCatalog createEmpty(){
    return new CourseCatalog();
  }

  /**
   * Gets the head node of the CourseCatalog.
   * @return the head node of the CourseCatalog.
   */
  public Node getHead() {
    return head;
  }

  /**
   * Gets the number of nodes of the CourseCatalog.
   * @return the number of the nodes of the CourseCatalog.
   */
  public int getNumNodes() {
    return numNodes;
  }

  /**
   * Adds a Course to the end of the CourseCatalog.
   * @param course Course to be added.
   */
  @Override
  public void append(Course course) {
    Node newNode = new Node(course,null);
    if(this.head == null){
      this.head = newNode;
    }else{
      Node currNode = this.head;
      while(currNode.getNextNode() != null){
        currNode = currNode.getNextNode();
      }
      currNode.setNextNode(newNode);
    }
    this.numNodes ++;
  }

  /**
   * Removes a specified course from the CourseCatalog.
   * @param course The course to be moved.
   */
  @Override
  public void remove(Course course) {
    if(this.contains(course)){
      Node currNode = this.head;
     if(currNode.getCourse().equals(course)){ // first node return true.
       this.head = currNode.getNextNode();
       this.numNodes --;
       return;
     }
      Node next = currNode.getNextNode();
     while(true){
     if(next == null){
       return;
     }else if(next.getCourse().equals(course)){
       break;
     }
     currNode = next;
     next = next.getNextNode();
     }
     currNode.setNextNode(next.getNextNode());
     next.setNextNode(null);
  }
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course The course to be checked.
   * @return True if the course exists in the CourseCatalog.
   */
  @Override
  public boolean contains(Course course) {
    if(this.head == null){
      return false;
    }
    Node currNode = this.head;
    while(true){
      if(currNode.getCourse().equals(course)){
        return true;
      }
      if(currNode == null || currNode.getNextNode() == null){
        break;
      }
      currNode = currNode.getNextNode();
    }
    return false;
  }

  /**
   * Checks if the specified course exists in te CourseCatalog.
   * @param course The course to be checked.
   * @return the index of the specified Course in the CourseCatalog. If it exists. If the Course
   * doesn't exist, returns -1.
   */
  @Override
  public int indexOf(Course course) {
    if(this.contains(course)){
      Node currNode = this.head;
      int index = 0;
      while(currNode != null){
        if(currNode.getCourse().equals(course)){
          return index;
        }
        if(currNode.getNextNode() == null){
          return -1;
        }
        currNode = currNode.getNextNode();
        index ++;
      }
    }
    return -1;
  }

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of Courses in the CourseCatalog.
   */
  @Override
  public int count() {
    return this.numNodes;
  }

  /**
   * Gets the course at the given index.
   * @param index The index.
   * @return the Course at the given index in the CourseCatalog.
   */
  @Override
  public Course get(int index) throws IndexOutOfBoundsException{
    this.checkOutBound(index);
    if(index == 0){
      return this.head.getCourse();
    }else{
      int i = 0;
      Node currNode = this.head;
      while(i < index - 1){
        i++;
        currNode = currNode.getNextNode();
      }
      return currNode.getCourse();
    }
  }

  /**
   * A helper method to check if the index is out of bounds.
   * @param index An index to be checked.
   * @throws IndexOutOfBoundsException
   */
  private void checkOutBound(int index) throws IndexOutOfBoundsException{
    if(index >= this.numNodes || index < 0){
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * checks if the CourseCatalog is empty.
   * @return true if the CourseCatalog is empty.
   */
  @Override
  public boolean isEmpty() {
    return this.numNodes == 0;
  }

  /**
   * Override the equals method. If and only if the two CourseCatalogs contain the same
   * Courses in the same order, return true.
   * @param o an object to be compared.
   * @return true if objects are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CourseCatalog)) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    if(numNodes != that.numNodes){
      return false;
    }
    for(int i = 0; i < numNodes; i++){
      if(!this.get(i).equals(that.get(i))){
        return false;
      }
    }
    return true;
  }

  /**
   * Override the hashcode method. Taking order and courses in the CourseCatalog
   * into account.
   * @return true if two nodes have the same hashcode.
   */
  @Override
  public int hashCode() {
    int result = Objects.hashCode(numNodes);
    result = 31 * result;
    for(int i = 0; i < numNodes; i++){
result += 31 * Objects.hashCode(this.get(i));
      }
    return result;
  }

  /**
   * Override the toString method. Taking order and courses in the CourseCatalog
   * into account.
   * @return true if two nodes have the same strings.
   */
  @Override
  public String toString() {
    String msg = "numNodes =" + numNodes;
    for(int i = 0; i < numNodes; i++){
      msg = msg + "/" +this.get(i);
    }
    return msg;
  }
}
