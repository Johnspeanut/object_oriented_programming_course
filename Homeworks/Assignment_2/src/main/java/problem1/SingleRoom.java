package problem1;

/**
 * A class representing single room with max occupancy default of 1.
 * @author John Peng
 * @version v1.0
 */
public class SingleRoom extends Room{
    /**
     * Constructor for single room class.
     * @param price The price associated with the single room.
     * @throws IllegalPriceException if the price is not valid.
     */
    public SingleRoom(float price) throws IllegalPriceException {
        super(price);
        super.maxOccupancy = 1;
    }
}
