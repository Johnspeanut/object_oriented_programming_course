package problem_1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A concrete class representing a non profit.
 */
public class NonProfit {
  private String organizationName;
  private ArrayList<Donation> donationCollection = new ArrayList<Donation>();

  /**
   * Constructor for nonprofit class object.
   * @param organizationName Name of the non-profit organization.
   */
  public NonProfit(String organizationName) {
    this.organizationName = organizationName;
  }

  /**
   * Gets the name of the Nonprofit organization.
   * @return name of the nonprofit organization.
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   *Gets the donation collection of the nonprofit.
   * @return the donation collection of the nonprofit.
   */
  public ArrayList<Donation> getDonationCollection() {
    return donationCollection;
  }

  /**
   * Receives a donation. The added object needs to be Donation class.
   * Could be any subtype of Donation class but cast to Donation class.
   * @param donation The donation to be received.
   */
  public void receiveDonation(Donation donation){
    donationCollection.add(donation);
  }

  /**
   * Checks if a donation is in the collection.
   * @param donation A donation to be checked.
   * @return True if the donation is in the collection of the non profit.
   */
  public boolean donationContain(Donation donation){
     return this.donationCollection.contains(donation);
  }

  /**
   * Search method that helps users to search a donation in the collection of non profit.
   * Overload method.
   *  @param donation A donation to be searched.
   * @return A list of donation that meets the requirement.
   */
  public ArrayList<Donation> searchDonation(Donation donation){
    ArrayList<Donation> newDonationList = new ArrayList<Donation>();
    if(this.donationContain(donation)){
      for(Donation element:this.donationCollection){
        if(element.equals(donation)){
          newDonationList.add(element);
        }
      }
      return newDonationList;
    }
    return null;
  }

  /**
   * Search method that helps users to search a donation with a specific date in the collection of non profit.
   * Overload method.
   * @param date A date that the donation processed.
   * @return A list of donation that meets the requirement.
   */
  public ArrayList<Donation> searchDonation(LocalDateTime date){
    ArrayList<Donation> newDonationList = new ArrayList<Donation>();
    for(Donation element:this.donationCollection){
      if(element.date.equals(date)){
        newDonationList.add(element);
      }
    }
    return newDonationList;
  }

  /**
   * Search method that helps users to search a donation with a specific amount in the collection of non profit.
   * Overload method.
   * @param amount the amount that the donation processed.
   * @return A list of donation that meets the requirement.
   */
  public ArrayList<Donation> searchDonation(float amount){
    ArrayList<Donation> newDonationList = new ArrayList<Donation>();
    for(Donation element:this.donationCollection){
      if(element.amount == amount){
        newDonationList.add(element);
      }
    }
    return newDonationList;
  }

  /**
   * Calculate total donation amount of the year.
   * Polymorphism plays role here.
   * @param year The year within which the donation amount is.
   * @return The total amount of donation in that year.
   */
  public float getTotalDonationsForYear(int year){
    float sum = 0;
    for(Donation element:this.donationCollection){
      sum += element.calDonation(year);
    }
    return sum;
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
    if (!(o instanceof NonProfit)) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(organizationName, nonProfit.organizationName) && Objects
        .equals(donationCollection, nonProfit.donationCollection);
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(organizationName, donationCollection);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "organizationName='" + organizationName + '\'' +
        ", donationCollection=" + donationCollection +
        '}';
  }

}
