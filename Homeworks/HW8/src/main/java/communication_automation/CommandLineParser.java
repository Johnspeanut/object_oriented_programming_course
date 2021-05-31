package communication_automation;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Creates a commandline parser with inputs
 * 1. The parser can accept command line arguments in any order
 * 2. If --email is provided, --email-template must be given. If --letter is provided, --letter-template must be given
 * 3. If --csv-file is provided, the csv file path must be given.
 * 4. If --letter-template or --email-template is provided, the corresponding file path must be given.
 * 5. Email and letter can be executed simultaneously.
 */

/**
 * A class representing command parser.
 */
public class CommandLineParser {
  private static  final String EMAIL = "--email";
  private static  final String LETTER = "--letter";
  private static final String LETTER_TEMPLATE = "--letter-template";
  private static final String EMAIL_TEMPLATE = "--email-template";
  private static final String OUTPUT = "--output-dir";
  private static final String CSV = "--csv-file";

  private String outputDirectoryPath;
  private Boolean isEmailRequired = false;
  private Boolean isLetterRequired = false;
  private String emailTemplatePath;
  private String letterTemplatePath;
  private String inputCSVPath;
  private Boolean hasEmailTemplate;
  private Boolean hasLetterTemplate;

  /**
   * Constructs CommandLineParser with args and throw invalid arguments exception
   * @param args Arguments from the command line
   * @throws InvalidArgumentsException
   */
  public CommandLineParser(String[] args) throws InvalidArgumentsException {
    this.processArgs(args);
    if(isEmailRequired != null){
      if(isEmailRequired){
        if(!hasEmailTemplate){
          throw new InvalidArgumentsException(("--email provided but no --email-template was given. "));
        }
        if(this.emailTemplatePath == null){
          throw new InvalidArgumentsException(("Missing letter template for " + EMAIL));
        }
      }
    }
    if(isLetterRequired != null){
      if(isLetterRequired){
        if(!hasLetterTemplate){
          throw new InvalidArgumentsException(("--letter provided but no --letter-template was given. "));
        }
        if(this.letterTemplatePath == null){
          throw new InvalidArgumentsException(("Missing letter template for " + LETTER));
        }
      }
    }
  }

  /**
   * The method is to process the command line arguments
   * @param args arguments from the command line
   * @throws InvalidArgumentsException
   */
  private void processArgs(String[] args) throws InvalidArgumentsException {
    int i = 0;
    while (i < args.length) {
      final String option = args[i];
      final String value = args[i + 1];
      switch (option) {
        case CSV:
          this.validateInputCSVPath(value);
          this.inputCSVPath = value;
          i+=2;
          break;
        case OUTPUT:
          this.validateOutputDirPath(value);
          this.outputDirectoryPath = value;
          i+=2;
          break;
        case EMAIL:
          this.isEmailRequired = true;
          i++;
          break;
        case EMAIL_TEMPLATE:
          this.hasEmailTemplate = true;
          CommandLineParser.validatePath(value);
          this.emailTemplatePath = value;
          i+=2;
          break;
        case LETTER:
          this.isLetterRequired = true;
          i++;
          break;
        case LETTER_TEMPLATE:
          this.hasLetterTemplate = true;
          CommandLineParser.validatePath(value);
          this.letterTemplatePath = value;
          i+=2;
          break;
        default:
          i++;
          break;
      }
    }
  }

  /**
   * Check if the input csv path is valid.
   * @param value Value to be checked.
   * @throws InvalidArgumentsException
   */
  private void validateInputCSVPath(final String value) throws InvalidArgumentsException {
    if (!validatePath(value)) {
      throw new InvalidArgumentsException(("Input CSV Path is invalid: " + value));
    }
  }

  /**
   * Check if the output path is valid.
   * @param value Value to be checked.
   * @param value
   * @throws InvalidArgumentsException
   */
  private void validateOutputDirPath(final String value) throws InvalidArgumentsException {
    if (!validatePath(value)) {
      throw new InvalidArgumentsException(("Input Output Directory Path is invalid: " + value));
    }
  }

  /**
   * Check if a path is valid
   * @param path a path to be checked
   * @return
   */
  private static boolean validatePath(final String path) {
    try {
      Paths.get(path);
    } catch (InvalidPathException | NullPointerException ex) {
      return false;
    }
    return true;
  }

  /**
   * Gets the output directory path.
   * @return the output directory path
   */
  public String getOutputDirectoryPath() {
    return outputDirectoryPath;
  }

  /**
   * Gets the email template path
   * @return the email template path.
   */
  public String getEmailTemplatePath() {
    return emailTemplatePath;
  }

  /**
   * Gets the letter template path
   * @return the letter template path
   */
  public String getLetterTemplatePath() {
    return letterTemplatePath;
  }

  /**
   * Gets the input CSV path
   * @return the input CSV path.
   */
  public String getInputCSVPath() {
    return inputCSVPath;
  }

  /**
   * Check if email execution needed.
   * @return true if needed. O.w. false.
   */
  public Boolean getEmailRequired() {
    return isEmailRequired;
  }

  /**
   * Check if letter execution needed.
   * @return true if needed. O.w. false.
   */
  public Boolean getLetterRequired() {
    return isLetterRequired;
  }

  /**
   * Override equals method
   * @param o an object to be compared
   * @return true if equals.O.W.false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommandLineParser)) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(outputDirectoryPath, that.outputDirectoryPath)
        && Objects.equals(isEmailRequired, that.isEmailRequired) && Objects
        .equals(isLetterRequired, that.isLetterRequired) && Objects
        .equals(emailTemplatePath, that.emailTemplatePath) && Objects
        .equals(letterTemplatePath, that.letterTemplatePath) && Objects
        .equals(inputCSVPath, that.inputCSVPath) && Objects
        .equals(hasEmailTemplate, that.hasEmailTemplate) && Objects
        .equals(hasLetterTemplate, that.hasLetterTemplate);
  }

  /**
   * Override hash code method
   * @return hash code value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(outputDirectoryPath, isEmailRequired, isLetterRequired, emailTemplatePath,
        letterTemplatePath, inputCSVPath, hasEmailTemplate, hasLetterTemplate);
  }

  /**
   * Override toString method.
   * @return String representing the object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "outputDirectoryPath='" + outputDirectoryPath + '\'' +
        ", isEmailRequired=" + isEmailRequired +
        ", isLetterRequired=" + isLetterRequired +
        ", emailTemplatePath='" + emailTemplatePath + '\'' +
        ", letterTemplatePath='" + letterTemplatePath + '\'' +
        ", inputCSVPath='" + inputCSVPath + '\'' +
        ", hasEmailTemplate=" + hasEmailTemplate +
        ", hasLetterTemplate=" + hasLetterTemplate +
        '}';
  }
}