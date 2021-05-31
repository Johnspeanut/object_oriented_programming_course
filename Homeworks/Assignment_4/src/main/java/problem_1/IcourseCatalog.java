package problem_1;

public interface IcourseCatalog {

  /**
   * Adds a Course to the end of the CourseCatalog.
   * @param course Course to be added.
   */
  public void append(Course course);

  /**
   * Removes a specified course from the CourseCatalog.
   * @param course The course to be moved.
   */
  public void remove(Course course);

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course The course to be checked.
   * @return True if the course exists in the CourseCatalog.
   */
  public boolean contains(Course course);

  /**
   * Checks if the specified course exists in te CourseCatalog.
   * @param course The course to be checked.
   * @return the index of the specified Course in the CourseCatalog. If it exists. If the Course doesn't exist, returns -1.
   */
  public int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of Courses in the CourseCatalog.
   */
  public int count();

  /**
   * Gets the course at the given index.
   * @param index The index.
   * @return the Course at the given index in the CourseCatalog.
   */
  public Course get(int index);

  /**
   * checks if the CourseCatalog is empty.
   * @return true if the CourseCatalog is empty.
   */
  public boolean isEmpty();

}
