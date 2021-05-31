package problem_2;

import java.util.Locale;
import java.util.Objects;

/**
 * A class representing book.
 */
public class Book implements ILibrary{
  private Author author;
  private String title;
  private int year;

  /**
   * Constructor for the book.
   * @param author Author of the book.
   * @param title Title of the book.
   * @param year The published year.
   */
  public Book(Author author, String title, int year) {
    this.author = author;
    this.title = title;
    this.year = year;
  }

  /**
   * Gets the author of the book.
   * @return the author of the book
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * Gets released year.
   * @return released year.
   */
  public int getYear() {
    return year;
  }

  /**
   * Check if a book title has a keyword.
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
   * Check if book has the author.
   * @param author The book to be checked.
   * @return true if it has. Otherwise, false.
   */
  @Override
  public boolean search(Author author) {
    if(this.author.equals(author)){
      return true;
    }
    return false;
  }

  /**
   * Check if book has the artist.
   * @param artist The artist to be checked.
   * @return false always cause book never has artist.
   */
  @Override
  public boolean search(RecordingArtist artist) {
    return false;
  }


  /**
   * Gets the title name of the music.
   * This method need to be used in Catalog. So it is override ILibrary interface method.
   * @return title of the music.
   */
  @Override
  public String getTitle() {
    return title;
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
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return year == book.year && Objects.equals(author, book.author) && Objects
        .equals(title, book.title);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(author, title, year);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Book{" +
        "author=" + author +
        ", title='" + title + '\'' +
        ", year=" + year +
        '}';
  }
}
