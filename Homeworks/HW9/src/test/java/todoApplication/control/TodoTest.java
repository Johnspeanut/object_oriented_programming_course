package todoApplication.control;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
  private final String id1 = "1";
  private final String id2 = "2";
  private final String id3 = "3";
  private final String text1 = "HW 8";
  private final String text2 = "HW 9";
  private final String text3 = "Lab 9";
  private final boolean isCompleted = true;
  private final boolean notCompleted = false;
  private final LocalDate due1 = LocalDate.of(2021, 4, 8);
  private final LocalDate due2 = LocalDate.of(2021, 4, 22);
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");
  String due1String = due1.format(formatter);
  String due2String = due2.format(formatter);
  private final String priority1 = "1";
  private final String priority2 = "2";
  private final String priority3 = "3";
  private final String lowerPriority = "0";
  private final String higherPriority = "4";
  private final String category = "CS5004 HW";
  private Todo todo1;
  private Todo todo2;
  private Todo todo3;

  @Before
  public void setUp() throws Exception {
    todo1 = new Todo.TodoBuilder(text1).addCompleted(isCompleted).addDue(due1String)
        .addCategory(category).build();
    todo2 = new Todo.TodoBuilder(text2).addDue(due2String).addPriority(priority1)
        .addCategory(category).build();
    todo3 = new Todo.TodoBuilder(text3).addCompleted(notCompleted).addPriority(priority2)
        .build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void withLowerPriority() throws IllegalArgumentException {
    Todo todo = new Todo.TodoBuilder(text1).addPriority(lowerPriority).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void withHigherPriority() throws IllegalArgumentException {
    Todo todo = new Todo.TodoBuilder(text1).addPriority(higherPriority).build();
  }

  @Test
  public void setId() {
    todo1.setId(2);
    assertEquals(2,todo1.getId());
  }

  @Test
  public void setCompleted() {
    todo2.setCompleted();
    assertTrue(todo2.isCompleted());
  }

  @Test
  public void getId() {
    assertEquals(0, todo1.getId());
  }

  @Test
  public void getText() {
    assertEquals(text1, todo1.getText());
    assertEquals(text2, todo2.getText());
    assertEquals(text3, todo3.getText());
  }

  @Test
  public void isCompleted() {
    assertTrue(todo1.isCompleted());
    assertFalse(todo2.isCompleted());
    assertFalse(todo3.isCompleted());
  }

  @Test
  public void getDue() {
    assertEquals(due1, todo1.getDue());
    assertEquals(due2, todo2.getDue());
    assertNull(todo3.getDue());
  }

  @Test
  public void getPriority() {
    assertEquals(3, todo1.getPriority());
    assertEquals(1, todo2.getPriority());
    assertEquals(2, todo3.getPriority());
  }

  @Test
  public void getCategory() {
    assertEquals(category, todo1.getCategory());
    assertEquals(category, todo2.getCategory());
    assertNull(todo3.getCategory());
  }

  @Test
  public void testSetCompleted() {
    todo2.setCompleted();
    assertTrue(todo2.isCompleted());
  }

  @Test
  public void toFormattedString() {
    final String result = "\"0\",\"HW 8\",\"true\",\"2021-04-08\",\"3\",\"CS5004 HW\"";
    assertEquals(result, todo1.toFormattedString());
  }

  @Test
  public void testEquals() {
    final Todo nil = null;
    final Todo todo3C = new Todo.TodoBuilder(text3).addCompleted(notCompleted)
        .addPriority(priority2).build();
    final Todo todo3CC = new Todo.TodoBuilder(text3).addCompleted(notCompleted)
        .addPriority(priority2).build();
    final Todo todo4 = new Todo.TodoBuilder(text2).addCompleted(notCompleted)
        .addPriority(priority2).build();
    final Todo todo5 = new Todo.TodoBuilder(text3).addCompleted(isCompleted)
        .addPriority(priority2).build();
    final Todo todo6 = new Todo.TodoBuilder(text3).addCompleted(notCompleted).addDue(due2String)
        .addPriority(priority2).build();
    final Todo todo7 = new Todo.TodoBuilder(text3).addCompleted(notCompleted)
        .addPriority(priority1).build();
    final Todo todo8 = new Todo.TodoBuilder(text3).addCompleted(notCompleted)
        .addPriority(priority2).addCategory(category).build();
    assertTrue(todo3.equals(todo3));
    assertTrue(todo3.equals(todo3C) && todo3C.equals(todo3));
    assertTrue(todo3.equals(todo3C) && todo3C.equals(todo3CC) && todo3CC.equals(todo3));
    assertFalse(todo3.equals(nil));
    assertFalse(todo3.equals(text3));
    assertFalse(todo3.equals(todo2));
    assertFalse(todo3.equals(todo4));
    assertFalse(todo3.equals(todo5));
    assertFalse(todo3.equals(todo6));
    assertFalse(todo3.equals(todo7));
    assertFalse(todo3.equals(todo8));
  }

  @Test
  public void testHashCode() {
    final int result = todo2.hashCode();
    final Todo todo2C = new Todo.TodoBuilder(text2).addDue(due2String).addPriority(priority1)
        .addCategory(category).build();
    assertEquals(result, todo2.hashCode());
    assertEquals(result, todo2C.hashCode());
  }

  @Test
  public void testToString() {
    final String result = "Todo{id=0, text=HW 9, isCompleted=false, due=2021-04-22, priority=1, category=CS5004 HW}";
    assertEquals(result, todo2.toString());
  }

}