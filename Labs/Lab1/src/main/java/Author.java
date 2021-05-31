/*
* Represents an Author with their details--Person, email and physical address
* @author
* */

public class Author {
    private Person person;
    private String email;
    private String address;

    /**
     * Creates a new author given the author's name, email and address as strings.
     *
     * @param-name-the author's name
     * @param-email-the author's email address
     * @param-address-the authors physical address
     */
    public Author(Person person, String email, String address){
        this.person = person;
        this.email = email;
        this.address = address;
    }

    /*
    * @return the Person
    * */
    public Person getPerson(){
        return this.person;
    }

    /*
     * @return the email
     * */
    public String getEmail(){
        return this.email;
    }

    /*
     * @return the address
     * */
    public String getAddress(){
        return this.address;
    }


}
