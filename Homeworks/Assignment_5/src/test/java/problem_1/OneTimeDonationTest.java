package problem_1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {
  OneTimeDonation oneTimeDonation;
  OneTimeDonation oneTimeDonationCopy;
  OneTimeDonation oneTimeDonationAmountVary;
  OneTimeDonation oneTimeDonationDateVary;
  LocalDateTime donateDate = LocalDateTime.of(2015,12,31,12,00);
  LocalDateTime currentDate = LocalDateTime.now();
  float donateAmount = 1000;

  @Before
  public void setUp() throws Exception {
    oneTimeDonation = new OneTimeDonation(donateAmount ,donateDate);
    oneTimeDonationCopy = new OneTimeDonation(donateAmount ,donateDate);
    oneTimeDonationAmountVary = new OneTimeDonation(500 ,donateDate);
    oneTimeDonationDateVary = new OneTimeDonation(donateAmount ,currentDate);
  }

  @Test
  public void getAmount() {
    assertEquals(donateAmount,oneTimeDonation.getAmount(),0.00000001);
  }

  @Test
  public void getDate() {
    assertTrue(donateDate.equals(oneTimeDonation.getDate()));
    assertFalse(currentDate.equals(oneTimeDonation.getDate()));
  }

  @Test
  public void calDonation() {
    assertEquals(donateAmount,oneTimeDonation.calDonation(2015),0.000001);
    assertEquals(0,oneTimeDonation.calDonation(2016),0.000001);
    assertEquals(0,oneTimeDonation.calDonation(2014),0.000001);
  }

  @Test
  public void testEquals() {
assertTrue(oneTimeDonation.equals(oneTimeDonationCopy));
assertFalse(oneTimeDonation.equals(oneTimeDonationAmountVary));
    assertFalse(oneTimeDonation.equals(oneTimeDonationDateVary));
    assertFalse(oneTimeDonation.equals(null));
    assertFalse(oneTimeDonation.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(oneTimeDonation.hashCode() == oneTimeDonationCopy.hashCode());
    assertFalse(oneTimeDonation.hashCode() == oneTimeDonationAmountVary.hashCode());
    assertFalse(oneTimeDonation.hashCode() == oneTimeDonationDateVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(oneTimeDonation.toString().equals(oneTimeDonationCopy.toString()));
    assertFalse(oneTimeDonation.toString().equals(oneTimeDonationDateVary.toString()));
  }
}