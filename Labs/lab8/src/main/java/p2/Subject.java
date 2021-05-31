package p2;

public interface Subject {

  /**
   *  add observer to a list of observers
   * @param observer  an observer to be added
   */
  void registerObserver(LoanObserver observer);

  /**
   * remove observe from a list of observers
   * @param observer an observer to be removed
   */
  void removeObserver(LoanObserver observer);

  /**
   * notify observer if a model was changed
   */
  void notifyObservers();


}
