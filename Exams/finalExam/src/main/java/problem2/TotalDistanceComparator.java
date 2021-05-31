package problem2;

import java.util.Comparator;

public class TotalDistanceComparator implements Comparator<Traveler> {

  /**
   * Overriding compare method which is based on the total distance they traveled over the
   * last three years.
   * @param t1 A traveler
   * @param t2 another traveler
   * @return 0 if the two travelers have the same total traveling distance. A value less than 0 if
   * t1's traveling distance is larger than t2's. A value more than 0 if t1's traveling distance is
   * less than t2's.
   */
  @Override
  //YOUR CODE HERE
  public int compare(Traveler t1, Traveler t2) {
    Double t1Distance = t1.traveledDestinations().stream().map(n -> n.getDistanceFromSeattle()).mapToDouble(i -> i).sum();
    Double t2Distance = t2.traveledDestinations().stream().map(n -> n.getDistanceFromSeattle()).mapToDouble(i -> i).sum();
    return t1Distance.compareTo(t2Distance);
  }
}
