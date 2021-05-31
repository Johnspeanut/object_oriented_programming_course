package problem_1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A concrete class representing a pledge donation.
 */
public class PledgeDonation extends Donation{

  /**
   * Constructor for the pledge donation class object.
   * @param amount Amount of the donation.
   * @param date The processing date of the donation,
   */
  public PledgeDonation(float amount, LocalDateTime date) {
    super(amount, date);
  }

  /**
   * Overload constructor for the donation class object.
   * @param amount Amount of the donation.
   */
  public PledgeDonation(float amount) {
    super();
    this.amount = amount;
  }


  /**
   * Updates the process date.
   * @param newDate The new date.
   * @return True if update successfully.
   */
  public boolean updateProcessDate(LocalDateTime newDate){
    if(this.date == null || this.date.isBefore(newDate)){
      this.date = newDate;
      return true;
    }
    return false;
    }

  /**
   * Removes processing date of a donation.
   * @return True if removing is successful.
   */
    public boolean removeProcessDate(){
    if(this.date == null){
      return false;
    }
    this.date = null;
    return true;
    }

  /**
   * Calculate the donation amount in a year.
   * @param year The year within which the donation amount is.
   * @return The amount of donation in that year.
   */
  @Override
  public float calDonation(int year) {
    if(this.date == null){
      return 0;
    }
    if(year == this.getDate().getYear()){
      return this.amount;
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
    if (!(o instanceof PledgeDonation)) {
      return false;
    }
    PledgeDonation that = (PledgeDonation) o;
    if(this.date == null){
      return this.amount == that.amount;
    }
    return this.amount == that.amount && this.date.equals(that.date);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    if(this.date == null){
      return Objects.hash(this.amount);
    }
    return Objects.hash(this.amount,this.date);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "PledgeDonation{" +
        "amount=" + amount +
        ", date=" + date +
        '}';
  }
}
