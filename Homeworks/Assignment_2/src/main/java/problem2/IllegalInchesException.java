package problem2;

/**
 * A custom exception class representing invalid input of width, depth,or height.
 * @author John Peng
 * @version v1.0
 */
public class IllegalInchesException extends Exception{
    public IllegalInchesException(){
        super("The width,height, or depth is invalid");
    }
}
