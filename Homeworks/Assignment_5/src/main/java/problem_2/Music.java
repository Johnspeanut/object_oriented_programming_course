package problem_2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing Music
 */
public class Music implements ILibrary{
  private String bandName = null;
  private ArrayList<RecordingArtist> recordingArtists = new ArrayList<RecordingArtist>();
  private String title;
  private int year;

  /**
   * Creates two constructors for the class. Users could input band name and a collection of members or just a artist or artists.
   * If there is only one artist, then the collection of artists contains just one member. In this case,
   * band name is null.
   * @param recordingArtists A collection of artists.
   * @param title The music title.
   * @param year The released year.
   */
  public Music(ArrayList<RecordingArtist> recordingArtists, String title, int year) {
    this.recordingArtists = recordingArtists;
    this.title = title;
    this.year = year;
  }

  /**
   * Overload constructor.This time we have a addtional parameter, band name.
   * @param bandName Band name.
   * @param recordingArtists A collection of artists.
   * @param title The music title.
   * @param year The released year.
   */
  public Music(String bandName, ArrayList<RecordingArtist> recordingArtists, String title,
      int year) {
    this.bandName = bandName;
    this.recordingArtists = recordingArtists;
    this.title = title;
    this.year = year;
  }

  /**
   * Gets band name if it has.
   * @return Reture band name or null.
   */
  public String getBandName() {
    return bandName;
  }

  /**
   * Gets a collection of artists.
   * @return a collection of artists.
   */
  public ArrayList<RecordingArtist> getRecordingArtists() {
    return recordingArtists;
  }

  /**
   * Gets released year.
   * @return released year.
   */
  public int getYear() {
    return year;
  }

  /**
   * Check if a music title has a keyword.
   * @param keyword A keyword to be checked.
   * @return true if it has.
   */
  @Override
  public boolean search(String keyword) {
    if(title.toLowerCase().indexOf(keyword.toLowerCase()) != -1){
      return true;
    }
    return false;
  }

  /**
   * Check if music has the author.
   * @param author The author to be checked.
   * @return false always cause the object is music.
   */
  @Override
  public boolean search(Author author) {
    return false;
  }

  /**
   * Check if music has the artist.
   * @param artist The author to be checked.
   * @return true if it has. Otherwise, false.
   */
  @Override
  public boolean search(RecordingArtist artist) {
    if(this.recordingArtists.isEmpty()){
      return false;
    }
    for(RecordingArtist element:this.recordingArtists){
      if(element.equals(artist)){
        return true;
      }
    }
    return false;
  }

  /**
   * Gets the title name of the music.
   * This method need to be used in Catalog. So it is override ILibrary interface method.
   * @return title of the music.
   */
  @Override
  public String getTitle() {
    return this.title;
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
    if (!(o instanceof Music)) {
      return false;
    }
    Music music = (Music) o;
    return year == music.year && Objects.equals(bandName, music.bandName)
        && Objects.equals(recordingArtists, music.recordingArtists) && Objects
        .equals(title, music.title);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(bandName, recordingArtists, title, year);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Music{" +
        "bandName='" + bandName + '\'' +
        ", recordingArtists=" + recordingArtists +
        ", title='" + title + '\'' +
        ", year=" + year +
        '}';
  }
}
