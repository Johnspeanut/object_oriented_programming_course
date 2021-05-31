package problem_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A class representing linked list.
 */
public class LinkedList  implements ILinkedList{
  private Node head;
  private int numNodes;

  /**
   * Constructor for the class.
   */
  public LinkedList(){
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Creates an empty list.
   * @return An empty list.
   */
  public static LinkedList createEmpty(){
    return new LinkedList();
  }

  /**
   * Adds a node to the linked list.
   * @param item The item to be added.
   */
  public void addNode(String item){
    Node newNode = new Node(item,null);
if(this.head == null){
  this.head = newNode;
}else{
  Node currNode = this.head;
  while(currNode.getNextNode() != null){
    currNode = currNode.getNextNode();
  }
  currNode.setNextNode(newNode);
}
this.numNodes++;
  }

  /**
   * Checks if the list is empty.
   * @return True if the list is empty.
   */
  @Override
  public boolean isEmpty() {
    return this.numNodes == 0;
  }

  /**
   * Gets the list size.
   * @return size of the list.
   */
  @Override
  public int size() {
    return this.numNodes;
  }

  /**
   * Checks if the list contains an element.
   * @param element The element to be checked.
   * @return True if the list contains the element.
   */
  @Override
  public boolean contains(String element) {
    Node currNode = this.head;
    if(currNode == null){
    }
    while(currNode.getNextNode() != null){
      if(currNode.getItem().equals(element)){
        return true;
      }
      currNode = currNode.getNextNode();
    }
    return false;
  }

  /**
   * Checks if the list contains all elements of another list.
   * @param linkedlist The linked list to be examined.
   * @return True if the list contains all the elements of another list.
   */
  @Override
  public boolean containsAll(LinkedList linkedlist) {
    Node currNode = linkedlist.head;
    while(currNode.getNextNode() != null){
      if(!this.contains(currNode.getItem())){
        return false;
      }
      currNode = currNode.getNextNode();
    }
    return true;
  }

  /**
   * Filters a list based on string length of elements in the list.
   * @param length The length threshold.
   * @return A new list that matches the requirements.
   */
  @Override
  public LinkedList filterLargerThan(int length) {
    LinkedList newLinkedList  = new LinkedList();
    Node currNode = this.head;
    while(currNode.getNextNode() != null){
      if(currNode.getItem().length() <= length){
        newLinkedList.addNode(currNode.getItem());
      }
      currNode = currNode.getNextNode();
    }
    return newLinkedList;
  }

  /**
   * Checks if the list has duplicated elements.
   * @return True if there is any duplicated element in the list.
   */
  @Override
  public boolean hasDuplicates() {
    ArrayList<String> itemList = new ArrayList(Arrays.asList(""));
    Node currNode = this.head;
    while(true){
      if(itemList.contains(currNode.getItem())){ // need to edit
        return true;
      }else{
        itemList.add(currNode.getItem());
      }
      if(currNode.getNextNode() == null){
        break;
      }
      currNode = currNode.getNextNode();
    }
    return false;
  }

  /**
   * Removes duplicated elements and return a new list.
   * @return a list that does not have any duplicated element in the list.
   */
  @Override
  public LinkedList removeDuplicates() {
    ArrayList<String> itemList = new ArrayList(Arrays.asList(""));
    LinkedList newLinkedList  = new LinkedList();
    Node currNode = this.head;
    while(true){
      if(!itemList.contains(currNode.getItem())){
        itemList.add(currNode.getItem());
        newLinkedList.addNode(currNode.getItem());
      }
      if(currNode.getNextNode() == null){
        break;
      }
      currNode = currNode.getNextNode();
    }
    return newLinkedList;
  }

}
