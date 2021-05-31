package view;

import static org.junit.Assert.assertEquals;

import todoApplication.view.Option;
import todoApplication.view.Options;
import todoApplication.view.ParseException;
import org.junit.Before;
import org.junit.Test;

public class OptionsTest {
  Option option;
  Options options;
  Option optionVary;
  String optName = "print";
  boolean isRequired = true;
  boolean conditionalRequired = true;
  String requiredAttachedOptName = "path";
  String prerequisiteOptName = "read";
  boolean needArg = true;
  String arg = null;

  @Before
  public void setUp() throws Exception {
    option = new Option(optName,isRequired,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,needArg);
    optionVary = new Option(optName,false,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,false);
    options = new Options();
  }

  @Test
  public void addOption() {
    options.addOption(option);
    assertEquals(1,options.size());
  }

  @Test
  public void isStringInOptions() {
    options.addOption(option);
    assertEquals(true,Options.checkOptNameInOptions("print",options.getExpectedListOption()));
  }

  @Test
  public void findOptionBasedOnString() throws ParseException {
    options.addOption(option);
    assertEquals(option,Options.findOptionBasedOnString(options.getExpectedListOption(),optName));
  }

  @Test
  public void getExpectedListOption() {
    assertEquals(0,options.getExpectedListOption().size());
  }


  @Test
  public void size() {
    assertEquals(0,options.size());
  }

}