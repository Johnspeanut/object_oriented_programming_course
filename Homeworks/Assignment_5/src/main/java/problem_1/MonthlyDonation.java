package problem_1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * A concrete class representing a monthly donation.
 */
public class MonthlyDonation extends Donation{

  private boolean isCancelled = false;
  private LocalDateTime cancelledDate;

  /**
   * Constructor for the monthly donation class object.
   * @param amount Amount of the donation.
   * @param date The processing date of the donation,
   */
  public MonthlyDonation(float amount, LocalDateTime date) {
    super(amount, date);
  }

  /**
   * Cancels a monthly donation.
   * @param cancelledDate Cancel date.
   * @return True if cancel successfully.
   */
  public boolean cancelledDonation(LocalDateTime cancelledDate){
    long minutes = ChronoUnit.MINUTES.between(this.getDate(), cancelledDate);
    if(minutes > 30 * 24 * 60){
      this.cancelledDate = cancelledDate;
      isCancelled = true;
      return true;
    }else{
      return false;
    }
  }

  /**
   * Checks if the donation has been cancelled.
   * @return True if the donation has been cancelled.
   */
  public boolean isCancelled() {
    return isCancelled;
  }

  /**
   * Gets the cancelled date of the donation.
   * @return canceled date.
   */
  public LocalDateTime getCancelledDate() {
    return cancelledDate;
  }

  /**
   * Helper functions used to find minimum(earliest) of date.
   * @param timeList A array list containing dates.
   * @return earliest date.
   */
  private LocalDateTime findMinTime(ArrayList<LocalDateTime> timeList){
    return Collections.min(timeList);
  }

  /**
   * Helper functions used to find maximum(latest) of date.
   * @param timeList A array list containing dates.
   * @return latest date.
   */
  private LocalDateTime findMaxTime(ArrayList<LocalDateTime> timeList){
    return Collections.max(timeList);
  }

  /**
   * Calculate donation amount. Months inclusive.
   * Find max of start of duration and find min of end of duration of donation.
   * @param year The year within which the donation amount is.
   * @return if year is before donation initiated year, return 0. Otherwise, compute the amount.
   */
  @Override
  public float calDonation(int year) {
    LocalDateTime endOfYear = LocalDateTime.of(year,12,31,12,00);
    LocalDateTime startOfYear = LocalDateTime.of(year,1,1,12,00);
    LocalDateTime current = LocalDateTime.now();
    LocalDateTime currentStart = LocalDateTime.of(LocalDateTime.now().getYear(),1,1,12,00);
    ArrayList<LocalDateTime> startList = new ArrayList<LocalDateTime>(Arrays.asList(startOfYear,this.getDate()));
    ArrayList<LocalDateTime> endList = new ArrayList<LocalDateTime>(Arrays.asList(endOfYear,current));
    if(year < this.getDate().getYear()){
      return 0;
    }
    if(isCancelled){
      endList.add(this.cancelledDate);
    }
    LocalDateTime startDuration = findMaxTime(startList);
    LocalDateTime endDuration =findMinTime(endList);
    long months = ChronoUnit.MONTHS.between(startDuration, endDuration) + 1;
    return months * this.getAmount();
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
    if (!(o instanceof MonthlyDonation)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return isCancelled == that.isCancelled && Objects
        .equals(cancelledDate, that.cancelledDate ) && this.amount == that.amount && this.date.equals(that.date);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(isCancelled, cancelledDate,this.amount,this.date);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "amount=" + amount +
        ", date=" + date +
        ", isCancelled=" + isCancelled +
        ", cancelledDate=" + cancelledDate +
        '}';
  }
}
