package problem2;

/**
 * A class representing a locker with default item null.
 * @author  John Peng
 * @version v1.0
 */
public class Locker {
    private int widthLocker;
    private int heightLocker;
    private int depthLocker;
    private MailItem item = null;

    /**
     * Constructor for the Locker class.
     * @param widthLocker The width of the locker in inches.
     * @param heightLocker The height of the locker in inches.
     * @param depthLocker The depth of the locker in inches.
     * @throws IllegalInchesException if the width, height, or depth are not valid input.
     */
    public Locker(int widthLocker, int heightLocker, int depthLocker) throws IllegalInchesException {
        this.isValidInches(widthLocker);
        this.isValidInches(heightLocker);
        this.isValidInches(depthLocker);
        this.widthLocker = widthLocker;
        this.heightLocker = heightLocker;
        this.depthLocker = depthLocker;
    }

    /**
     * Helper method that checks if width, height, or depth input are valid.
     * @param inches The width,height,or depth input.
     * @throws IllegalInchesException if the width, height, or depth are not valid input.
     */
    private void isValidInches(int inches) throws IllegalInchesException {
        if(inches <= 1){
            throw new IllegalInchesException();
        }
    }

    /**
     * Gets the width of the locker.
     * @return the width of the locker.
     */
    public int getWidthLocker() {
        return widthLocker;
    }

    /**
     * Gets the height of the locker.
     * @return the height of the locker.
     */
    public int getHeightLocker() {
        return heightLocker;
    }

    /**
     * Gets the depth of the locker.
     * @return the depth of the locker.
     */
    public int getDepthLocker() {
        return depthLocker;
    }

    /**
     * Gets the item of the locker.
     * @return the item of the locker.
     */
    public MailItem getItem() {
        return item;
    }

    /**
     * Adds an item into the locker.
     * @param item The item to be added.
     * @throws InvalidItemAddException if the adding failed.
     */
    public void addMail(MailItem item) throws InvalidItemAddException {
        isValidAdd(item);
        this.item = item;
    }

    /**
     * Helper method that checks if an item can be put into the locker.
     * @param item The item to be added.
     * @throws InvalidItemAddException if the adding failed.
     */
    private void isValidAdd(MailItem item) throws InvalidItemAddException {
        if(item.getDepthItem() >= this.depthLocker || item.getHeightItem() >= this.heightLocker ||
                item.getWidthItem() >= this.widthLocker || isOccupied()){
            throw new InvalidItemAddException();
        }
    }

    /**
     * Helper method that checks if the locker is occupied.
     * @return true if the locker is occupied.
     */
    private boolean isOccupied(){
        if(this.item != null){
            return true;
        }
        return false;
    }

    /**
     * Pick up a mail item from the locker if it has a item and recipient name is correct.
     * @param recipient The recipient of the item.
     * @return The item from the locker.
     * @throws InvalidPickupException if picking up fails.
     * @throws IllegalInchesException if item's inches do not match locker's.
     */
    public MailItem pickupMail(Recipient recipient) throws InvalidPickupException, IllegalInchesException {
        if(!this.isOccupied() || !recipient.equals(this.item.getRecipient())){
            throw new InvalidPickupException();
        }
        MailItem tempItem = new MailItem(this.item.getWidthItem(),this.item.getHeightItem(),this.item.getDepthItem(),this.item.getRecipient());
        this.item = null;
        return tempItem;
    }

}
