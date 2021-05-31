package p1;

public class ReservationsService {
  public static String createBoard(Theater theater){
    final Integer ROW_NUMBER = 20;
    final Integer COL_NUMBER = 20;
    StringBuilder sb = new StringBuilder();
    for (int i = theater.getListOfRow().size() - 1; i >=0 ; i--) {
      for (int j = 0; j < theater.getListOfRow().get(i).getSeatsInRow().size(); j++) {
        if(theater.getListOfRow().get(i).getSeatsInRow().get(j).getReservedFor() == null){
          if(theater.getListOfRow().get(i).getWheelchairAccessible()){
              sb.append(" = ");
          }else{
            sb.append(" - ");
          }
        }else{
          if(theater.getListOfRow().get(i).getWheelchairAccessible()){
            sb.append(" W ");
          }else{
          sb.append(" X ");
        }
      }
    }
      sb.append(System.lineSeparator());
  }
    return sb.toString();

}}
