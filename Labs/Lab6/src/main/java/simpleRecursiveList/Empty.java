package simpleRecursiveList;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {

    @Override
    public Integer size() {
        return 0;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public List add(Integer element) {
        return new Cons(element, this);
    }

    @Override
    public Integer last() throws InvalidCallException {
        throw new InvalidCallException("Called last() on empty!");
    }

    /**
     * Checks if the list contains an element.
     *
     * @param element The element to be checked.
     * @return true if the element in the linked list. O.W.,false.
     */
    @Override
    public boolean contains(Integer element) {
        return false;
    }

    /**
     * Find item at index.
     *
     * @param index The index we examine.
     * @return item at the index.
     */
    @Override
    public Integer elementAt(Integer index) {
        return null;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }
}
