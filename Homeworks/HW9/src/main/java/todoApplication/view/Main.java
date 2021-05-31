package todoApplication.view;

import todoApplication.control.Todo;
import todoApplication.control.Todo.TodoBuilder;
import todoApplication.control.TodoList;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws Exception {
    // String[] args = "--csv-file todos.csv --add-todo --todo-text needFinishedInTwoDays --completed --due 3/20/2021 --complete-todo 1 --priority 1 --category emergency --show-incomplete --display --sort-by-priority".split(" ");
    /**
     * Create option for every possible command line
     */
//    System.out.println(System.getProperty("user.dir"));
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
    /**
     * Add options to the option list
     */
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
    /**
     * Parse the command line
     */
    CommandLineParse parser = new CommandLineParse();
    CommandLine cmd = parser.parse(options,args);

    TodoList todoList = new TodoList(cmd.getFilePath());
    /**
     * Add a new Todo
     */
    if(cmd.isAddTodo()){
      TodoBuilder newTodoBuilder = new TodoBuilder(cmd.todoDescription());
      if(cmd.hasCompleted()){
        newTodoBuilder.addCompleted(true);
      }
      if(cmd.hasDueDate()){
        newTodoBuilder.addDue(cmd.getDueDate());
      }
      if(cmd.hasPriority()){
        newTodoBuilder.addPriority(cmd.getPriorityValue());
      }
      if(cmd.hasCategory()){
        newTodoBuilder.addCategory(cmd.getCategoryValue());
      }
      // update the id
      Todo newTodo = newTodoBuilder.build();
      newTodo.setId(todoList.getTodoList().size() + 1);
      todoList.addTodo(newTodo,cmd.getFilePath());
    }
    /**
     * Update complete todo status based on id
     */
    if(cmd.hasUpdateTodo()){
      String id = cmd.getUpdateTodoID();
      if(Integer.parseInt(id) <= todoList.getTodoList().size()){
        todoList.completeTodo(id, cmd.getFilePath());
      }
      else{
        throw new ParseException("Cannot found Todo associated with id");
      }
    }
    /**
     * Display the todos
     */
    if(cmd.hasDisplay()){
      ArrayList<Todo> todoListCopy = new ArrayList<>();
      todoListCopy.addAll(todoList.getList());
      ArrayList<Todo> displayList = todoListCopy;
      if(cmd.hasShowIncomplete()){
        displayList = todoList.filterByInComplete(displayList);
      }
      if(cmd.hasShowCategory()){
        displayList = todoList.filterByCategory(displayList,cmd.getShowCategoryValue());
      }
      if(cmd.hasSortByDate() && cmd.hasSortByPriority()){
        throw new IllegalArgumentException("You can not sort by date and priority simultaneously");
      }
      if(cmd.hasSortByDate()){
        displayList =  todoList.sortByDueDate(displayList);
      }
      if(cmd.hasSortByPriority()){
        displayList =  todoList.sortByPriority(displayList);
      }
      todoList.printTodoList(displayList);
    }
  }
}
