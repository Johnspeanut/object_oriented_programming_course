package midtermExam.p2;

import java.util.Objects;

public class ElementNode implements ILinkedList {
    private TaxReturn item;
    private ILinkedList rest;

    public ElementNode(TaxReturn item, ILinkedList rest) {
        this.item = item;
        this.rest = rest;
    }


    /**
     * Gets the number of elements in the list.
     *
     * @return THe number of elements in the list.
     */
    @Override
    public Integer count() {
        return 1 + this.rest.count();
    }

    /**
     * Get the item at the head of the list.
     *
     * @return The integer at the head of the list or null if the list is empty.
     */
    @Override
    public TaxReturn getItem() {
        return this.item;
    }

    /**
     * Get the rest of the list.
     *
     * @return The rest of the list or null if the list is empty.
     */
    @Override
    public ILinkedList getRest() {
        return this.rest;
    }

    /**
     * Inserts an element at the head of the list.
     *
     * @param item The item to insert.
     * @return The linked list with the new item at the head.
     */
    @Override
    public ILinkedList insert(TaxReturn item) {
        return new ElementNode(item, this);
    }

    /**
     * Inserts an element at the specified index.
     *
     * @param item  The item to insert.
     * @param index The index to insert at.
     * @return The linked list with the new item inserted.
     */
    @Override
    public ILinkedList insertAt(TaxReturn item, Integer index) {
        if (index.equals(0)) {
            return new ElementNode(item, this);
        } else {
            return new ElementNode(this.item, this.rest.insertAt(item, index - 1));
        }
    }

    public void setNext(ILinkedList node){
        this.rest = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementNode that = (ElementNode) o;
        return Objects.equals(item, that.item) &&
                Objects.equals(rest, that.rest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, rest);
    }

    @Override
    public String toString() {
        return "ElementNode{" +
                "item=" + item +
                ", rest=" + rest +
                '}';
    }
}
