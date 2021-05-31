package todoApplication.view;

import java.util.Objects;

/**
 * Describes a single command-line option. It maintains information regarding the option name, a
 * flag indicating if an argument is required for this option, a flag indicating if an argument
 * is conditional required for this option, required attached option name, prerequisite option name,
 * a flag indicating if the option needs an argument, and argument string.
 */
public class Option implements Comparable<Option>{
  private String optName;
  private boolean isRequired;
  private boolean conditionalRequired;
  private String requiredAttachedOpName;
  private String prerequisiteOptName;
  private boolean needArg;
  private String arg;

  /**
   * Constructor
   */
  public Option(){
  }

  /**
   * Overloading constructor
   * @param optName Option name
   * @param isRequired a flag indicating the option is required.
   * @param prerequisiteOptName the prerequisite option name if having. Default null.
   */
  public Option(String optName, boolean isRequired, String prerequisiteOptName){
    this.optName = optName;
    this.isRequired = isRequired;
    this.prerequisiteOptName = prerequisiteOptName;
  }

  /**
   * Overloading constructor
   * @param optName Option name
   * @param isRequired a flag indicating the option is required.
   * @param conditionalRequired a flag indicating the option is conditionally required.
   * @param requiredAttachedOpName  required attached option name
   * @param prerequisiteOptName the prerequisite option name if having. Default null.
   * @param needArg  a flag indicating if the option needs an argument
   */
  public Option(String optName, boolean isRequired, boolean conditionalRequired,String requiredAttachedOpName,
      String prerequisiteOptName, boolean needArg) {
    this.optName = optName;
    this.isRequired = isRequired;
    this.conditionalRequired = conditionalRequired;
    this.prerequisiteOptName = prerequisiteOptName;
    this.needArg = needArg;
    this.requiredAttachedOpName = requiredAttachedOpName;
  }

  /**
   * Retrieve the option name
   * @return name of this option
   */
  public String getOptName() {
    return optName;
  }

  /**
   * Query to see if the option is required.
   * @return whether this option is required.
   */
  public boolean isRequired() {
    return isRequired;
  }

  /**
   * Get prerequisite option name
   * @return prerequisite option name
   */
  public String getPrerequisiteOption() {
    return prerequisiteOptName;
  }

  /**
   * Query to see if the option needs argument
   * @return boolean flag indicating if the option needs argument.
   */
  public boolean isNeedArg() {
    return needArg;
  }

  /**
   * Gets the argument of the option
   * @return the argument of this option
   */
  public String getArg() {
    return arg;
  }

  /**
   * Query to see if the option is conditionally required
   * @return boolean falg indicating if the option is conditionally required
   */
  public boolean isConditionalRequired() {
    return conditionalRequired;
  }

  /**
   * Gets the required attached option name
   * @return the required attached option name
   */
  public String getRequiredAttachedOpName() {
    return requiredAttachedOpName;
  }

  /**
   * Sets the argument of this option
   * @param arg the argument
   */
  public void setArg(String arg) {
    this.arg = arg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Option)) {
      return false;
    }
    Option option = (Option) o;
    return isRequired == option.isRequired && needArg == option.needArg && Objects
        .equals(optName, option.optName) && Objects
        .equals(prerequisiteOptName, option.prerequisiteOptName) && Objects
        .equals(arg, option.arg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optName, isRequired, prerequisiteOptName, needArg, arg);
  }

  /**
   * Stringifies form of this object. Suitable for debugging
   * @return Stringifies form of this object
   */
  @Override
  public String toString() {
    return "Option{" +
        "optName='" + optName + '\'' +
        ", isRequired=" + isRequired +
        ", prerequisiteOption=" + prerequisiteOptName +
        ", needArg=" + needArg +
        ", arg='" + arg + '\'' +
        '}';
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified
   * object.
   */
  @Override
  public int compareTo(Option o) {
    return this.optName.compareTo(o.optName);
  }
}
