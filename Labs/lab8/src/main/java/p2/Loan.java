package p2;

import java.util.ArrayList;
import java.util.List;
import jdk.internal.loader.AbstractClassLoaderValue.Sub;

public class Loan{
  private String type;
  private double interest;
  private List<LoanObserver> observerList;

  public Loan(String type, double interest) {
    this.type = type;
    this.interest = interest;
    this.observerList = new ArrayList<>();
  }

  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  @Override
  public String toString() {
    return "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';
  }


}
