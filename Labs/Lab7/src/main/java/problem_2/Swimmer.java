package problem_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Swimmer implements Comparable<Swimmer>{

//  public static void main(String[] args) {
//    List<Double> butterfly50mTimes = Arrays.asList(50.0,60.0,40.0,60.0);
//    List<Double> backstroke50mTimes = Arrays.asList(50.0,60.0,40.0,60.0);
//    List<Double> breastroke50mTimes = Arrays.asList(50.0,60.0,40.0,60.0);
//    List<Double> freestyle50mTimes = Arrays.asList(50.0,60.0,40.0,60.0);
//    List<Double> freestyle50mTimes2 = Arrays.asList(50.0,10.0,0.0,80.0);
//    Swimmer swimmer1 = new Swimmer("John",butterfly50mTimes,backstroke50mTimes,breastroke50mTimes,freestyle50mTimes);
//    Swimmer swimmer2 = new Swimmer("Amy",butterfly50mTimes,backstroke50mTimes,breastroke50mTimes,freestyle50mTimes2);
//    ArrayList<Swimmer> swimmerList = new ArrayList<>();
//    swimmerList.add(swimmer1);
//    swimmerList.add(swimmer2);
//    Collections.sort(swimmerList);
//    for(Swimmer element:swimmerList){
//      System.out.println(element.name);
//    }
//  }
  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breastroke50mTimes;
  private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> butterfly50mTimes,
      List<Double> backstroke50mTimes, List<Double> breastroke50mTimes,
      List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breastroke50mTimes = breastroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified
   * object.
   *
   * <p>The implementor must ensure
   * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This
   * implies that {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws
   * an exception.)
   *
   * <p>The implementor must also ensure that the relation is transitive:
   * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
   *
   * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
   * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
   *
   * <p>It is strongly recommended, but <i>not</i> strictly required that
   * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements
   * the {@code Comparable} interface and violates this condition should clearly indicate this fact.
   *  The recommended language is "Note: this class has a natural ordering that is inconsistent with
   * equals."
   *
   * <p>In the foregoing description, the notation
   * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
   * <i>signum</i> function, which is defined to return one of {@code -1},
   * {@code 0}, or {@code 1} according to whether the value of
   * <i>expression</i> is negative, zero, or positive, respectively.
   *
   * @param swimmer the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   * or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it from being compared to
   *                              this object.
   */
  @Override
  public int compareTo(Swimmer swimmer) {

    return (int) (this.calAverage(freestyle50mTimes) - this.calAverage(swimmer.freestyle50mTimes));
  }

  private double calAverage(List<Double> list){
    double value = 0;
    for(Double element:list){
      value += element;
    }
    return value/list.size();
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreastroke50mTimes() {
    return breastroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

}
