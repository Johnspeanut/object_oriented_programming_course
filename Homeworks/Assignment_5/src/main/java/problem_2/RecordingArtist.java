package problem_2;

import java.util.Objects;

/**
 * A class representing artist
 */
public class RecordingArtist extends Creator{

  /**
   * Constructor for the Artist class object.
   * @param firstName First name of the artist.
   * @param lastName Last name of the artist.
   */
  public RecordingArtist(String firstName, String lastName) {
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
    if (!(o instanceof RecordingArtist)) {
      return false;
    }
    RecordingArtist that = (RecordingArtist) o;
    return Objects.equals(firstName, that.firstName) && Objects
        .equals(lastName, that.lastName);
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
    return "RecordingArtist{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
