package problem_1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A concrete class representing musician.
 * @author  John Peng
 * @version v1.0
 */
public class Musician extends Artist{
  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Constructor for the class.
   * @param name Name of the artist.
   * @param age Age of the artist.
   * @param genres Genre that the artist falls in.
   * @param awards The array list including awards.
   * @param recordingCompany The recording company.
   * @param lastRecordAlbum The last record album name.
   */
  public Musician(String name, int age, String genres, ArrayList<String> awards,
      String recordingCompany, String lastRecordAlbum) {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  /**
   * Gets the name of recording company.
   * @return the name of the recording company.
   */
  public String getRecordingCompany() {
    return recordingCompany;
  }

  /**
   * Gets the last record album.
   * @return the last record album.
   */
  public String getLastRecordAlbum() {
    return lastRecordAlbum;
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
    if (!(o instanceof Musician)) {
      return false;
    }
    Musician musician = (Musician) o;
    return Objects.equals(recordingCompany, musician.recordingCompany) && Objects
        .equals(lastRecordAlbum, musician.lastRecordAlbum) && super.equals(o);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCompany, lastRecordAlbum);
  }

  /**
   * Override toString method.
   * @return string that the object presents.
   */
  @Override
  public String toString() {
    return this.getClass() + "," + super.toString() +
        "recordingCompany='" + recordingCompany + '\'' +
        ", lastRecordAlbum='" + lastRecordAlbum;
  }
}
