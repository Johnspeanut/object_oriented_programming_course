package problem_1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * An abstract class representing actors, dancers, and filmmakers.
 * @author  John Peng
 * @version v1.0
 */
public abstract class ActorsDancersFilmmakers extends Artist {
  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param series A list of series that the artist involved in.
   * @param otherMultimedia A list of other multimedia that the artist involved in.
   */
  public ActorsDancersFilmmakers(String name, int age, String genres, ArrayList<String> awards,
      ArrayList<String> movies, ArrayList<String> series, ArrayList<String> otherMultimedia) {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  /**
   * Adds a new movie to the movie list.
   * @param movie A new movie to be added.
   */
  public void addMovies(String movie){
    this.movies.add(movie);
}

  /**
   * Adds a new series to the series list.
   * @param series A new series to be added.
   */
  public void addSeries(String series){
    this.series.add(series);
  }

  /**
   * Adds a another multimedia to the multimedia list.
   * @param otherMultimedia A new multimedia to be added.
   */
  public void addOtherMultimedia(String otherMultimedia){
    this.otherMultimedia.add(otherMultimedia);
  }

  /**
   * Gets a list of movies that the artist involved in.
   * @return a list of movies that the artist involved in.
   */
  public ArrayList<String> getMovies() {
    return movies;
  }

  /**
   * Gets a list of series that the artist involved in.
   * @return a list of series that the artist involved in.
   */
  public ArrayList<String> getSeries() {
    return series;
  }

  /**
   * Gets a list of other multimedia that the artist involved in.
   * @return a list of other multimedia that the artist involved in.
   */
  public ArrayList<String> getOtherMultimedia() {
    return otherMultimedia;
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
    if (!(o instanceof ActorsDancersFilmmakers)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ActorsDancersFilmmakers that = (ActorsDancersFilmmakers) o;
    return Objects.equals(movies, that.movies) && Objects
        .equals(series, that.series) && Objects
        .equals(otherMultimedia, that.otherMultimedia) && super.equals(o);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), movies, series, otherMultimedia);
  }
}
