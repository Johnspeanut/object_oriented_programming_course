package problem2;

/**
 * A class representing a recipient associated with first name, last name, and email.
 * @author  John Peng
 * @version v1.0
 */
public class Recipient {
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructor for the Recipient class.
     * @param firstName The first name associated with the recipient.
     * @param lastName The last name associated with the recipient.
     * @param email The recipient's email.
     */
    public Recipient(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the first name of the recipient.
     * @return The first name of the recipient.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the recipient.
     * @return The last name of the recipient.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the email of the recipient.
     * @return The email of the recipient.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Static method to check if two recipient instances are equals in terms of their values.
     * @param recipientA The first recipient instance.
     * @param recipientB The second recipient instance.
     * @return true if the two recipients share the same values of fields.
     */
    public static boolean assertRecipientEquals(Recipient recipientA, Recipient recipientB){
        if(recipientA.equals(recipientB)){
            return true;
        }
        return false;
    }

    /**
     * Overrides the equals method. The overriding method is to check if a recipient is same as the current object in
     * terms of fields' values.
     * @param obj The object to be compared.
     * @return true if the compared object has the same field values with current object.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Recipient){
            Recipient recipient = (Recipient) obj;
            if(this.firstName.equals(recipient.getFirstName()) &&
            this.lastName.equals(recipient.getLastName()) &&
            this.email.equals(recipient.getEmail())){
                return true;
            }
        }
        return false;
    }
}
