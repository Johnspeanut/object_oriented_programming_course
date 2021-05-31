package problem2;

/**
 * A class representing a mail item.
 * @author  John Peng
 * @version v1.0
 */
public class MailItem {
    private int widthItem;
    private int heightItem;
    private int depthItem;
    private Recipient recipient;

    /**
     * Constructor for the MailItem class.
     * @param widthItem The width of the item in inches.
     * @param heightItem The height of the item in inches.
     * @param depthItem The depth of the item in inches.
     * @param recipient The recipient of the item.
     * @throws IllegalInchesException if the width, height, or depth are not valid input.
     */
    public MailItem(int widthItem, int heightItem, int depthItem, Recipient recipient) throws IllegalInchesException {
        this.isValidInches(widthItem);
        this.isValidInches(heightItem);
        this.isValidInches(depthItem);
        this.widthItem = widthItem;
        this.heightItem = heightItem;
        this.depthItem = depthItem;
        this.recipient = recipient;
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
     * Gets the width of the item.
     * @return the width of the item.
     */
    public int getWidthItem() {
        return widthItem;
    }

    /**
     * Gets the height of the item.
     * @return the height of the item.
     */
    public int getHeightItem() {
        return heightItem;
    }

    /**
     * Gets the depth of the item.
     * @return the depth of the item.
     */
    public int getDepthItem() {
        return depthItem;
    }

    /**
     * Gets the recipient of the item.
     * @return the recipient of the item.
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * Static method that checks if two items are equals in terms of their attributes.
     * @param itemA The first item instance.
     * @param itemB The second item instance.
     * @return true if the two items share the same attribute values.
     */
    public static boolean assertItemEquals(MailItem itemA, MailItem itemB){
        if(itemA.equals(itemB)){
            return true;
        }
        return false;
    }

    /**
     * Overrides the equals method. The overriding method is to check if a item is same as the current item in
     * terms of field values.
     * @param obj The object to be compared.
     * @return true if the compared object has the same field values with current object.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof MailItem){
            MailItem mailItem = (MailItem) obj;
            if(this.widthItem == mailItem.getWidthItem() &&
                    this.heightItem == mailItem.getHeightItem() &&
            this.depthItem == mailItem.getDepthItem() &&
                    this.recipient.equals(mailItem.getRecipient())){
                return true;
            }
        }
        return false;
    }
}
