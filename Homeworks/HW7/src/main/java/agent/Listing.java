package agent;

import java.util.Objects;

/**
 * A class representing listing with two generic parameters.
 * @param <T> Class or subclass of Property.
 * @param <E> Class or subclass of Contract.
 */
public class Listing<T extends Property,E extends Contract> {
    private T property;
    private E contract;

    /**
     * Constructor for the listing class.
     * @param property Property object.
     * @param contract Construct object.
     */
    public Listing(T property, E contract) {
        this.property = property;
        this.contract = contract;
    }

    /**
     * Gets property
     * @return property.
     */
    public T getProperty() {
        return this.property;
    }

    /**
     * Gets contract.
     * @return contract.
     */
    public E getContract() {
        return this.contract;
    }

    /**
     * Override the equals method.
     * @param o Object to be compared.
     * @return true if two objects are equals in attributes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Listing)) {
            return false;
        }
        Listing<?, ?> listing = (Listing<?, ?>) o;
        return Objects.equals(property, listing.property) && Objects
            .equals(contract, listing.contract);
    }

    /**
     * Override hashcode.
     * @return hashcode value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(property, contract);
    }

    /**
     * Override toString method.
     * @return string of the object.
     */
    @Override
    public String toString() {
        return "Listing{" +
            "property=" + property +
            ", contract=" + contract +
            '}';
    }
}

