package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AthleteTest {

  private Name expectedName = new Name("Jane", "Jane", "Doe");
  private Double expectedHeight = 5.8;
  private Double expectedWeigh = 135.0; //
  private String expectedLeague = "MLB";
  private Athlete testAthlete;

  @Before
  public void setUp() throws Exception {
    testAthlete = new Athlete(expectedName, expectedHeight, expectedWeigh, expectedLeague);
  }

  @Test
  public void getAthletesName() {
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @Test
  public void getHeight() {
    assertEquals(expectedHeight, testAthlete.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals(expectedWeigh, testAthlete.getWeight());
  }

  @Test
  public void getLeague() {
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  //Testing reflexivity
  public void testEqualsReflexivity() {
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  //Testing symmetry
  public void testEqualsSymmetry() {
    Athlete testAthlete2 = new Athlete(expectedName, expectedHeight, expectedWeigh,
        expectedLeague);
    assertTrue(testAthlete.equals(testAthlete2) && testAthlete2.equals(testAthlete));
  }

  @Test
  //Testing transitivity
  public void testEqualsTransitivity() {
    Athlete testAthlete2 = new Athlete(expectedName, expectedHeight, expectedWeigh,
        expectedLeague);
    Athlete testAthlete3 = new Athlete(expectedName, expectedHeight, expectedWeigh,
        expectedLeague);
    assertTrue(testAthlete.equals(testAthlete2) && testAthlete2.equals(testAthlete3)
        && testAthlete.equals(testAthlete3));
  }

  @Test
  //Testing for null-reference
  public void testEqualsNullReference(){
    assertFalse(testAthlete.equals(null));
  }

  @Test
  public void testHashCode() {
    assertFalse(0 == testAthlete.hashCode());
  }

  @Test
  //Testing consistency
  public void testHashCodeConsistency(){
    int testHashCode = testAthlete.hashCode();
    assertEquals(testHashCode, testAthlete.hashCode());
  }

  @Test
  //Testing consistency with equals
  public void testHashCodeConsistency2(){
    Athlete testAthlete2 = new Athlete(expectedName, expectedHeight, expectedWeigh,
        expectedLeague);
    assertTrue(testAthlete.equals(testAthlete2) == (testAthlete.hashCode() == testAthlete2.hashCode()));
  }
}