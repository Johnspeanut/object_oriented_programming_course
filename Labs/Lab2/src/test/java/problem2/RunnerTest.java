package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {
  private Name expectedName = new Name("Jane", "Jane", "Doe");
  private Double expectedHeight = 5.8;
  private Double expectedWeigh = 135.0; //
  private String expectedLeague = "MLB";
  private Double best5Ktime = 5.0;
  private Double marathonTime = 2.0;
  private String event = "Beijing";
  private Runner runner;

  @Before
  public void setUp() throws Exception {
    runner = new Runner(expectedName,expectedHeight,expectedWeigh,expectedLeague,best5Ktime,marathonTime,event);
  }

  @Test
  public void getBest5Ktime() {
    assertEquals(best5Ktime,runner.getBest5Ktime());
  }

  @Test
  public void getBestHalfMarathonTime() {
    assertEquals(marathonTime,runner.getBestHalfMarathonTime());
  }

  @Test
  public void getFavoriteRunningEvent() {
    assertEquals(event,runner.getFavoriteRunningEvent());
  }

  @Test
  public void testEquals() {
    Runner runner2 = new Runner(expectedName,expectedHeight,expectedWeigh,expectedLeague,best5Ktime,marathonTime,event);
    assertEquals(true,runner.equals(runner2));
  }

  @Test
  public void testHashCode() {
    Runner runner2 = new Runner(expectedName,expectedHeight,expectedWeigh,expectedLeague,best5Ktime,marathonTime,event);
    assertEquals(runner.hashCode(),runner2.hashCode());
  }
}