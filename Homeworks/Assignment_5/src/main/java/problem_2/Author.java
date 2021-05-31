package problem_2;

import java.util.Objects;

/**
 * A class representing Author.
 */
public class Author extends Creator{

  /**
   * Constructor for the Author class object.
   * @param firstName First name of the author.
   * @param lastName Last name of the author.
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Override equals method.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Author)) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(firstName, author.firstName) && Objects
        .equals(lastName, author.lastName);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
