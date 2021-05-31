package todoApplication.control;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

public class DueComparatorTest {
  private final int id1 = 1;
  private final int id2 = 2;
  private final int id3 = 3;
  private final String text1 = "HW 8";
  private final String text2 = "HW 9";
  private final String text3 = "HW 10";
  private final LocalDate due1 = LocalDate.of(2021, 4, 8);
  private final LocalDate due2 = LocalDate.of(2021, 4, 22);
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");
  String due1String = due1.format(formatter);
  String due2String = due2.format(formatter);
  private final Todo todo1 = new Todo.TodoBuilder(text1).addDue(due1String).build();
  private final Todo todo2 = new Todo.TodoBuilder(text2).addDue(due2String).build();
  private final Todo todo3 = new Todo.TodoBuilder(text3).build();
  private DueComparator comparator;

  @Before
  public void setUp() throws Exception {
    comparator = new DueComparator();
  }

  @Test
  public void compare() {
    assertTrue(comparator.compare(todo1, todo1) == 0);
    assertTrue(comparator.compare(todo1, todo3) < 0);
    assertTrue(comparator.compare(todo3, todo2) > 0);
    assertTrue(comparator.compare(todo1, todo2) < 0);
  }
}