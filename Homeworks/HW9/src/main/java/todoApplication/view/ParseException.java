package todoApplication.view;

/**
 * Base for Exceptions thrown during parsing of a command-line.
 */
public class ParseException extends Exception{

  /**
   * Construct a new ParseException with the specified detail message.
   * @param message the detail message.
   */
  public ParseException(String message){
    super(message);
  }
}
