package communication_automation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  CommandLineParser parser;
  CommandLineParser parser_email;
  CommandLineParser parser_letter;
  CommandLineParser parser_fault;
  String[] args_all = "--email --email-template email-template.txt --letter-template letter-template.txt --letter --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
  String[] args_email = "--email --email-template email-template.txt --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
  String[] args_letter = "--letter-template letter-template.txt --letter --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
  String[] args_fault = "--email-template letter-template.txt --letter --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
  @Before
  public void setUp() throws Exception {
    parser = new CommandLineParser(args_all);
    parser_email = new CommandLineParser(args_email);
    parser_letter = new CommandLineParser(args_letter);
//    parser_fault = new CommandLineParser(args_fault);
  }

  @Test
  public void getOutputDirectoryPath() {
    assertEquals("outputfoler/",parser.getOutputDirectoryPath());
  }

  @Test
  public void getEmailTemplatePath() {
    assertEquals("email-template.txt",parser.getEmailTemplatePath());
  }

  @Test
  public void getLetterTemplatePath() {
    assertEquals("letter-template.txt",parser.getLetterTemplatePath());
  }

  @Test
  public void getInputCSVPath() {
    assertEquals("nonprofit-supporters.csv",parser.getInputCSVPath());
  }

  @Test
  public void getEmailRequired() {
    assertTrue(parser.getEmailRequired());
    assertFalse(parser_letter.getEmailRequired());
  }

  @Test
  public void getLetterRequired() {
    assertTrue(parser.getLetterRequired());
    assertFalse(parser_email.getLetterRequired());
  }


  @Test
  public void testEquals() {
    assertTrue(parser.equals(parser));
    assertFalse(parser.equals(parser_email));
    assertFalse(parser.equals(null));
    assertFalse(parser.equals(""));
  }

  @Test
  public void testHashCode() {
    assertFalse(parser.hashCode() == parser_email.hashCode());
  }

  @Test
  public void testToString() {
    assertFalse(parser.toString().equals(parser_email.toString()));
  }
}