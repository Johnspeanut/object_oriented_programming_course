package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import todoApplication.view.CommandLine;
import todoApplication.view.CommandLineParse;
import todoApplication.view.Option;
import todoApplication.view.Options;
import todoApplication.view.ParseException;
import org.junit.Before;
import org.junit.Test;

public class CommandLineTest {
  String[] args = "--csv-file todos.csv --add-todo --todo-text needFinishedInTwoDays --completed --due 3/20/2021 --complete-todo 1 --priority 1 --category emergency --show-incomplete --display --complete-todo 1 --sort-by-priority".split(" ");
  CommandLine cmd;

  @Before
  public void setUp() throws Exception {
    Option csvFileOption = new Option("--csv-file",true,false,null,null,true);
    Option addTodoOption = new Option("--add-todo",false,true,"--todo-text","--csv-file",false);
    Option todoTextOption = new Option("--todo-text",false,false,null,"--add-todo",true);
    Option completedOption = new Option("--completed",false,false,null,"--add-todo",false);
    Option dueOption = new Option("--due",false,false,null,"--add-todo",true);
    Option priorityOption = new Option("--priority",false,false,null,"--add-todo",true);
    Option categoryOption = new Option("--category",false,false,null,"--add-todo",true);
    Option updateCompleteOption = new Option("--complete-todo",false,false,null,"--csv-file",true);
    Option displayOption = new Option("--display",false,true,null,"--csv-file",false);
    Option showIncompleteOption = new Option("--show-incomplete",false,false,null,"--display",false);
    Option showCategoryOption = new Option("--show-category",false,false,null,"--display",true);
    Option sortByDateOption = new Option("--sort-by-date",false,false,null,"--display",false);
    Option sortByPriorityOption = new Option("--sort-by-priority",false,false,null,"--display",false);
    Options options = new Options();
    options.addOption(csvFileOption);
    options.addOption(addTodoOption);
    options.addOption(todoTextOption);
    options.addOption(completedOption);
    options.addOption(dueOption);
    options.addOption(priorityOption);
    options.addOption(categoryOption);
    options.addOption(displayOption);
    options.addOption(updateCompleteOption);
    options.addOption(showIncompleteOption);
    options.addOption(showCategoryOption);
    options.addOption(sortByDateOption);
    options.addOption(sortByPriorityOption);
    CommandLineParse parser = new CommandLineParse();
    cmd = parser.parse(options,args);
  }

  @Test
  public void getFilePath() throws ParseException {
    assertEquals("todos.csv",cmd.getFilePath());
  }

  @Test
  public void isAddTodo() throws ParseException {
    assertTrue(cmd.isAddTodo());
  }

  @Test
  public void todoDescription() throws ParseException {
    assertEquals("needFinishedInTwoDays",cmd.todoDescription());
  }

  @Test
  public void hasCompleted() throws ParseException {
    assertTrue(cmd.hasCompleted());
  }

  @Test
  public void hasDueDate() throws ParseException {
    assertTrue(cmd.hasDueDate());
  }

  @Test
  public void getDueDate() throws ParseException {
    assertEquals("3/20/2021",cmd.getDueDate());
  }

  @Test
  public void hasPriority() throws ParseException {
    assertTrue(cmd.hasPriority());
  }

  @Test
  public void getPriorityValue() throws ParseException {
    assertEquals("1",cmd.getPriorityValue());
  }

  @Test
  public void hasCategory() throws ParseException {
    assertTrue(cmd.hasCategory());
  }

  @Test
  public void getCategoryValue() throws ParseException {
    assertEquals("emergency",cmd.getCategoryValue());
  }

  @Test
  public void hasUpdateTodo() throws ParseException {
    assertTrue(cmd.hasUpdateTodo());
  }

  @Test
  public void getUpdateTodoID() throws ParseException {
    assertEquals("1",cmd.getUpdateTodoID());
  }

  @Test
  public void hasDisplay() throws ParseException {
    assertTrue(cmd.hasDisplay());
  }

  @Test
  public void hasShowIncomplete() throws ParseException {
    assertTrue(cmd.hasShowIncomplete());
  }

  @Test
  public void hasShowCategory() throws ParseException {
    assertFalse(cmd.hasShowCategory());
  }

  @Test
  public void getShowCategoryValue() throws ParseException {
    assertEquals(null,cmd.getShowCategoryValue());
  }

  @Test
  public void hasSortByDate() throws ParseException {
    assertFalse(cmd.hasSortByDate());
  }

  @Test
  public void hasSortByPriority() throws ParseException {
    assertTrue(cmd.hasSortByPriority());
  }

}