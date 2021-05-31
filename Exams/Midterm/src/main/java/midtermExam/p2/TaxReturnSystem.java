package midtermExam.p2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A class that can implement the ADT.
 */
public class TaxReturnSystem implements ITaxReturnSystem{
  private ILinkedList front;
  private static double OVERPAID_CUTOFF = 500.0;

  private TaxReturnSystem(){
    this.front = new EmptyNode();
  }

  public static TaxReturnSystem createEmpty(){
    return new TaxReturnSystem();
  }

  /**
   * Checks if the system is empty.
   *
   * @return true if it is empty.O.W., false.
   */
  @Override
  public boolean isEmpty() {
    return this.front.count().equals(0);
  }

  /**
   * Counts the number of TaxReturns in the systems.
   *
   * @return the count number.
   */
  @Override
  public int count() {
    return this.front.count();
  }

  /**
   * Adds a TaxReturn to the system.
   *
   * @param taxReturn the item to be added.
   */
  @Override
  public void add(TaxReturn taxReturn) {
    this.front = this.front.insertAt(taxReturn,this.count());
  }

  /**
   * Removes a TaxReturn from the system.
   *
   * @param taxReturn The TaxReturn to be removed.
   * @throws TaxReturnNotFoundException if not found in the system.
   */
  @Override
  public void remove(TaxReturn taxReturn) throws TaxReturnNotFoundException {
    if(!this.isInSystem(taxReturn)){
      throw new TaxReturnNotFoundException("Item not found");
    }
    ILinkedList curr = this.front.getRest();
    ILinkedList slow = this.front;
    while(curr != null){
      if(curr.getItem().equals(taxReturn)){
        slow.setNext(curr.getRest());
        return;
      }
      curr = curr.getRest();
      slow = slow.getRest();
    }
  }

  /**
   * Checks if a specific TaxReturn in the system.
   *
   * @param taxReturn to be checked.
   * @return true if it is in the system.
   */
  @Override
  public boolean isInSystem(TaxReturn taxReturn) {
    ILinkedList curr = this.front;
    while(curr != null){
      if(curr.getItem().equals(taxReturn)){
        return true;
      }
      curr = curr.getRest();
    }
    return false;
  }

  /**
   * Checks if the TaxReturn with the specified date/
   *
   * @param taxReturn The TaxReturn to be checke.
   * @param date      date.
   * @return True if it is in the system.
   * @throws TaxReturnNotFoundException if doesn't exist.
   */
  @Override
  public boolean hasSpecifiedDate(TaxReturn taxReturn, LocalDate date)
      throws TaxReturnNotFoundException {
    if(this.isInSystem(taxReturn) && taxReturn.getDateTaxReturnFilled().equals(date)){
      return true;
    }else{
      throw new TaxReturnNotFoundException("Item not found");
    }
  }

  /**
   * /** Checks if a specified TaxReturn has been processed.
   *
   * @param taxReturn The TaxReturn to be checked.
   * @return true if it exist.
   * @throws TaxReturnNotFoundException if not found.
   */
  @Override
  public boolean hasBeenProcessed(TaxReturn taxReturn) throws TaxReturnNotFoundException {
    if(this.isInSystem(taxReturn) && taxReturn.getTaxApplicationProcessed()){
      return true;
    }else{
      throw new TaxReturnNotFoundException("Item not found");
    }
  }

  /**
   * Finds all the TaxReturns who have overpaid mroe than $500.
   *
   * @return a linked list that meet the requirements.
   */
  @Override
  public ILinkedList findOverPaid() {
    ILinkedList head = new EmptyNode();
    ILinkedList curr = this.front;
    while(curr != null){
      if(curr.getItem().getAmountOfTaxesOverpaid() > OVERPAID_CUTOFF){
        head.setNext(curr);
      }
      curr = curr.getRest();
    }
    return head.getRest();
  }

  /**
   * Gets a TaxReturn based on the TIN.
   *
   * @param tin The TIN.
   * @return TaxReturn
   * @throws InvalidTaxIdentificationNumberException if the number doesn't exist.
   */
  @Override
  public TaxReturn getTaxReturn(String tin) throws InvalidTaxIdentificationNumberException {
    ILinkedList curr = this.front;
    while(curr != null){
      if(curr.getItem().getTIN().equals(tin)){
        return curr.getItem();
      }
      curr = curr.getRest();
    }
    throw new InvalidTaxIdentificationNumberException("Invalid TIN");
  }

  @Override
  public String toString() {
    return "TaxReturnSystem{" +
        "front=" + front +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TaxReturnSystem)) {
      return false;
    }
    TaxReturnSystem that = (TaxReturnSystem) o;
    return Objects.equals(front, that.front);
  }

  @Override
  public int hashCode() {
    return Objects.hash(front);
  }
}

