package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {

  public static void main(String[] args) {
    final Integer ROW_NUMBER = 20;
    final Integer COL_NUMBER = 20;
    final Integer ROW_NUMBER_WHEELCHAIR = 0;
    // create a list to indicate if a row is wheelchair accessible.
    List<Boolean> wheelchairIndicatingList = new ArrayList<>();
    for (int i = 0; i < ROW_NUMBER; i++) {
      if(i == ROW_NUMBER_WHEELCHAIR){
        wheelchairIndicatingList.add(true);
      }else{
        wheelchairIndicatingList.add(false);
      }
    }
    // create a theater instance
    Theater theater = Theater.startTheater("Seattle Theater",wheelchairIndicatingList,
        ROW_NUMBER,COL_NUMBER);

    Scanner scanner = new Scanner(System.in);
    System.out.println(ReservationsService.createBoard(theater));
    boolean flag = true;
    while(flag){
      System.out.println("What would you like to do?");
      System.out.println("-------------------------------");
      System.out.println("1. reserve seats( number of tickets, registering name");
      System.out.println("2. show the layout of seats.");
      System.out.println("3. quit the program.");
      String nextMove = scanner.nextLine();
//      String[] nextMoves = nexMove.split(" ");
      if(nextMove.equals("1")){
        System.out.println("Do you need wheelchair accessible seats? Y or N");
        String wheelchairMove = scanner.nextLine();
        if(wheelchairMove.equals("Y") || wheelchairMove.equals("N")){
          System.out.println("Please reserve your tickets( number of tickets, your name");
          String reserveTicketMove = scanner.nextLine();
          String[] reserveTicketMoves = reserveTicketMove.split(" ");
          if(reserveTicketMoves.length != 2){
            System.out.println("Need appropriate argument number for reserving seats");
            continue;
          }
          int seatNumber = Integer.parseInt(reserveTicketMoves[0]);

          if(wheelchairMove.equals("N")){
            if(theater.reserveSeats(seatNumber,reserveTicketMoves[1])){
              System.out.println("Reserve regular seats successfully.");
            }else{
              theater.reserveAccessibleSeats(seatNumber,reserveTicketMoves[1]);
              System.out.println("Reserve seats successfully, but in wheelchair accessible area.");
            }
          }else if(wheelchairMove.equals("Y")){
            if(theater.reserveAccessibleSeats(seatNumber,reserveTicketMoves[1])){
              System.out.println("Reserve wheelchair accessible seats successfully.");
            }else{
              System.out.println("Sorry. Cannot reserve the wheel chair seats.");
            }
          }else{
            System.out.println("Sorry. Cannot reserve.");
          }
        } else{
          System.out.println("Please enter valid selection.");
          continue;
        }
      }else if(nextMove.equals("2")){
        System.out.println(ReservationsService.createBoard(theater));
      }else if(nextMove.equals("3")){
        flag = false;
        System.out.println("Bye. You are exiting the program.");
      }else{
        System.out.println("Please enter appropriate selection:");
        continue;
      }
    }
  }
}
