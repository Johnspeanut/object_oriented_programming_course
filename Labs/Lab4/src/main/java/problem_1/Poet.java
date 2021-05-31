package problem_1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A concrete class representing poet.
 * @author  John Peng
 * @version v1.0
 */
public class Poet extends Artist{
  private String publishingCompany;
  private String lastPublishedCollection;

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param publishingCompany The publishing company.
   * @param lastPublishedCollection The last published collection of the artist.
   */
  public Poet(String name, int age, String genres, ArrayList<String> awards,
      String publishingCompany, String lastPublishedCollection) {
    super(name, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  /**
   * Gets the publishing company.
   * @return the publishing company.
   */
  public String getPublishingCompany() {
    return publishingCompany;
  }

  /**
   * Gets the last published collection of the artist.
   * @return the last published collection of the artist.
   */
  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  /**
   * Override equals method.
   * @param o Object to be checked.
   * @return True if attributes of two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Poet)) {
      return false;
    }
    Poet poet = (Poet) o;
    return Objects.equals(publishingCompany, poet.publishingCompany) && Objects
        .equals(lastPublishedCollection, poet.lastPublishedCollection) && super.equals(o);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }

  /**
   * Override toString method.
   * @return string that the object presents.
   */
  @Override
  public String toString() {
    return this.getClass() + "," + super.toString() +
        "publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection;
  }
}
