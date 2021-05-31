package problem_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * An abstract class representing artist.
 * @author  John Peng
 * @version v1.0
 */
public abstract class Artist implements ReceiveAward{
private String name;
private int age;
private String genres;
private ArrayList<String> awards;

  /**
   * Constructor for the artist class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   */
  public Artist(String name, int age, String genres, ArrayList<String> awards) {
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Gets name of the artist.
   * @return name of the artist.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets age of the artist.
   * @return age of the artist.
   */
  public int getAge() {
    return age;
  }

  /**
   * Get genre that the artist falls in.
   * @return the genre name.
   */
  public String getGenres() {
    return genres;
  }

  /**
   * Gets list of awards.
   * @return a list of awards.
   */
  public ArrayList<String> getAwards() {
    return awards;
  }

  /**
   * Adds new award to the award list.
   */
  @Override
  public void receiveAward(String award) {
    this.awards.add(award);
  }

  /**
   * Override toString method.
   * @return String.
   */
  @Override
  public String toString() {
    return "name='" + name + '\'' +
        ", age=" + age +
        ", genres='" + genres + '\'' +
        awards.toString();
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
    if (!(o instanceof Artist)) {
      return false;
    }
    Artist artist = (Artist) o;
    return age == artist.age && Objects.equals(name, artist.name) && Objects
        .equals(genres, artist.genres) && Objects.equals(awards, artist.awards);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, genres, awards);
  }
}
