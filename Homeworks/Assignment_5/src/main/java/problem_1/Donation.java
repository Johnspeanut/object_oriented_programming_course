package problem_1;

import java.time.LocalDateTime;

/**
 * An abstract class representing Donation which implements ICalDonation.
 */
public abstract class Donation implements ICalDonation{
float amount;
LocalDateTime date;

  /**
   * Constructor for the Donation class.
   * @param amount Amount of donation.
   * @param date Processing date of the donation.
   */
  public Donation(float amount, LocalDateTime date) {
    this.amount = amount;
    this.date = date;
  }

  /**
   * Overload constructor without parameter.
   */
  public Donation() {
  }

  /**
   * Gets amount of the donation.
   * @return amount of the donation.
   */
  public float getAmount() {
    return amount;
  }

  /**
   * Gets the date of the donation.
   * @return the date of the donation.
   */
  public LocalDateTime getDate() {
    return date;
  }

}
