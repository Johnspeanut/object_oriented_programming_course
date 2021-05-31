package p1;

public class Seat {
  private char name;
  private String reservedFor = null;

  public Seat(char name){
    this.name = name;
  }


  public Seat(char name, String reservedFor) {
    this.name = name;
    this.reservedFor = reservedFor;
  }

  public char getName() {
    return name;
  }

  public String getReservedFor() {
    return reservedFor;
  }

  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }
}
