package p2;

import java.util.ArrayList;
import java.util.List;

public class InterestUpdate implements Subject{
  private Loan loan;
  private List<LoanObserver> observerList;


  public InterestUpdate(){
    observerList= new ArrayList<>();
  }

  public void setLoan(Loan newLoan){
    this.loan = newLoan;
  }
  /**
   * add observer to a list of observers
   *
   * @param observer an observer to be added
   */
  @Override
  public void registerObserver(LoanObserver observer) {
    observerList.add(observer);

  }

  /**
   * remove observe from a list of observers
   *
   * @param observer an observer to be removed
   */
  @Override
  public void removeObserver(LoanObserver observer) {
    this.observerList.remove(observer);

  }

  /**
   * notify observer if a model was changed
   */
  @Override
  public void notifyObservers() {
    for(LoanObserver o:this.observerList){
      o.update(this.loan);
    }

  }
}
