package problem1;

/**
 * A custom exception class representing invalid booking.
 * @author John Peng
 * @version v1.0
 */
public class IllegalBookException extends Exception {
    public IllegalBookException(){
        super("Invalid book exception");
    }
}
