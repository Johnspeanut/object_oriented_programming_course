package problem1;

/**
 * A class representing a room. Allow set price and max occupancy.
 * @author  John Peng
 * @version v1.0
 */
public class Room {
    public int maxOccupancy = 0;
    private float price;
    private int numGuest = 0;

    /**
     * Constructor for the Room class.
     * @param price The price associated with the room.
     * @throws IllegalPriceException if the price is not valid.
     */
    public Room(float price) throws IllegalPriceException {
        this.isValidPrice(price);
        this.price = price;
    }

    /**
     * Gets the max occupancy of the room.
     * @return The max occupancy of the room.
     */
    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    /**
     * Gets the price of the room.
     * @return The price of the room.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the number of guests in the room.
     * @return the number of guests in the room.
     */
    public int getNumGuest() {
        return numGuest;
    }

    /**
     * Sets the max occupancy of the room.
     * @param maxOccupancy The max occupancy of the room.
     */
    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    /**
     * Helper method that checks if a price is greater than zero.
     * @param price The price to check.
     * @throws IllegalPriceException if the price is invalid.
     */
    private void isValidPrice(float price) throws IllegalPriceException {
        if(price <= 0) {
            throw new IllegalPriceException();
        }
    }

    /**
     * Helper method that checks if a room is available.
     * @return true if there is no guest in the room.Otherwise, false.
     */
    private boolean isAvailable(){
        if(this.numGuest == 0){
            return true;
        }
        return false;
    }

    /**
     * Book room for guests.
     * @param numGuest The number of guests who will be in the room.
     * @throws IllegalBookException if the book is unsuccessful.
     */
    public void bookRoom(int numGuest) throws IllegalBookException {
        isBookValid(numGuest);
        this.numGuest = numGuest;
    }

    /**
     * Helper method that checks if a booking is valid.
     * @param numGuest The number of guest to be check.
     * @throws IllegalBookException if the booking room meets requirements.
     */
    private void isBookValid(int numGuest) throws IllegalBookException {
        if(!this.isAvailable() || numGuest <= 0 || numGuest > this.maxOccupancy){
            throw new IllegalBookException();
        }
    }
}
