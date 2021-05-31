package problem3;

/**
 * A class to contain string processing results.
 */
public class StringResultPack {
    private String originalString;
    private String refactoredString;
    private Integer numberReplaced;

  /**
   * constructor
   */
  public StringResultPack() {
  }

  /**
   * Overloading constructor
   * @param originalString original string
   * @param refactoredString refactored string
   * @param numberReplaced number of replacement happened.
   */
  public StringResultPack(String originalString, String refactoredString,
        Integer numberReplaced) {
      this.originalString = originalString;
      this.refactoredString = refactoredString;
      this.numberReplaced = numberReplaced;
    }
}
