package problem_2;

import java.util.Objects;

/**
 * A abstract class representing creator.
 */
public abstract class Creator {
   String firstName;
   String lastName;

  /**
   * Constructor of the creator
   * @param firstName First name of the creator.
   * @param lastName Last name of the creator.
   */
  public Creator(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name of the creator.
   * @return the first name of the creator.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name of the creator.
   * @return the last name of the creator.
   */
  public String getLastName() {
    return lastName;
  }

}
