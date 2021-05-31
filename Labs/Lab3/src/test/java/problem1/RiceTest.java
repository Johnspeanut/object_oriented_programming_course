package problem1;

import static org.junit.Assert.*;

import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;

public class RiceTest {
  Rice riceNoodle;
  Rice ricePie;
  Rice riceNoodleCopy;
  String riceNoodleName = "Noodle";
  String ricePieName = "Pie";
  double riceNoodlePrice = 10.0;
  double ricePiePrice = 20.0;
  int riceNoodleAvailQuantity = 100;
  int ricePieAvailQuantity = 1000;


  @Before
  public void setUp() throws Exception {
    riceNoodle = new Rice(riceNoodleName,riceNoodlePrice,riceNoodleAvailQuantity);
    riceNoodleCopy = new Rice(riceNoodleName,riceNoodlePrice,riceNoodleAvailQuantity);
    ricePie = new Rice(ricePieName,ricePiePrice,ricePieAvailQuantity);
  }

  @Test
  public void getMaxAllowedQuantity() {
    assertEquals(250,riceNoodle.getMaxAllowedQuantity());
  }

  @Test
  public void testToString() {
    assertEquals(riceNoodle.toString(),riceNoodleCopy.toString());
  }

  @Test
  public void makeOrder() {
    assertTrue(ricePie.makeOrder(50));
  }
}