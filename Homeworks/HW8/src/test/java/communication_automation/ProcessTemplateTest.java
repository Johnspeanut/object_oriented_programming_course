package communication_automation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProcessTemplateTest {
  ProcessTemplate processTemplate;

  @Before
  public void setUp() throws Exception {
    processTemplate = new ProcessTemplate();
  }

  @Test
  public void stringTemplate() {
    StringBuilder stringBuilder = processTemplate.stringTemplate("email-template.txt");
    assertTrue(stringBuilder != null);
  }
}