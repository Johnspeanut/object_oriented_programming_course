package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }
  public List<Vehicle> filterVehicles(){
   //YOUR CODE HERE
    return this.vehicles.stream().filter(n -> n.getYear() > 1999).collect(Collectors.toList());
  }

  public void printVehicle(List<Vehicle> list){
    for(Vehicle vehicle:list){
      System.out.println(vehicle.toString());
    }
  }
}