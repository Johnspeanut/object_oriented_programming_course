package problem2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class represents a traveler. The traveler has a first name, last name and a
 * list of destinations they visited in the last three years.
 */
public class Traveler implements Comparable<Traveler> {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;


  /**
   * Constructs a Traveler object and initializes it
   * to the given first name, last name and the list of traveled destinations
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param traveledDestinations list of destinations they visited in the last three years.
   */

  public Traveler(String firstName, String lastName, List<Destination> traveledDestinations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.traveledDestinations = traveledDestinations;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Destination> traveledDestinations() {
    return traveledDestinations;
  }

  @Override
  public int compareTo(Traveler otherTraveler) {
    //YOUR CODE HERE
    List<String> travelerCountries = this.traveledDestinations.stream().map(n -> n.getCountry()).collect(
        Collectors.toList());
    List<String> otherTravelerCountries = otherTraveler.traveledDestinations.stream().map(n -> n.getCountry()).collect(
        Collectors.toList());

    if(Collections.frequency(travelerCountries, "Canada") > Collections.frequency(otherTravelerCountries, "Canada")){
      return -1;
    }else if(Collections.frequency(travelerCountries, "Canada") < Collections.frequency(otherTravelerCountries, "Canada")){
      return 1;
    }else{
      return 0;
    }
  }
}