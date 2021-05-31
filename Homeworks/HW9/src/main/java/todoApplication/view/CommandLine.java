package todoApplication.view;

import java.util.ArrayList;

/**
 * Represents list of arguments parsed against a Options descriptor
 */
public class CommandLine {
  ArrayList<Option> validOptions = new ArrayList<>();

  /**
   * Constructor
   */
  public CommandLine(){
  }

  /**
   * Gets file path
   * @return file path
   * @throws ParseException throw parse exception otherwise.
   */
  public String getFilePath() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--csv-file");
    return option.getArg();
  }

  /**
   * Check if "--add-todo" needs to be executed
   * @return true if needed.
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean isAddTodo() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--add-todo");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Gets the new todo description
   * @return the description of the new todo
   * @throws ParseException throw parse exception otherwise.
   */
  public String todoDescription() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--todo-text");
    if(option == null){
      throw new ParseException("The option does not exist");
    }
    return option.getArg();
  }

  /**
   * Check if "--completed" is turn on.
   * @return ture if it is turn on.
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasCompleted() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--completed");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * check if "--due" is turn on
   * @return ture if it is turn on.
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasDueDate() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--due");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Gets the due date
   * @return the due date
   * @throws ParseException throw parse exception otherwise.
   */
  public String getDueDate() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--due");
    return option.getArg();
  }

  /**
   * Check if "--priority" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasPriority() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--priority");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Gets priority value
   * @return priority value
   * @throws ParseException throw parse exception otherwise.
   */
  public String getPriorityValue() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--priority");
    return option.getArg();
  }

  /**
   * check if "--category" turns on
   * @return ture if "--category" turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasCategory() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--category");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Gets the category value
   * @return the category value
   * @throws ParseException throw parse exception otherwise.
   */
  public String getCategoryValue() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--category");
    return option.getArg();
  }

  /**
   * Check if "--complete--todo" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasUpdateTodo() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--complete-todo");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Check if "--complete-todo" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public String getUpdateTodoID() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--complete-todo");
    return option.getArg();
  }

  /**
   * Check if "--display" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasDisplay() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--display");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * check if "--show-incomplete" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasShowIncomplete() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--show-incomplete");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Check if "--show-category" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasShowCategory() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--show-category");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Gets the category value that shown Todo should have.
   * @return the category value
   * @throws ParseException throw parse exception otherwise.
   */
  public String getShowCategoryValue() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--show-category");
    if(option == null){
      return null;
    }
    return option.getArg();
  }

  /**
   * Check if "--sort-by-date" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasSortByDate() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--sort-by-date");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Check if "--sort-by-priority" turns on
   * @return true if it turns on
   * @throws ParseException throw parse exception otherwise.
   */
  public boolean hasSortByPriority() throws ParseException {
    Option option = Options.findOptionBasedOnString(this.validOptions, "--sort-by-priority");
    if(option != null){
      return true;
    }
    return false;
  }

  /**
   * Get a list of valid options
   * @return a list of valid options
   */
  public ArrayList<Option> getValidOptions() {
    return validOptions;
  }

}
