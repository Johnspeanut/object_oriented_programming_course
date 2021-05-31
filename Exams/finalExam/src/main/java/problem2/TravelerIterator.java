package problem2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TravelerIterator implements Iterator {
  private static final Integer THRESHOLD_DISTANCE = 5000;
  private List<Traveler> travelerList = new ArrayList<>();
  private Integer internalCounter = 0;

  /**
   * Constructor that create a list of travelers whoses traveling distance is larger than 5000.
   * @param travelers a list of travelers.
   */
  public TravelerIterator(List<Traveler> travelers){
    for(Traveler traveler:travelers){
      if(checkDistanceLarger(traveler, THRESHOLD_DISTANCE)){
        travelerList.add(traveler);
      }
    }
  }

  /**
   * Helper method to check if a traveler's total distance is larger than a threshold distance.
   * @param traveler The traveler to be examined.
   * @param thresholdDistance The threshold distance.
   * @return true if it meets the requirement. Otherwise, false.
   */
  private Boolean checkDistanceLarger(Traveler traveler, int thresholdDistance){
    if(traveler.traveledDestinations().stream().map(n -> n.getDistanceFromSeattle()).mapToDouble(x -> x).sum() > thresholdDistance){
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return internalCounter < travelerList.size();
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Object next() {
    if(hasNext()){
      return travelerList.get(internalCounter++);
    }else{
      throw new NoSuchElementException("No next any more");
    }
  }
}
