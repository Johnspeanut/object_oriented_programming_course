package p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TravelerIterator implements Iterator {
  private List<Traveler> travelers = new ArrayList<>();
  private Integer internalCounter = 0;

  public List<Traveler> TravelerIterator(List<Traveler> travelers ){
    List<Traveler>  resultList = travelers.stream().filter(n -> isCountyInDestination(
        n.traveledDestinations(),"US")).collect(Collectors.toList());
    this.travelers = resultList;
    return resultList;
  }

  private boolean isCountyInDestination(List<Destination> destinations, String country){
    if(destinations.stream().map(n -> n.getDestinationName()).collect(Collectors.toList()).contains(country)){
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
    return internalCounter < this.travelers.size();
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
      return this.travelers.get(internalCounter++);
    }else{
      throw new NoSuchElementException("No next any more");
    }
  }
}
