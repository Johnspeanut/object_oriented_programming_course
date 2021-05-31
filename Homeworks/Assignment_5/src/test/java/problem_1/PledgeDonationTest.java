package problem_1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class PledgeDonationTest {
  PledgeDonation pledgeDonation;
  PledgeDonation pledgeDonationCopy;
  PledgeDonation pledgeDonationAmountVary;
  PledgeDonation pledgeDonationDateVary;
  PledgeDonation pledgeDonationNullDate;
  PledgeDonation pledgeDonationNullDateCopy;
  LocalDateTime donateDate = LocalDateTime.of(2015,12,31,12,00);
  LocalDateTime oldDonateDate = LocalDateTime.of(2014,12,31,12,00);
  LocalDateTime currentDate = LocalDateTime.now();
  float donateAmount = 1000;

  @Before
  public void setUp() throws Exception {
    pledgeDonation = new PledgeDonation(donateAmount ,donateDate);
    pledgeDonationCopy = new PledgeDonation(donateAmount ,donateDate);
    pledgeDonationAmountVary = new PledgeDonation(500 ,donateDate);
    pledgeDonationDateVary = new PledgeDonation(donateAmount ,currentDate);
    pledgeDonationNullDate = new PledgeDonation(donateAmount);
    pledgeDonationNullDateCopy = new PledgeDonation(donateAmount);
  }

  @Test
  public void setConstructor(){
    PledgeDonation pledgeDonation = new PledgeDonation(donateAmount);
    assertEquals(null,pledgeDonation.getDate());
  }

  @Test
  public void updateProcessDate() {
    assertTrue(pledgeDonation.updateProcessDate(currentDate));
    assertFalse(pledgeDonation.updateProcessDate(oldDonateDate));
  }

  @Test
  public void removeProcessDate() {
    assertTrue(pledgeDonation.removeProcessDate());
    assertEquals(null,pledgeDonation.getDate());
  }

  @Test
  public void calDonation() {
    assertEquals(donateAmount,pledgeDonation.calDonation(2015),0.000001);
    assertEquals(0,pledgeDonation.calDonation(2016),0.000001);
    assertEquals(0,pledgeDonation.calDonation(2014),0.000001);
    assertEquals(0,pledgeDonationNullDate.calDonation(2014),0.000001);
  }

  @Test
  public void testEquals() {
    assertTrue(pledgeDonation.equals(pledgeDonationCopy));
    assertTrue(pledgeDonationNullDateCopy.equals(pledgeDonationNullDate));
    assertFalse(pledgeDonation.equals(pledgeDonationAmountVary));
    assertFalse(pledgeDonation.equals(pledgeDonationDateVary));
    assertFalse(pledgeDonation.equals(null));
    assertFalse(pledgeDonation.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(pledgeDonation.hashCode() == pledgeDonationCopy.hashCode());
    assertFalse(pledgeDonation.hashCode() == pledgeDonationAmountVary.hashCode());
    assertFalse(pledgeDonation.hashCode() == pledgeDonationDateVary.hashCode());
    assertTrue(pledgeDonationNullDateCopy.hashCode() == pledgeDonationNullDate.hashCode());
  }

  @Test
  public void testToString() {
    assertTrue(pledgeDonation.toString().equals(pledgeDonationCopy.toString()));
    assertFalse(pledgeDonation.toString().equals(pledgeDonationDateVary.toString()));
  }
}