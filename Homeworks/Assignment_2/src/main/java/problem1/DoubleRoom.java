package problem1;

/**
 * A class representing double room with max occupancy default of 2.
 * @author John Peng
 * @version v1.0
 */
public class DoubleRoom extends Room{

    /**
     * Constructor for DoubleRoom class.
     * @param price The price associated with double room.
     * @throws IllegalPriceException if the price input is invalid.
     */
    public DoubleRoom(float price) throws IllegalPriceException {
        super(price);
        super.maxOccupancy = 2;
    }
}
