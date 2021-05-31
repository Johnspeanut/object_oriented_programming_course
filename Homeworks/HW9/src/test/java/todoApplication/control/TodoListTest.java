package todoApplication.control;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class TodoListTest {
  private final int id1 = 1;
  private final int id2 = 2;
  private final int id3 = 3;
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
  TodoList todoList;
  TodoList todoList2;

  @Before
  public void setUp() throws Exception {
    todo1 = new Todo.TodoBuilder(text1).addCompleted(isCompleted).addDue(due1String).addId(id1)
        .addCategory(category).build();
    todo2 = new Todo.TodoBuilder(text2).addDue(due2String).addPriority(priority1).addId(id2)
        .addCategory(category).build();
    todo3 = new Todo.TodoBuilder(text3).addCompleted(notCompleted).addPriority(priority2).addId(id3)
        .addCategory("Not what we want").build();
    todoList = new TodoList();
    todoList.addTodo(todo1);
    todoList.addTodo(todo2);
    todoList.addTodo(todo3);

    todoList2 = new TodoList();
    todoList2.addTodo(todo1);
    todoList2.addTodo(todo2);
  }

  @Test
  public void getHEADER() {
    assertEquals("\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"\n",
        todoList.getHEADER());
  }

  @Test
  public void getList() {
      assertEquals(todoList.getList(), todoList.getList());
  }

  @Test
  public void addTodo() {
      int answer = todoList.getList().size();
    todoList.addTodo(todo2);
      assertEquals(answer + 1, todoList.getList().size());
    }


  @Test
  public void completeTodo() {
    todoList.completeTodo("3");
    for (Todo todo : todoList.getList()) {
      if (todo.getId() == 3) {
        assertTrue(todo.isCompleted());
      }
    }
  }


  @Test
  public void getTodoList() {
    assertEquals(3, todoList.getTodoList().size());
  }

  @Test
  public void filterByInComplete() {
    final ArrayList<Todo> result = new ArrayList<>(Arrays.asList(todo2, todo3));
    assertEquals(result, todoList.filterByInComplete(todoList.getTodoList()));
  }

  @Test
  public void filterByCategory() {
    final ArrayList<Todo> result = new ArrayList<>(Arrays.asList(todo1, todo2));
    assertEquals(result, todoList.filterByCategory(todoList.getTodoList(), category));
  }

  @Test
  public void sortByDueDate() {
    final ArrayList<Todo> result = new ArrayList<>(Arrays.asList(todo1, todo2));
    assertEquals(result, todoList.sortByDueDate(result));
  }

  @Test
  public void sortByPriority() {
    final ArrayList<Todo> result = new ArrayList<>(Arrays.asList(todo1, todo3, todo2));
    assertEquals(result, todoList.sortByPriority(result));
  }


  @Test
  public void testEquals() {
    final TodoList nil = null;
    final TodoList todoListC = new TodoList();
    final TodoList todoListCC = new TodoList();
    final TodoList todoList2 = new TodoList();
    todoList2.addTodo(todo1);
    todoList2.addTodo(todo2);
    todoList2.addTodo(todo3);

    assertTrue(todoList.equals(todoList2));
    assertFalse(todoList.equals(todoListC));
    assertTrue(todoListCC.equals(todoListC) && todoListC.equals(todoListCC));
    assertFalse(todoList.equals(nil));
  }

  @Test
  public void testHashCode() {
    final int result = todoList.hashCode();
    final TodoList todoListC = new TodoList();
    assertEquals(result, todoList.hashCode());
    assertEquals(0, todoListC.hashCode());
  }

  @Test
  public void testToString() {
    final String result = "TodoList{list=[Todo{id=1, text=HW 8, isCompleted=true, due=2021-04-08, priority=3, category=CS5004 HW}, Todo{id=2, text=HW 9, isCompleted=false, due=2021-04-22, priority=1, category=CS5004 HW}, Todo{id=3, text=Lab 9, isCompleted=false, due=null, priority=2, category=Not what we want}]}";
    assertEquals(result, todoList.toString());
  }
}