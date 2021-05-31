package view;

import static org.junit.Assert.assertEquals;

import todoApplication.view.CommandLine;
import todoApplication.view.CommandLineParse;
import todoApplication.view.Option;
import todoApplication.view.Options;
import todoApplication.view.ParseException;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParseTest {
  CommandLineParse parser;
  Option option;
  Options options;
  Option optionVary;
  String optName = "print";
  boolean isRequired = true;
  boolean conditionalRequired = false;
  String requiredAttachedOptName = null;
  String prerequisiteOptName = null;
  boolean needArg = false;
  String[] args = "print read".split(" ");
  CommandLine cmd;

  @Before
  public void setUp() throws Exception {
    option = new Option(optName,isRequired,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,needArg);
    optionVary = new Option("read",false,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,false);
    options = new Options();
    options.addOption(option);
    options.addOption(optionVary);
    parser = new CommandLineParse();

  }

  @Test
  public void parse() throws ParseException {
    cmd = parser.parse(options,args);
    assertEquals(2,cmd.getValidOptions().size());
  }

  @Test(expected = ParseException.class)
  public void parseEmptyCommand() throws ParseException {
    String[] args = new String [2];
    cmd = parser.parse(options,args);
  }

  @Test
  public void parseEmptyCommand1() throws ParseException {
    String[] args2 = "read print".split(" ");
    cmd = parser.parse(options,args2);
  }
}