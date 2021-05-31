package problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  A class recommending trip destination.
 */
public class TripRecommender {

  /**
   *  a private map destinationStatistics containing information of destinations.
   */
  private Map<Destination, ArrayList<Integer>> destinationStatistics;

  /**
   * constructor
   */
  public TripRecommender(){
  }

  /**
   * Create a map of destinations with corresponding statistics based on a list of travelers.
   * @param travelers  a list of travelers
   * @return a map of destinations with corresponding statistics
   */
  public Map<Destination, ArrayList<Integer>>  getAggregatedStatistics(List<Traveler> travelers){
    Map<Destination, Integer> visitedDestinationStatistics = new HashMap<>();
    Map<Destination, Integer> considerDestinationStatistics = new HashMap<>();
    for(Traveler traveler:travelers){
      for(Destination destination:traveler.getTraveledDestinations()){
        if(visitedDestinationStatistics.containsKey(destination)){
          visitedDestinationStatistics.put(destination, visitedDestinationStatistics.
              get(destination) + 1);
        }else{
          visitedDestinationStatistics.put(destination,1);
        }
      }
      for(Destination destination:traveler.getConsideredDestinations()){
        if(considerDestinationStatistics.containsKey(destination)){
          considerDestinationStatistics.put(destination, considerDestinationStatistics.
              get(destination) + 1);
        }else{
          considerDestinationStatistics.put(destination,1);
        }
      }
    }

    // Merge two sub-maps
    Map<Destination, Integer> mergedMap = new HashMap<>(visitedDestinationStatistics);
    mergedMap.putAll(considerDestinationStatistics);

    // Create a result map
    // Using a arraylist to contain counting number of visited and counting number of desired.
    Map<Destination, ArrayList<Integer>> resultMap = new HashMap<>();
    for(Destination destination: mergedMap.keySet()){
      Integer visitedCount = 0;
      Integer considerCount = 0;
      if(visitedDestinationStatistics.containsKey(destination)){
        visitedCount = visitedDestinationStatistics.get(destination);
      }
      if(considerDestinationStatistics.containsKey(destination)){
        considerCount = considerDestinationStatistics.get(destination);
      }
      ArrayList<Integer> counts = new ArrayList<>(Arrays.asList(visitedCount, considerCount));
      resultMap.put(destination,counts);
    }
    this.destinationStatistics = resultMap;
    return resultMap;
  }

  /**
   * Gets the most visited destination
   * @return the most visited destination
   */
  public Destination recommendMostVisitedDestination(){
    return this.destinationStatistics.entrySet().stream().max((entry1, entry2) ->
        entry1.getValue().get(0) > entry2.getValue()
        .get(0)? 1: -1).get().getKey();
  }

  /**
   * Gets the most desired desired destination
   * @return the most desired desired destination
   */
  public Destination recommendMostDesiredDestination(){
    return this.destinationStatistics.entrySet().stream().max((entry1, entry2) ->
        entry1.getValue().get(1) > entry2.getValue()
        .get(1)? 1: -1).get().getKey();
  }
}
