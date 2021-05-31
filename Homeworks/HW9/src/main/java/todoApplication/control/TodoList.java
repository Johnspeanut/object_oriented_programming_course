package todoApplication.control;

import todoApplication.model.ReadCSV;
import todoApplication.model.WriteCSV;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Concrete class representing a to-do list.
 */
public class TodoList {

  private static final String HEADER = "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"\n";
  private ArrayList<Todo> list = new ArrayList<>();


  /**
   * Constructs a new to-do list, based upon the provided input parameter.
   * @param fileName File name of csv storing the data
   * @throws IOException throw IO exception if file name doesn't exist
   */
  public TodoList(String fileName) throws IOException {
    ArrayList<ArrayList<String>> stringList = ReadCSV.readFile(fileName);
    for (ArrayList todo:stringList){
      list.add(stringToTodo(todo));
    }
  }

  /**
   * Overloading constructor the todolist
   */
  public TodoList(){
  }

  /**
   * helper method converting a list of string to Todo object
   * @param listTodo a list of string
   * @return Todo object
   */
  private Todo stringToTodo(ArrayList<String> listTodo){
    int id = Integer.parseInt(listTodo.get(0));
    String text = listTodo.get(1);
    Boolean ifComplete = Boolean.parseBoolean(listTodo.get(2));

    LocalDate localDate;
    if (listTodo.get(3).equals("?") || listTodo.get(3) == "null") localDate = LocalDate.of(1000, 1, 1);
    else{
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    localDate = LocalDate.parse(listTodo.get(3),dateTimeFormatter);
    }

    int priority = Integer.MIN_VALUE;
    if (listTodo.get(4).equals("?"))
    {priority = 3;}
    else{
    priority = Integer.parseInt(listTodo.get(4));}

    String category = listTodo.get(5).equals("?") ? "?":listTodo.get(5);
    Todo temp = new Todo(id,text,ifComplete,localDate,priority,category);
    return temp;
  }

  /**
   * get the header from todolist
   *
   * @return the header of todolist
   */
  public String getHEADER() {
    return HEADER;
  }

  /**
   * Gets the to-do list as an ArrayList of Todos.
   *
   * @return the to-do list as an ArrayList of Todos.
   */
  public ArrayList<Todo> getList() {
    return this.list;
  }

  /**
   * add a new todoElement in to the list
   * @param todo a todo object to be added
   * @param fileName a file name saving the data
   */
  public void addTodo(Todo todo, String fileName) {
    list.add(todo);
    WriteCSV writeCSV = new WriteCSV();
    writeCSV.writeCSV(todoListToArrayList(),fileName);
  }

  /**
   * Overloading addtodo method. No writing into the file.
   * @param todo a todo object to be added
   */
  public void addTodo(Todo todo) {
    list.add(todo);
  }

  /**
   * convert todo to array list
   * @return a list of string lists
   */
  private ArrayList<ArrayList<String>> todoListToArrayList(){
    ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
    for(Todo element:this.list){
      ArrayList<String> returnElement = element.convertTodoToString();
      returnList.add(returnElement);
    }
    return returnList;
  }

  /**
   * update a todo status to complete based on id
   * @param id the ia associated with the todo.
   * @param fileName a file name saving the data
   */
  public void completeTodo(String id, String fileName) {
    int intID = Integer.parseInt(id);
    for(Todo csvTodo: this.list){
      if(csvTodo.getId() == intID){
        csvTodo.setCompleted(true);
        WriteCSV writeCSV = new WriteCSV();
        writeCSV.writeCSV(todoListToArrayList(),fileName);
      }
    }
  }

  /**
   * update a todo status to complete based on id
   * @param id the ia associated with the todo.
   */
  public void completeTodo(String id) {
    int intID = Integer.parseInt(id);
    for(Todo csvTodo: this.list){
      if(csvTodo.getId() == intID){
        csvTodo.setCompleted(true);
      }
    }
  }

  /**
   * Gets a list of todo
   * @return a list of todo
   */
  public ArrayList<Todo> getTodoList(){
    return this.list;
}

  /**
   * Print a list of todo
   * @param todos a list of todo
   */
  public void printTodoList(ArrayList<Todo> todos){
    for(Todo element:todos){
      element.convertTodoToString();
      System.out.println(element.toString());
    }
}

  /**
   * Filters the to-do list to only include incomplete to-dos.
   * @param listTodo a list of todo
   * @return a filtered to-do list.
   */
  public ArrayList<Todo> filterByInComplete(ArrayList<Todo> listTodo) {
    ArrayList<Todo> todos = (ArrayList<Todo>)listTodo.stream().filter( n -> n.isCompleted() == false).collect(Collectors.toList());
    return todos;
  }

  /**
   * Filters the to-do list to only include to-dos with a particular group category.
   * @param listTodo a list of todo
   * @param category - to-do's group category as a String.
   * @return a filtered to-do list.
   */
  public ArrayList<Todo> filterByCategory(ArrayList<Todo> listTodo, String category) {
    ArrayList<Todo> todos = (ArrayList<Todo>) listTodo.stream().filter( n -> n.getCategory().equals(category)).collect(Collectors.toList());
    return todos;
  }

  /**
   * Sorts the to-do list by due date (ascending).
   * @param listTodo a list of todo
   * @return a sorted to-do list.
   */
  public ArrayList<Todo> sortByDueDate(ArrayList<Todo> listTodo) {
    Collections.sort(listTodo);
    return listTodo;
  }

  /**
   * Sorts the to-do list by priority (ascending).
   * @param listTodo a list of todo
   * @return a sorted to-do list.
   */
  public ArrayList<Todo> sortByPriority(ArrayList<Todo> listTodo) {
    listTodo.sort(new PriorityComparator());
    return listTodo;
  }


  /**
   * Overrides the equals() to check if some other object is "equal to" this one.
   *
   * @param o - object to compare as an Object.
   * @return true if the two objects are equal and false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    TodoList that = (TodoList) o;
    HashSet<Todo> thisSet = new HashSet<>(this.getList());
    HashSet<Todo> thatSet = new HashSet<>(that.getList());
    return thisSet.equals(thatSet);
  }

  /**
   * Overrides the hashcode() to get the hash code for the to-do list as an integer.
   *
   * @return the hash code for the to-do list as an integer.
   */
  @Override
  public int hashCode() {
    HashSet<Todo> thisSet = new HashSet<>(this.getList());
    return thisSet.hashCode();
  }

  /**
   * Overrides the toString() to get the string representing the to-do list.
   *
   * @return the string representing the to-do list.
   */
  @Override
  public String toString() {
    return "TodoList{list=" + this.getList() + "}";
  }
}