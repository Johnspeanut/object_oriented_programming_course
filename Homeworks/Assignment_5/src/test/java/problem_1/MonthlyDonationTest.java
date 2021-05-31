package problem_1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDonationTest {
  MonthlyDonation monthlyDonation;
  MonthlyDonation monthlyDonationCopy;
  MonthlyDonation monthlyDonationAmountVary;
  MonthlyDonation monthlyDonationDateVary;
  LocalDateTime donateDate = LocalDateTime.of(2015,10,1,12,00);
  LocalDateTime oldDonateDate = LocalDateTime.of(2014,12,31,12,00);
  LocalDateTime currentDate = LocalDateTime.now();
  float donateAmount = 1000;

  @Before
  public void setUp() throws Exception {
    monthlyDonation= new MonthlyDonation(donateAmount ,donateDate);
    monthlyDonationCopy = new MonthlyDonation(donateAmount ,donateDate);
    monthlyDonationAmountVary = new MonthlyDonation(500 ,donateDate);
    monthlyDonationDateVary = new MonthlyDonation(donateAmount ,currentDate);
  }

  @Test
  public void cancelledDonation() {
    assertTrue(monthlyDonation.cancelledDonation(currentDate));
    assertTrue(monthlyDonation.isCancelled());
    assertFalse(monthlyDonationCopy.cancelledDonation(oldDonateDate));
  }

  @Test
  public void isCancelled() {
    assertTrue(monthlyDonation.cancelledDonation(currentDate));
    assertTrue(monthlyDonation.isCancelled());
    assertFalse(monthlyDonationCopy.isCancelled());
  }

  @Test
  public void getCancelledDate() {
    assertTrue(monthlyDonation.cancelledDonation(currentDate));
    assertTrue(currentDate.equals(monthlyDonation.getCancelledDate()));
  }

  @Test
  public void calDonation() {
    assertEquals(12* monthlyDonation.getAmount(),monthlyDonation.calDonation(2016),0.000001);
    assertEquals(0,monthlyDonation.calDonation(2014),0.000001);
    assertEquals(3 * monthlyDonation.getAmount(),monthlyDonation.calDonation(2015),0.000001);
  }

  @Test
  public void testEquals() {
    assertTrue(monthlyDonation.equals(monthlyDonationCopy));
    assertFalse(monthlyDonation.equals(monthlyDonationAmountVary));
    assertFalse(monthlyDonation.equals(monthlyDonationDateVary));
    assertFalse(monthlyDonation.equals(null));
    assertFalse(monthlyDonation.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(monthlyDonation.hashCode() == monthlyDonationCopy.hashCode());
    assertFalse(monthlyDonation.hashCode() == monthlyDonationAmountVary.hashCode());
    assertFalse(monthlyDonation.hashCode() == monthlyDonationDateVary.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(monthlyDonation.toString().equals(monthlyDonationCopy.toString()));
    assertFalse(monthlyDonation.toString().equals(monthlyDonationDateVary.toString()));
  }
}