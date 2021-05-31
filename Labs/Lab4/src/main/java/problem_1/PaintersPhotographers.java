package problem_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * An abstract class representing painter, and photographer.
 * @author  John Peng
 * @version v1.0
 */
public abstract class PaintersPhotographers extends Artist{
  private ArrayList<String> exhibits;

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param exhibits The array list of exhibits that the artist invovled in.
   */
  public PaintersPhotographers(String name, int age, String genres, ArrayList<String> awards,
      ArrayList<String> exhibits) {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  /**
   * Gets a list of exhibits that the artist involved in.
   * @return a list of exhibits that the artist involved in.
   */
  public ArrayList<String> getExhibits() {
    return exhibits;
  }

  /**
   * Adds a new exhibit to the list of exhibits.
   * @param exhibit A new exhibit to be added.
   */
  public void addExhibits(String exhibit){
    this.exhibits.add(exhibit);
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
    if (!(o instanceof PaintersPhotographers)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PaintersPhotographers that = (PaintersPhotographers) o;
    return Objects.equals(exhibits, that.exhibits) && super.equals(o);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), exhibits);
  }
}
