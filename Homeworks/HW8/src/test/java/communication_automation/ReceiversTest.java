package communication_automation;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class ReceiversTest {
  Receivers receivers;

  @Before
  public void setUp() throws Exception {
    receivers = new Receivers();
  }

  @Test
  public void extractReceivers() {
    receivers.extractReceivers("nonprofit-supporters.csv");
    assertEquals(500,receivers.getReceiverList().size());
  }

  @Test
  public void getReceiverList() {
    receivers.extractReceivers("nonprofit-supporters.csv");
    assertEquals(500,receivers.getReceiverList().size());
  }
}