package problem_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An abstract class representing photographers.
 * @author  John Peng
 * @version v1.0
 */
public class Photographers extends PaintersPhotographers{

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param exhibits  The array list of exhibits.
   */
  public Photographers(String name, int age, String genres, ArrayList<String> awards,
      ArrayList<String> exhibits) {
    super(name, age, genres, awards, exhibits);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public String toString() {
    return this.getClass() + "," + super.toString() +
        ",exhibits=" + this.getExhibits().toString();
  }
}
