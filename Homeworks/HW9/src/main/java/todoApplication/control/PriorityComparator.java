package todoApplication.control;
import java.util.Comparator;

public class PriorityComparator implements Comparator<Todo> {

  /**
   * Compares two to-dos based on priority (ascending).
   *
   * @return a negative integer, zero, or a positive integer as the first to-do's priority is lower
   * than, equal to, or higher than the second to-do.
   */
  @Override
  public int compare(Todo o1, Todo o2) {
    return -Integer.compare(o2.getPriority(), o1.getPriority());
  }
}