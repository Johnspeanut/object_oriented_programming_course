package problem_1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A concrete class representing one-time donation.
 */
public class OneTimeDonation extends Donation{

  /**
   * Construcotr for the OneTimeDonation class object.
   * @param amount Amount of the donation.
   * @param date The processing date of the donation.
   */
  public OneTimeDonation(float amount, LocalDateTime date) {
    super(amount, date);
  }

  /**
   * Calculate the donation amount in a year.
   * @param year The year within which the donation amount is.
   * @return The amount of donation in that year.
   */
  @Override
  public float calDonation(int year) {
    if(this.getDate().getYear() == year){
      return this.getAmount();
    }
    return 0;
  }

  /**
   * Override equals method.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OneTimeDonation)) {
      return false;
    }
    OneTimeDonation that = (OneTimeDonation) o;
    return this.amount == that.amount && this.date.equals(that.date);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.amount,this.date);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "OneTimeDonation{" +
        "amount=" + amount +
        ", date=" + date +
        '}';
  }
}
