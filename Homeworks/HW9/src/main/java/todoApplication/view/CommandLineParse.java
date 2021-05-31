package todoApplication.view;

import java.util.ArrayList;

/**
 * Command line parser
 */
public class CommandLineParse {
  CommandLine cmd;
  private ArrayList<Option> validOptions = new ArrayList<>();
  private ArrayList<Option> requiredOptions = new ArrayList<>();
  private ArrayList<Option> conditionalRequiredOptions = new ArrayList<>();

  /**
   * Constructor
   */
  public CommandLineParse(){
  }

  /**
   * Create a list of required options.
   * @param options options to be analysed.
   */
  private void createRequiredOptions(Options options){
    for(Option option: options.getExpectedListOption()){
      if(option.isRequired()){
        this.requiredOptions.add(option);
      }
    }
  }

  /**
   * Create a list of conditionally required options.
   * @param options options to be analysed.
   */
  private void createConditionalRequiredOptions(Options options){
    for(Option option: options.getExpectedListOption()){
      if(option.isConditionalRequired()){
        this.conditionalRequiredOptions.add(option);
      }
    }
  }

  /**
   * Check if an option is a list of options.
   * @param option an option to be checked
   * @param options a list of options.
   * @return true if the option is in a list of options.
   */
  private boolean optionInOptionList(Option option, ArrayList<Option> options){
    for(Option element:options){
      if(option.getOptName().equals(element.getOptName())){
        return true;
      }
    }
    return false;
  }

//  /**
//   * Find an option based on its option name from a list of options.
//   * @param optionList a list of options
//   * @param optName Name of option to be checked
//   * @return Option associated with the option name if found. O.W. return null.
//   * @throws ParseException
//   */
//  public static Option findOptionBasedOnString(ArrayList<Option> optionList, String optName)
//      throws ParseException {
//    for(Option element:optionList){
//      if(element.getOptName().equals(optName)){
//        return element;
//      }
//    }
//    return null;
//  }

  /**
   * Check if any option of a list of options shows up in another list of options
   * @param optionsA any option of a list of options
   * @param optionsB another list of options
   * @return true if exist. O.W. throw Parse exception.
   * @throws ParseException
   */
  private boolean anyOptionExist(ArrayList<Option> optionsA, ArrayList<Option> optionsB)
      throws ParseException {
    if(optionsA.isEmpty()){
      return true;
    }
    for(Option option:optionsA){
      if(optionInOptionList(option, optionsB)){
        return true;
      }
    }
    throw new ParseException("You miss conditional argument");
  }

  /**
   * Parse the arguments according to the specified options.
   * @param options the specified Options
   * @param args the command line arguments
   * @return the list of atomic option.
   * @throws ParseException throw parse exception otherwise.
   */
  public CommandLine parse(Options options, String[] args) throws ParseException {
    /**
     * Deal with a case that command line is empty
     */
    if(args.length == 0){
      throw new ParseException("The command line is empty");
    }
    /**
     * Create a list of valid options. Fill parameter for the option if it required parameter.
     */
    for (int i = 0; i < args.length; i++) {
      Option option = Options.findOptionBasedOnString(options.getExpectedListOption(), args[i]);
      if(option != null){
        if(option.isNeedArg()){
          try{
            option.setArg(args[++i]);
          } catch(IndexOutOfBoundsException e){
            System.out.println(option.getOptName() + "needs parameter." + e.getMessage());
          }
        }
        validOptions.add(option);
      }
    }
    /**
     * Create a list of options that are necessary required.
     */
    createRequiredOptions(options);
    for(Option option: this.requiredOptions){
      if(!optionInOptionList(option, this.validOptions)){
        throw new ParseException("You miss command " + option.getOptName());
      }
    }
    /**
     * Create a list of conditionally required options.
     */
    createConditionalRequiredOptions(options);
    anyOptionExist(this.conditionalRequiredOptions, this.validOptions);
    /**
     * check if an option has required attached option and the required attached option is in the
     * list of valid options.
     */
    for(Option option:this.validOptions){
      if(option.getRequiredAttachedOpName() != null){
        if(Options.findOptionBasedOnString(this.validOptions, option.getRequiredAttachedOpName()) == null){
          throw new ParseException(option.getOptName() + " needs " + option.getRequiredAttachedOpName());
        }
      }
    }
    /**
     * check if "--sort-by-date" is conflicted with "--sort-by-priority".
     */
    if(Options.checkOptNameInOptions("--sort-by-date", this.validOptions) && Options.checkOptNameInOptions("--sort-by-priority", this.validOptions)){
      throw new ParseException("--sort-by-date cannot be combined with --sort-by-priority" );
    }
    cmd = new CommandLine();
    cmd.validOptions.addAll(this.validOptions);
    return cmd;
  }

}
