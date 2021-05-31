package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import todoApplication.view.Option;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {
  Option option;
  Option optionCopy;
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
    optionCopy = new Option(optName,isRequired,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,needArg);
    optionVary = new Option(optName,false,conditionalRequired,requiredAttachedOptName,prerequisiteOptName,false);

  }

  @Test
  public void getOptName() {
    assertEquals(optName,option.getOptName());
  }

  @Test
  public void isRequired() {
    assertEquals(isRequired,option.isRequired());
  }

  @Test
  public void getPrerequisiteOption() {
    assertEquals(prerequisiteOptName,option.getPrerequisiteOption());
  }

  @Test
  public void isNeedArg() {
    assertEquals(needArg,option.isNeedArg());
  }

  @Test
  public void getArg() {
    assertEquals(null, option.getArg());
  }

  @Test
  public void isConditionalRequired() {
    assertEquals(conditionalRequired,option.isConditionalRequired());
  }

  @Test
  public void getRequiredAttachedOpName() {
    assertEquals(requiredAttachedOptName, option.getRequiredAttachedOpName());
  }

  @Test
  public void setArg() {
    option.setArg("hello");
    assertEquals("hello", option.getArg());
  }

  @Test
  public void testEquals() {
    assertTrue(option.equals(optionCopy));
    assertFalse(option.equals(optionVary));
    assertFalse(option.equals(null));
    assertFalse(option.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(option.hashCode() == optionCopy.hashCode());
    assertFalse(option.hashCode() == optionVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(option.toString().equals(optionCopy.toString()));
    assertFalse(option.toString().equals(optionVary.toString()));
  }

  @Test
  public void compareTo() {
    assertEquals(0,option.compareTo(optionCopy));
  }
}