package problem2;

/**
 * A custom exception class representing invalid picking up from a locker.
 * @author John Peng
 * @version v1.0
 */
public class InvalidPickupException extends Exception{
    public InvalidPickupException(){
        super("Invalid pick up");
    }
}
