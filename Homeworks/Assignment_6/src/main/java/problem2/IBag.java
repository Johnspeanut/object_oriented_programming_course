package problem2;

public interface IBag {

  /**
   * checks if the BagOfWords is empty.
   * @return true if the BagOfWords contins no times, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Checks the number of elements.
   * @return number of elements in the BagOfwords.Duplicates are counted
   * as separate elements.
   */
  Integer size();

  /**
   * Create a new BagOfWords that contains all elements in the original BagOfWords plus s.
   * Underlying data structure is linked list. Adding is insert from the front.
   * @param s The new added string.
   * @return A new BagOfWords.
   */
  BagOfWords add(String s);

  /**
   * Checks if the BagOfWords contains s.
   * @param s The string be be checked.
   * @return
   */
  Boolean contains(String s);

}
