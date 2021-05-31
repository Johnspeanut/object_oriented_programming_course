package problem1;

import java.util.Objects;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * A class representing priority queue. The class is immutable.
 */
public class PriorityQueue implements IPQ {
  private ILinkedList top;

  /**
   * A private constructor of the priority queue with default of emptyNode.
   */
  private PriorityQueue(){
    this.top = new EmptyNode();
  }

  /**
   * A overloading private constructor.
   * @param element
   */
  private PriorityQueue(ILinkedList element){
    this.top = element;
  }

  /**
   * Public static method to create empty queue.
   * @return a queue with empty node.
   */
  public static PriorityQueue createEmpty(){
    return new PriorityQueue();
  }

  /**
   * Gets the size of the queue.
   * @return the size of the queue.
   */
  @Override
  public Integer size(){
    return this.top.count();
  }

  /**
   * Checks if the queue is empty. Whether it has only empty node.
   * @return true if it only has empty node.
   */
  @Override
  public Boolean isEmpty() {
    return this.top.count().equals(0);
  }

  /**
   * Helper method to insert node.
   *
   */
  private void append(ILinkedList nodeAhead, ILinkedList nodeAfter){
    nodeAhead.setRest(nodeAfter);
  }

  /**
   * Helper method to copy PQ
   * @return
   */
  public PriorityQueue copyPQ(){
    PriorityQueue newPQ;
    if(this.isEmpty()){
      newPQ = new PriorityQueue(new EmptyNode());
    }else{
    ILinkedList cur = this.top.getRest();
    ILinkedList node = new ElementNode(this.top.getPriority(),this.top.getPriorityValue(),null);
    newPQ = new PriorityQueue(node);
    ILinkedList nodeAhead = node;
    while(cur instanceof ILinkedList){
      if(cur instanceof EmptyNode){
        ILinkedList node1 = new EmptyNode();
        append(nodeAhead,node1);
        break; }
        ILinkedList node1 = new ElementNode(cur.getPriority(), cur.getPriorityValue(),
            null);
      append(nodeAhead,node1);
      nodeAhead = node1;
      node1 = null;
    cur =cur.getRest();
    }
    }
    return newPQ;
  }
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
  @Override
  public PriorityQueue add(Integer priority, String value) {
    PriorityQueue newPQ = this.copyPQ();
if(newPQ.isEmpty()){
  newPQ.top = new ElementNode(priority,value,newPQ.top);
}else{
  if(priority > newPQ.top.getPriority()){
    newPQ.top = new ElementNode(priority,value,newPQ.top);
  }else {
    ILinkedList curr = newPQ.top;
    while ((priority < curr.getPriority()|| (priority.equals(curr.getPriority()) && value.compareTo(curr.getPriorityValue()) > 0))
        && !(curr.getRest() instanceof EmptyNode) && (priority < curr.getRest().getPriority())) {
      curr = curr.getRest();
    }
    ILinkedList newAddedNode = new ElementNode(priority, value, curr.getRest());
    curr.setRest(newAddedNode);
  }
}
return newPQ;
  }

  /**
   * Gets value of highest PQ. Taking multiple elements sharing the same priority into account
   * If priority is the same, then priority value is peak by its value alphabetically.
   * @return priority value of highest PQ
   */
  @Override
  public String peak() throws ValueException{
    if(this.isEmpty()){
      throw new ValueException("The PQ is empty");
    }
    return this.top.getPriorityValue();
  }

  /**
   * If priority is equal,pop the element based on its value alphabetically.
   * @return a copy of the PQ without the element with the highest priority.
   */
  @Override
  public PriorityQueue pop() {
    if(this.isEmpty()){
      throw new ValueException("The PQ is empty");
    }
    PriorityQueue newPQ = this.copyPQ();
    newPQ.top = newPQ.top.getRest();
    return newPQ;
  }

  /**
   * Print elements of priority queue.
   */
  public void printPQPriority(){
    ILinkedList curr = this.top;
    while(!(curr instanceof EmptyNode)){
      System.out.println(curr.getPriority() + " " + curr.getPriorityValue() + "\n");
      curr = curr.getRest();
    }
  }

  /**
   * Override equals method.
   * Checks they share them same size and every items are equals in values.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PriorityQueue)) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) o;
    if(!this.size().equals(that.size())){
      return false;
    }
    ILinkedList curr = this.top;
    ILinkedList currO = that.top;
    while(!(curr instanceof EmptyNode)){
      if((!curr.getPriorityValue().equals(currO.getPriorityValue()))|| (!curr.getPriority().equals(currO.getPriority()))){
        return false;
      }
      curr = curr.getRest();
      currO = currO.getRest();
    }
    return true;
  }

  /**
   * Override hashcode method.
   * Compute hashcode value for each element in the priority queue and sum them.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    int value = 0;
    ILinkedList curr = this.top;
    while(curr instanceof ElementNode){
      value += (curr.getPriority().hashCode()  + curr.getPriorityValue().hashCode()) * 31;
      curr = curr.getRest();
    }
    return value;
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    String msg = "PriorityQueue:";
    ILinkedList curr = this.top;
    while(curr instanceof ILinkedList){
      msg += "{priority=" + curr.getPriority() + "; value=" + curr.getPriorityValue() +"}";
      curr = curr.getRest();
    }
    return msg;
}

}
