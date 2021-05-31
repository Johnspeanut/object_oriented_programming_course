package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {
  BagOfWords bagOfWordsEmpty;
  BagOfWords bagOfWords;
  BagOfWords bagOfWordsCopy;
  BagOfWords bagOfWordsVary;
  String word1 = "John";
  String word2 = "likes";
  String word3 = "Tom";

  @Before
  public void setUp() throws Exception {
    bagOfWordsEmpty = BagOfWords.emptyBagOfWords();
    bagOfWords = bagOfWordsEmpty.add(word1);
    bagOfWordsCopy = bagOfWordsEmpty.add(word1);
  }

  @Test
  public void getTop() {
    assertTrue(bagOfWords.getTop().equals(new EleNode(word1,new EmpNode())));
  }

  @Test
  public void isEmpty() {
    assertTrue(bagOfWordsEmpty.isEmpty());
    assertFalse(bagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertTrue(bagOfWordsEmpty.size().equals(0));
    assertTrue(bagOfWords.size().equals(1));
  }

  @Test
  public void add() {
    bagOfWordsVary = bagOfWordsEmpty.add(word1);
    assertTrue(bagOfWordsVary.getTop().getString().equals(word1));
  }

  @Test
  public void contains() {
    bagOfWordsVary = bagOfWordsEmpty.add(word3);
    assertTrue(bagOfWordsVary.contains(word3));
    assertFalse(bagOfWordsVary.contains(word2));
  }

  @Test
  public void testEquals() {
    bagOfWordsVary = bagOfWordsEmpty.add(word3);
    assertTrue(bagOfWords.equals(bagOfWords));
    assertTrue(bagOfWords.equals(bagOfWordsCopy));
    assertFalse(bagOfWords.equals(bagOfWordsVary));
    assertFalse(bagOfWords.equals(null));
    assertFalse(bagOfWords.equals(""));
  }

  @Test
  public void testHashCode() {
    bagOfWordsVary = bagOfWordsEmpty.add(word3);
    assertTrue(bagOfWords.hashCode() == bagOfWordsCopy.hashCode());
    assertFalse(bagOfWords.hashCode() == bagOfWordsVary.hashCode());
  }

  @Test
  public void testToString() {
    bagOfWordsVary = bagOfWordsEmpty.add(word3);
    assertTrue(bagOfWords.toString().equals(bagOfWordsCopy.toString()));
    assertFalse(bagOfWords.toString().equals(bagOfWordsVary.toString()));
  }
}