package problem_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An abstract class representing filmmakers.
 * @author  John Peng
 * @version v1.0
 */
public class Filmmakers extends ActorsDancersFilmmakers{

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param series A list of series that the artist involved in.
   * @param otherMultimedia A list of other multimedia that the artist involved in.
   */
  public Filmmakers(String name, int age, String genres, ArrayList<String> awards,
      ArrayList<String> movies, ArrayList<String> series, ArrayList<String> otherMultimedia) {
    super(name, age, genres, awards, movies, series, otherMultimedia);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public String toString() {
    return this.getClass() + "," + super.toString() +
        ",movies=" + super.getMovies().toString() +
        ", series=" + super.getSeries().toString() +
        ", otherMultimedia=" + super.getOtherMultimedia().toString();
  }
}
