package problem2;

/**
 * A custom exception class representing failed item add to a locker.
 * @author John Peng
 * @version v1.0
 */
public class InvalidItemAddException extends Exception{
    public InvalidItemAddException(){
        super("Failed item add to the locker");
    }
}
