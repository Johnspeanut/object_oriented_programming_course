package problem1;

/**
 * A custom exception class representing invalid price.
 * @author John Peng
 * @version v1.0
 */
public class IllegalPriceException extends Exception{
    public IllegalPriceException(){
        super("Invalid price exception");
    }
}
