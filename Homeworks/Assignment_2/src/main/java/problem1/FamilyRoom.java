package problem1;

/**
 * A class representing family room with max occupancy of 4.
 * @author John Peng
 * @version v1.0
 */
public class FamilyRoom extends Room{

    /**
     * Constructor for FamilyRoom class.
     * @param price The price associated with the family room.
     * @throws IllegalPriceException if the price input is invalid.
     */
    public FamilyRoom(float price) throws IllegalPriceException {
        super(price);
        super.maxOccupancy = 4;
    }
}
