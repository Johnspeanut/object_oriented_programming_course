package simpleRecursiveList;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();

    /**
     * Checks if the list contains an element.
     * @param element The element to be checked.
     * @return true if the element in the linked list. O.W.,false.
     */
    boolean contains(Integer element);

    /**
     * Find item at index.
     * @param index The index we examine.
     * @return item at the index.
     */
    Integer elementAt(Integer index);
}
