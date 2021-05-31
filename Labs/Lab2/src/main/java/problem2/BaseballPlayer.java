package problem2;

import java.util.Objects;

public class BaseballPlayer extends Athlete{
  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
                        Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight, String team, Double averageBatting,
                        Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public String getTeam() {
    return team;
  }

  public Double getAverageBatting() {
    return averageBatting;
  }

  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BaseballPlayer)) return false;
    if (!super.equals(o)) return false;
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(getTeam(), that.getTeam()) &&
        Objects.equals(getAverageBatting(), that.getAverageBatting()) &&
        Objects.equals(getSeasonHomeRuns(), that.getSeasonHomeRuns());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTeam(), getAverageBatting(), getSeasonHomeRuns());
  }
}
