package problem_1;

public class FleetManager {
  static TripReport drive(float distance, Vehicle vehicle){
    return new TripReport(vehicle, vehicle.getAveSpeed(), distance,(int)(distance/vehicle.getAveSpeed()));
    }
  static TripReport drive(float distance, Vehicle vehicle, float speed){
    if(speed > vehicle.getMaxSpeed()){
      speed = vehicle.getAveSpeed();
    }
    return new TripReport(vehicle, speed, distance,(int)(distance/speed));
  }

  static TripReport drive(float distance, Vehicle vehicle, int duration){
    return new TripReport(vehicle, distance/duration, distance,duration);
  }

}
