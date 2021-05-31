package p2;

public class InternetMedia implements LoanObserver{

  @Override
  public void update(Loan observable) {
    System.out.println(observable.getInterest());

  }
}
