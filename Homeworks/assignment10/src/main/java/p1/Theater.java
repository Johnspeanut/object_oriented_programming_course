package p1;

import java.util.ArrayList;
import java.util.List;

public class Theater {
//  private final Integer ROW_NUMBER = 20;
//  private final Integer COL_NUMBER = 20;
//  private final Integer ROW_NUMBER_WHEELCHAIR = 0;
  private String theaterName;
  private List<Row> listOfRow;
  private List<Boolean> wheelchairIndicatingList;
  private static Theater instance;  // Lazy allocation
  private Integer numRow;
  private Integer numCol;

//  public Theater(){
//
//  }
  private Theater(String theaterName, List<Boolean> wheelchairIndicatingList){
    this.theaterName = theaterName;
    this.wheelchairIndicatingList = wheelchairIndicatingList;
    this.listOfRow = new ArrayList<>();
  }

  public static Theater startTheater(String theaterName, List<Boolean> wheelchairIndicatingList, Integer numRow, Integer numCol){
    if(instance == null){
      instance = new Theater(theaterName,wheelchairIndicatingList);
    }
    instance.numRow = numRow;
    instance.numCol = numCol;
    for(int i = 0; i < numRow; i++){
      Row row = new Row(numCol,wheelchairIndicatingList.get(i));
      for(char j = 'A'; j <= 'T'; j++){
        Seat seat = new Seat('A');
        row.getSeatsInRow().add(seat);
      }
      instance.getListOfRow().add(row);
    }
    return instance;
  }

//  public Theater(String theaterName,List<Row> listOfRow, List<Boolean> wheelchairIndicatingList){
//    this.theaterName = theaterName;
//    this.listOfRow = listOfRow;
//    this.wheelchairIndicatingList = wheelchairIndicatingList;
//  }

  public String getTheaterName() {
    return theaterName;
  }

  public List<Row> getListOfRow() {
    return listOfRow;
  }

  public List<Boolean> getWheelchairIndicatingList() {
    return wheelchairIndicatingList;
  }

  public Boolean reserveSeats(Integer numTickets, String buyerName){
    int middleOfRow = this.numRow / 2;
    // Assess the middle row at first
    if(!this.listOfRow.get(middleOfRow).getWheelchairAccessible() && this.listOfRow.get(middleOfRow).getSeatsInRow().stream().filter(n -> n.getReservedFor() == null).count() >= numTickets){
      setSeatsInRow(this.listOfRow.get(middleOfRow).getSeatsInRow(), numTickets, buyerName);
      return true;}
    // search other rows. From the middle to sides.
    for (int i = 0; i < middleOfRow; i++) {
      if(!this.listOfRow.get(middleOfRow + i).getWheelchairAccessible() && this.listOfRow.get(middleOfRow + i).getSeatsInRow().stream().filter(n -> n.getReservedFor() == null).count() >= numTickets){
        setSeatsInRow(this.listOfRow.get(middleOfRow + i).getSeatsInRow(), numTickets, buyerName);
        return true;
    }
      if(!this.listOfRow.get(middleOfRow - 1 - i).getWheelchairAccessible() && this.listOfRow.get(middleOfRow - 1 - i).getSeatsInRow().stream().filter(n -> n.getReservedFor() == null).count() >= numTickets){
        setSeatsInRow(this.listOfRow.get(middleOfRow - 1 - i).getSeatsInRow(), numTickets, buyerName);
        return true;
      }
    }
    if(reserveAccessibleSeats(numTickets, buyerName)){
      return true;
    }
    return false;
  }

  public Boolean reserveAccessibleSeats(Integer numTickets, String buyerName){
//    if(!reserveSeats(numTickets, buyerName)){
//      Row accessibleRow = new Row();
      for (int i = 0; i < this.listOfRow.size(); i++) {
        if(this.listOfRow.get(i).getWheelchairAccessible() && this.listOfRow.get(i).getSeatsInRow().stream().filter(n->n.getReservedFor() == null).count() >= numTickets){
          Row accessibleRow = this.listOfRow.get(i);
          setSeatsInRow(accessibleRow.getSeatsInRow(), numTickets, buyerName);
          return true;
        }
      }
//    }
    return false;
  }

  private List<Seat> setSeatsInRow(List<Seat> currentSeats, Integer numTickets, String buyerName){
    int countTickets = 0;
    for (int i = 0; i < currentSeats.size(); i++) {
      if(currentSeats.get(i).getReservedFor() == null && countTickets <= numTickets){
        currentSeats.get(i).setReservedFor(buyerName);
        countTickets ++;
      }
    }
    return currentSeats;
  }




}

