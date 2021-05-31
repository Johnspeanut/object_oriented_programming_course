package midtermExam.p2;

import java.time.LocalDate;

/**
 * An interface requires ADT  a couple of APIs.
 */
public interface ITaxReturnSystem {

  /**
   * Checks if the system is empty.
   * @return true if it is empty.O.W., false.
   */
  boolean isEmpty();

  /**
   * Counts the number of TaxReturns in the systems.
   * @return the count number.
   */
  int count();

  /**
   * Adds a TaxReturn to the system.
   * @param taxReturn the item to be added.
   */
  void add(TaxReturn taxReturn);

  /**
   * Removes a TaxReturn from the system.
   * @param taxReturn The TaxReturn to be removed.
   * @throws TaxReturnNotFoundException if not found in the system.
   */
  void remove(TaxReturn taxReturn) throws TaxReturnNotFoundException;

  /**
   * Checks if a specific TaxReturn in the system.
   * @param taxReturn to be checked.
   * @return true if it is in the system.
   */
  boolean isInSystem(TaxReturn taxReturn);

  /**
   * Checks if the TaxReturn with the specified date/
   * @param taxReturn The TaxReturn to be checke.
   * @param date date.
   * @return True if it is in the system.
   * @throws TaxReturnNotFoundException if doesn't exist.
   */
  boolean hasSpecifiedDate(TaxReturn taxReturn, LocalDate date) throws TaxReturnNotFoundException;

  /**
   /**
   * Checks if a specified TaxReturn has been processed.
   * @param taxReturn The TaxReturn to be checked.
   * @return true if it exist.
   * @throws TaxReturnNotFoundException if not found.
   */
  boolean hasBeenProcessed(TaxReturn taxReturn) throws TaxReturnNotFoundException;

  /**
   * Finds all the TaxReturns who have overpaid mroe than $500.
   * @return a linked list that meet the requirements.
   */
  ILinkedList findOverPaid();

  /**
   * Gets a TaxReturn based on the TIN.
   * @param tin The TIN.
   * @return TaxReturn
   * @throws InvalidTaxIdentificationNumberException if the number doesn't exist.
   */
  TaxReturn getTaxReturn(String tin) throws InvalidTaxIdentificationNumberException;

}
