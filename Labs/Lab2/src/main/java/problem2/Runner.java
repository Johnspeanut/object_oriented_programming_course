package problem2;

import java.util.Objects;

public class Runner extends Athlete{
  private Double best5Ktime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  public Runner(Name athletesName, Double height, Double weight, String league, Double best5Ktime,
                Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5Ktime = best5Ktime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  public Runner(Name athletesName, Double height, Double weight, Double best5Ktime, Double bestHalfMarathonTime,
                String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5Ktime = best5Ktime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  public Double getBest5Ktime() {
    return best5Ktime;
  }

  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Runner)) return false;
    if (!super.equals(o)) return false;
    Runner runner = (Runner) o;
    return Objects.equals(getBest5Ktime(), runner.getBest5Ktime()) &&
        Objects.equals(getBestHalfMarathonTime(), runner.getBestHalfMarathonTime()) &&
        Objects.equals(getFavoriteRunningEvent(), runner.getFavoriteRunningEvent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBest5Ktime(), getBestHalfMarathonTime(), getFavoriteRunningEvent());
  }
}
