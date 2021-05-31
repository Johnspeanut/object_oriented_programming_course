/*
 * Represents an Person with his(her) first name and last name.
 * @author
 * */

public class Person {
    private String firstName;
    private String lastName;

    /**
     * Creates a new Person given the person's first name and last name as strings.
     *
     * @param-firstName-the person's first name.
     * @param-lastName-the person's last name.
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
     * @return the first name
     * */
    public String getFirstName() {
        return firstName;
    }

    /*
     * Set first name.
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     * @return the last name
     * */
    public String getLastName() {
        return lastName;
    }

    /*
     * Set the last name.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
