package problem_1;

import java.util.Objects;

public abstract class Vehicle{
  private String id;
  private float aveSpeed;
  private float maxSpeed;

  public Vehicle(String id, float aveSpeed, float maxSpeed) {
    this.id = id;
    this.aveSpeed = aveSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getId() {
    return id;
  }

  public float getAveSpeed() {
    return aveSpeed;
  }

  public float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vehicle)) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Float.compare(vehicle.aveSpeed, aveSpeed) == 0
        && Float.compare(vehicle.maxSpeed, maxSpeed) == 0 && Objects
        .equals(id, vehicle.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, aveSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id='" + id + '\'' +
        ", aveSpeed=" + aveSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
