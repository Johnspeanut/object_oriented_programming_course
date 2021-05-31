package problem2;

/**
 * A class representing BagOfWords.
 */
public class BagOfWords implements IBag{
  private IList top;

  /**
   * A private constructor for BagOfWords.
   */
  private BagOfWords(){
    this.top = new EmpNode();
  }

  /**
   * An overloading private constructor for BagOfwords.
   * @param node The top node.
   */
  private BagOfWords(IList node){
    this.top = node;
  }

  /**
   * Static method open to public to create empty bag.
   * @return The new empty bag.
   */
  public static BagOfWords emptyBagOfWords(){
    return new BagOfWords();
  }

  /**
   * Gets the top element in the bag.
   * @return The top element.
   */
  public IList getTop() {
    return top;
  }

  /**
   * checks if the BagOfWords is empty.
   * @return true if the BagOfWords contins no times, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.size().equals(0);
  }

  /**
   * Checks the number of elements.
   * @return number of elements in the BagOfwords.Duplicates are counted as separate elements.
   */
  @Override
  public Integer size() {
    return this.top.count();
  }

  /**
   * Create a new BagOfWords that contains all elements in the original BagOfWords plus s.
   * Underlying data structure is linked list. Adding is insert from the front.
   * @param s The new added string.
   * @return A new BagOfWords.
   */
  @Override
  public BagOfWords add(String s) {
    IList newTop;
      newTop = new EleNode(s,this.top);
    return new BagOfWords(newTop);
  }

  /**
   * Checks if the BagOfWords contains s.
   * @param s The string be be checked.
   * @return
   */
  @Override
  public Boolean contains(String s) {
return this.top.contains(s);
  }

  /**
   * Override equals method.
   * Checks they share them same size and items in a bag can be found in another bag.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BagOfWords)) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
    if(!this.size().equals(that.size())){
      return false;
    }
    IList cur = this.top;
    IList curThat = that.top;
    while(!(cur instanceof EmpNode)){
      if(!curThat.contains(cur.getString())){
        return false;
      }
      cur = cur.getRest();
    }
    return true;
  }

  /**
   * Override hashcode method.
   * Compute hashcode value for each element in the bag and sum them.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    int value = 0;
    IList curr = this.top;
    while(curr instanceof EleNode){
      value += curr.getString().hashCode();
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
    return "BagOfWords{" + top.toString() +
        '}';
  }
}










