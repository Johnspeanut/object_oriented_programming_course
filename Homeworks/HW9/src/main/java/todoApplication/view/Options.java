package todoApplication.view;

import java.util.ArrayList;

/**
 * Options represents a collection of Option objects.
 */
public class Options{
  private ArrayList<Option> expectedListOption = new ArrayList<>();

  /**
   * Constructor
   */
  public Options(){
  }

  /**
   * Add option to options.
   * @param option an option to be added.
   */
  public void addOption(Option option){
    expectedListOption.add(option);
  }

  /**
   * Check if an option associated with option name is in a list of options.
   * @param optName the option name
   * @param options a list of options
   * @return true if the option associated with the option name is in the list of the options.
   */
  public static boolean checkOptNameInOptions(String optName, ArrayList<Option> options){
    for(Option element:options){
      if(optName.equals(element.getOptName())){
        return true;
      }
    }
    return false;
  }

  /**
   * Find an option based on its option name from a list of options.
   * @param optionList a list of options
   * @param optName Name of option to be checked
   * @return Option associated with the option name if found. O.W. return null.
   */
  public static Option findOptionBasedOnString(ArrayList<Option> optionList, String optName){
    for(Option element:optionList){
      if(element.getOptName().equals(optName)){
        return element;
      }
    }
    return null;
  }


  /**
   * Options size
   * @return size of the list of options
   */
  public int size(){
    return expectedListOption.size();
  }

  /**
   * Gets the option list
   * @return the option list
   */
  public ArrayList<Option> getExpectedListOption() {
    return expectedListOption;
  }


}
