package p1;

import java.util.ArrayList;
import java.util.List;

public class Row {
  private Integer rowNumber;
  private Boolean wheelchairAccessible;
  private List<Seat> seatsInRow = new ArrayList<>();
  private Integer numberOfSeats;

  public Row(){

  }
  public Row(Integer numberOfSeats, Boolean isWheelAccessible){
    this.wheelchairAccessible = isWheelAccessible;
    this.numberOfSeats = numberOfSeats;
  }

  public Integer getRowNumber() {
    return rowNumber;
  }

  public Boolean getWheelchairAccessible() {
    return wheelchairAccessible;
  }

  public List<Seat> getSeatsInRow() {
    return seatsInRow;
  }

  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }
}
