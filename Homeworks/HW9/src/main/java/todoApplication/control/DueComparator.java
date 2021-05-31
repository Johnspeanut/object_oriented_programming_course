package todoApplication.control;


import java.time.LocalDate;
import java.util.Comparator;

public class DueComparator implements Comparator<Todo> {

  /**
   * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer
   * as the first argument is less than, equal to, or greater than the second.<p>
   *
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return a negative integer, zero, or a positive integer as the first argument is less than,
   * equal to, or greater than the second.
   * @throws NullPointerException if an argument is null and this comparator does not permit null
   *                              arguments
   * @throws ClassCastException   if the arguments' types prevent them from being compared by this
   *                              comparator.
   */

  @Override
  public int compare(Todo o1, Todo o2) {
    final LocalDate due1 = o1.getDue();
    final LocalDate due2 = o2.getDue();
    if (due1 == due2) {
      return 0;
    } else if (due1 == null) {
      return 1;
    } else if (due2 == null) {
      return -1;
    } else {
      return due1.compareTo(due2);
    }
  }
}