package problem_2;

/**
 * An interface that makes items sharing following behaviors and can override based on
 * their subtypes.
 */
public interface ILibrary {

  /**
   * Search based on items' keywords.
   * @param keyword The keyword.
   * @return true if it has.
   */
  public boolean search(String keyword);

  /**
   * Search based on items' author
   * @param author The author.
   * @return true if it has.
   */
  public boolean search(Author author);

  /**
   * Search based on items' artist.
   * @param artist An artist of the item.
   * @return true if it has.
   */
  public boolean search(RecordingArtist artist);

  /**
   * Gets title of the item. This method is for search title for Catalog.
   * @return name of the title.
   */
  public String getTitle();

}
