package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseballPlayerTest {
  private Name expectedName = new Name("Jane", "Jane", "Doe");
  private Double expectedHeight = 5.8;
  private Double expectedWeigh = 135.0; //
  private String expectedLeague = "MLB";
  private String team = "Terp";
  private Double batting = 2.0;
  private Integer homeruns = 5;
  private BaseballPlayer baseballPlayer;

  @Before
  public void setUp() throws Exception {
    baseballPlayer = new BaseballPlayer(expectedName,expectedHeight,expectedWeigh,expectedLeague,team,batting,homeruns);
  }

  @Test
  public void getTeam() {
    assertEquals(team,baseballPlayer.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(batting,baseballPlayer.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRuns() {
    assertEquals(homeruns,baseballPlayer.getSeasonHomeRuns());
  }

  @Test
  public void testEquals() {
    BaseballPlayer baseballPlayer2 = new BaseballPlayer(expectedName,expectedHeight,expectedWeigh,expectedLeague,team,batting,homeruns);
    assertEquals(true,baseballPlayer.equals(baseballPlayer2));
  }

  @Test
  public void testHashCode() {
    BaseballPlayer baseballPlayer2 = new BaseballPlayer(expectedName,expectedHeight,expectedWeigh,expectedLeague,team,batting,homeruns);
    assertEquals(baseballPlayer2.hashCode(),baseballPlayer.hashCode());
  }
}