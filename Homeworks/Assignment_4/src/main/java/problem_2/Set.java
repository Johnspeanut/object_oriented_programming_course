package problem_2;

import java.util.Arrays;
import java.util.Objects;

/**
 * A class representing Set implements ADT methods.
 */
public class Set implements ISet{
  Integer[] set;
  int numItems;

  /**
   * constructor for the Set class. Default slots are 10.
   */
  public Set() {
    set = new Integer[10]; // with default slots of ten.
    numItems = 0;
  }

  /**
   * Creates and returns an empty Set.
   */
  @Override
  public Set emptySet() {
    return new Set();
  }

  /**
   * Checks if the Set is empty.
   * @return true if the Set contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return numItems == 0;
  }

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n An Integer object.
   * @return A Set having Integer n object.
   */
  @Override
  public Set add(Integer n) {
    if(this.contains(n)){
      return this;
    }else{
      if(this.numItems == this.set.length - 1 ){
        this.resize();
      }
this.set[this.numItems] = n;
      this.numItems ++;
      return this;
    }
  }

  /**
   * Helper method to resize the set. The new length of the set is 2 times than pre-resize one.
   */
  private void resize(){
    Integer[] newSet = new Integer[this.set.length * 2];
    int i = 0;
    for(Integer element:this.set){
      newSet[i] = element;
      i++;
    }
    this.set = newSet;
  }

  /**
   * Check if the Set contains n object.
   * @param n The Integer object.
   * @return true if the given Integer is in the Set, false otherwise.
   */
  @Override
  public Boolean contains(Integer n) {
    for(int i = 0; i < this.numItems; i++){
      if(n.equals(this.set[i])){
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * Remove the Integer object.
   * @param n The Integer object.
   * @return a copy of the Set with the given Integer removed.If the given Integer is not in the
   * Set, returns the Set as it.
   */
  @Override
  public Set remove(Integer n) {
    if(this.contains(n)){
      Set newSet = new Set();
      for(int i = 0; i < this.numItems; i++){
        if(!this.set[i].equals(n)){
          newSet.add(this.set[i]);
        }
      }
      return newSet;
    }else{
      return this;
    }
  }

  /**
   * Gets the number of items in the Set.
   * @return the number of items in the Set.
   */
  @Override
  public Integer size() {
    return this.numItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set1 = (Set) o;
    return numItems == set1.numItems && Arrays.equals(set, set1.set);
  }

  /**
   * Override the hashcode method.
   * @return true if two nodes have the same hashcode.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(numItems);
    result = 31 * result + Arrays.hashCode(set);
    return result;
  }

  /**
   * Override the toString method.
   * @return true if two nodes have the same strings.
   */
  @Override
  public String toString() {
    return "Set{" +
        "set=" + Arrays.toString(set) +
        ", numItems=" + numItems +
        '}';
  }
}
