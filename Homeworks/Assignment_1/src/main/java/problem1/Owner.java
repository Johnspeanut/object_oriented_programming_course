package problem1;

/**
 * This class represents a owner has first name, last name and phone number.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * Constructor that creates a new owner object.
     * @param firstName - first name of the new Owner object.
     * @param lastName - last name of the new Owner object.
     * @param phoneNumber - phone number of the new Owner object.
     * */

    public Owner(String firstName, String lastName, String phoneNumber){
        if(validPhoneNumber(phoneNumber)){
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Helper method to valid the phone number consisting of ten characters.
     * @param phoneNumber - hour of the new Time object.
     * @return true if inputs are valid.
     * */
    private boolean validPhoneNumber(String phoneNumber){
        if(phoneNumber.length() == 10){
            return true;
        }
        return false;
    }
    /**
     * Get the first name of this Owner.
     * @return the first name of the Owner.
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the last name of the Owner.
     * @return the last name of the Owner.
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return the phone number of the Owner.
     * @return the phone number of the Owner.
     * */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the first name of the owner.
     * @param firstName - set first name of this owner.
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the owner.
     * @param lastName- set last name of this owner.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the phone number of the owner.
     * @param phoneNumber- set phone number of this owner.
     * */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
