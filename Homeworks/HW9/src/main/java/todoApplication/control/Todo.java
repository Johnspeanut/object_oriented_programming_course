package todoApplication.control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Concrete class representing a to-do.
 */
public class Todo implements Comparable<Todo> {

  private int id;
  private String text;
  private boolean isCompleted;
  private LocalDate due;
  private int priority;
  private String category;

  /**
   * Constructs a new to-do, based upon the provided input parameter.
   *
   * @param builder - a TodoBuilder object.
   */
  private Todo(TodoBuilder builder) {
    this.id = builder.id;
    this.text = builder.text;
    this.isCompleted = builder.isCompleted;
    this.due = builder.due;
    this.priority = builder.priority;
    this.category = builder.category;
  }

  /**
   * Constructor
   */
  public Todo(){
    // do nothing.
  }

  /**
   * Overloading constructor
   * @param id id of the Todo
   * @param text Text message of this toto
   * @param isCompleted the status of the todo
   * @param due due date of the todo
   * @param priority priority value of the todo
   * @param category category of the todo
   */
  public Todo(int id, String text, boolean isCompleted, LocalDate due, int priority, String category) {
    this.id = id;
    this.text = text;
    this.isCompleted = isCompleted;
    this.due = due;
    this.priority = priority;
    this.category = category;
  }

  /**
   * convert a todo object to list of todos (string)
   * @return list
   */
  public ArrayList<String> convertTodoToString(){
    ArrayList<String> tmpList = new ArrayList<>();
    tmpList.add(String.valueOf(this.id));
    tmpList.add("\""+this.text+"\"");
    tmpList.add(String.valueOf(this.isCompleted));
    if(this.due.equals(LocalDate.of(1000,1,1))) {tmpList.add("?");}
    else {
      String year = String.valueOf(this.due.getYear());
      String month = String.valueOf(this.due.getMonthValue());
      String date = String.valueOf(this.due.getDayOfMonth());
      tmpList.add(month+"/"+date+"/"+year);
    }
    tmpList.add(String.valueOf(this.priority));
    tmpList.add(this.category);

    return tmpList;
  }

  public void setId(int id) {
    this.id = id;
  }


  /**
   * setter for complete
   * @param completed true or false
   */
  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  /**
   * Gets the to-do's ID as an integer.
   *
   * @return the to-do's ID as an integer.
   */
  public int getId() {
    return this.id;
  }

  /**
   * Gets the to-do's text description as a String.
   *
   * @return the to-do's text description as a String.
   */
  public String getText() {
    return this.text;
  }

  /**
   * Gets the to-do's completed status as a boolean.
   *
   * @return the to-do's completed status as a boolean.
   */
  public boolean isCompleted() {
    return this.isCompleted;
  }

  /**
   * Gets the to-do's due date as a LocalDate.
   *
   * @return the to-do's due date as a LocalDate.
   */
  public LocalDate getDue() {
    return this.due;
  }

  /**
   * Gets the to-do's priority as an integer.
   *
   * @return the to-do's priority as an integer.
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Gets the to-do's group category as a String.
   *
   * @return the to-do's group category as a String.
   */
  public String getCategory() {
    return this.category;
  }

  /**
   * Sets the to-do's completed status as true.
   */
  public void setCompleted() {
    this.isCompleted = true;
  }

  /**
   * Gets the string representing the to-do in a writer-friendly format.
   *
   * @return the string representing the to-do in a writer-friendly format.
   */
  public String toFormattedString() {
    return "\"" + this.getId() + "\",\"" + this.getText() + "\",\"" + this.isCompleted() + "\",\""
        + this.getDue() + "\",\"" + this.getPriority() + "\",\"" + this.getCategory() + "\"";
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
    Todo that = (Todo) o;
    return Objects.equals(this.getText(), that.getText()) &&
        this.isCompleted() == that.isCompleted() &&
        Objects.equals(this.getDue(), that.getDue()) &&
        this.getPriority() == that.getPriority() &&
        Objects.equals(this.getCategory(), that.getCategory());
  }

  /**
   * Overrides the hashcode() to get the hash code for the to-do as an integer.
   *
   * @return the hash code for the to-do as an integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getId(), this.getText(), this.isCompleted(), this.getDue(),
        this.getPriority(), this.getCategory());
  }

  /**
   * Overrides the toString() to get the string representing the to-do.
   *
   * @return the string representing the to-do.
   */
  @Override
  public String toString() {
    return "Todo{id=" + this.getId() + ", text=" + this.getText() + ", isCompleted=" +
        this.isCompleted() + ", due=" + this.getDue() + ", priority=" + this.getPriority() +
        ", category=" + this.getCategory() + "}";
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified
   * object.
   */
  @Override
  public int compareTo(Todo o) {
      if(this.due.isBefore(o.due) || this.due == null || o.due == null)
        return -1;
      else if(this.due.isAfter(o.due))
        return 1;
      else{
        return 0;
      }
    }


  /**
   * Nested static class representing a to-do builder.
   */
  public static class TodoBuilder {

    private static final boolean DEFAULT_STATUS = false;
    private static final int HIGHEST_PRIORITY = 1;
    private static final int LOWEST_PRIORITY = 3;
    private static final String PRIORITY_ALERT = "Priority must be between 1 and 3 (inclusive).";
    private int id;
    private String text;
    private boolean isCompleted;
    private LocalDate due;
    private int priority;
    private String category;

    /**
     * Constructs a new to-do builder, based upon all of the provided input parameters.
     *
     * @param text - to-do's text description as a String.
     */
    public TodoBuilder(String text) {
      this.text = text;
      this.isCompleted = DEFAULT_STATUS;
      this.priority = LOWEST_PRIORITY;
    }

    public TodoBuilder addId(int id){
      this.id = id;
      return this;
    }
    /**
     * Helper method to validate a priority between 1 and 3 (inclusive).
     *
     * @param priority - priority to validate as an integer.
     * @return the validated priority.
     * @throws IllegalArgumentException if any invalid priority was passed.
     */
    private int isInRange(int priority) throws IllegalArgumentException {
      if (priority < HIGHEST_PRIORITY || priority > LOWEST_PRIORITY) {
        throw new IllegalArgumentException(PRIORITY_ALERT);
      }
      return priority;
    }

    /**
     * Adds the to-do's completed status.
     *
     * @param isCompleted - to-do's completed status as a boolean.
     * @return the updated to-do builder.
     */
    public TodoBuilder addCompleted(boolean isCompleted) {
      this.isCompleted = isCompleted;
      return this;
    }

    /**
     * Adds the to-do's due date.
     *
     * @param due - to-do's due date as a LocalDate.
     * @return the updated to-do builder.
     */
    public TodoBuilder addDue(String due) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
      LocalDate dueDate = LocalDate.parse(due,dateTimeFormatter);
      this.due = dueDate;
      return this;
    }

    /**
     * Adds the to-do's priority.
     *
     * @param priority - to-do's priority as an integer.
     * @return the updated to-do builder.
     * @throws IllegalArgumentException if any invalid priority was passed.
     */
    public TodoBuilder addPriority(String priority) throws IllegalArgumentException {
      int priorityInt = Integer.parseInt(priority);
      this.priority = this.isInRange(priorityInt);
      return this;
    }

    /**
     * Adds the to-do's group category.
     *
     * @param category - to-do's group category as a String.
     * @return the updated to-do builder.
     */
    public TodoBuilder addCategory(String category) {
      this.category = category;
      return this;
    }

    /**
     * Builds a to-do.
     *
     * @return a new to-do.
     */
    public Todo build() {
      return new Todo(this);
    }
  }
}