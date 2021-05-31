package problem2_recursiveSet;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Set implements ISet {
  private ILinkedList top;

  private Set(){
    this.top = new EmptyNode();
  }

  private Set(ILinkedList element){
    this.top = element;
  }

  public static Set emptySet(){
    return new Set();
  }

  @Override
  public boolean isEmpty() {
return this.size().equals(0);
  }

  @Override
  public ISet add(Integer item) {
    if(this.contains(item)){
      return this;
    }
  ILinkedList element = new ElementNode(item, this.top);
  return new Set(element);
}


  @Override
  public boolean contains(Integer item) {
    return this.top.contains(item);
  }

  @Override
  public ISet remove(Integer item) {
    if(this.contains(item)){
      Set newSet = Set.emptySet();
      if(this.top.getItem().equals(item)){
        newSet.top = this.top.getRest();
      }else{
        ILinkedList curNode = this.top;
        while(!curNode.isEmpty()){
          if(curNode.getItem().equals(item)){
            newSet.add(curNode.getItem());
          }
          curNode = curNode.getRest();
        }
      }
      return newSet;
    }else{
      throw new ValueException("The item is not in the set");
    }
  }

  @Override
  public Integer size() {
    return this.top.count();
  }
}
