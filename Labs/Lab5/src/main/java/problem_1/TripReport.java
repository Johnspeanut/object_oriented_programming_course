package problem_1;

import java.util.Objects;

public class TripReport {
  private Vehicle vehicle;
  private float speed;
  private float distance;
  private int tripDuration;

  public TripReport(Vehicle vehicle, float speed, float distance, int tripDuration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.tripDuration = tripDuration;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public float getSpeed() {
    return speed;
  }

  public float getDistance() {
    return distance;
  }

  public int getTripDuration() {
    return tripDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TripReport)) {
      return false;
    }
    TripReport that = (TripReport) o;
    return Float.compare(that.speed, speed) == 0
        && Float.compare(that.distance, distance) == 0 && tripDuration == that.tripDuration
        && Objects.equals(vehicle, that.vehicle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speed, distance, tripDuration);
  }

  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + vehicle +
        ", speed=" + speed +
        ", distance=" + distance +
        ", tripDuration=" + tripDuration +
        '}';
  }
}
