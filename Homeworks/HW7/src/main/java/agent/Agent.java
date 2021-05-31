package agent;


import java.util.ArrayList;
import java.util.Objects;


/**
 * The type Agent.
 *
 * @param <T> the type parameter
 * @param <E> the type parameter
 */
public class Agent<T extends Property,E extends Contract>{
    /**
     * The constant VALID_LOWER_BOUND.
     */
    public static final Double VALID_LOWER_BOUND = 0.0;
    /**
     * The constant VALID_HIGHER_BOUND.
     */
    public static final Double VALID_HIGHER_BOUND = 1.0;
    private String name;
    private ArrayList<Listing<T,E>> collection;
    private Double commissionRate;
    private Double totalEarnings;

    /**
     * Instantiates a new Agent.
     *
     * @param name           the name
     * @param collection     the collection
     * @param commissionRate the commission rate
     * @param totalEarnings  the total earnings
     * @throws NotValidValueException the not valid value exception
     */
    public Agent(String name, ArrayList<Listing<T,E>> collection, Double commissionRate, Double totalEarnings) throws NotValidValueException {
        this.name = name;
        this.collection = collection;

        this.commissionRate = commissionRate;
        isValidCommissionRate();

        this.totalEarnings = totalEarnings;
        isValidTotalEarning();
    }

    private void isValidCommissionRate() throws NotValidValueException {
        if (this.commissionRate < VALID_LOWER_BOUND || this.commissionRate > VALID_HIGHER_BOUND)
            throw new NotValidValueException();
    }

    private void isValidTotalEarning() throws NotValidValueException {
        if (this.totalEarnings < VALID_LOWER_BOUND)
            throw new NotValidValueException();
    }

    /**
     * Add listing to agent's current listing collection
     *
     * @param listing the listing
     */
    public void addListing(Listing<T, E> listing) {
        this.collection.add(listing);
    }


    /**
     * Complete listing.
     *
     * @param listing the listing
     * @throws ListingNotFoundException the listing not found exception
     */
    public void completeListing(Listing<T,E> listing) throws ListingNotFoundException{
        if (!this.collection.contains(listing))
            throw new ListingNotFoundException();
        this.totalEarnings += listing.getContract().getCommission(this.commissionRate);
        dropListing(listing);
    }

    /**
     * Drop listing.
     * without adjusting earnings
     *
     * @param listing the listing
     * @throws ListingNotFoundException when listing is not found in this collection
     */
    public void dropListing(Listing listing) throws ListingNotFoundException {
        if (!this.collection.contains(listing))
            throw new ListingNotFoundException();
        this.collection.remove(listing);
    }
    public double getTotalPortfolioValue() throws ListingNotFoundException {
        Double totalValue = 0.0;
        for(Listing<T,E> element: this.collection){
            totalValue += element.getContract().getCommission(this.commissionRate);
        }
        return totalValue;
    }
    /**
     * Gets total portfolio value.
     *
     * @return the total portfolio value
     * @throws ListingNotFoundException the listing not found exception
     */
    public double getTotalPortfolioValue1() throws ListingNotFoundException {
        Double totalValue = 0.0;
        for (Listing<T,E> element: this.collection){
            E contract = (E) element.getContract();
            if (contract instanceof Sale){
                Sale contractSale = (Sale) contract;
                totalValue += this.commissionRate * contractSale.getAskingPrice();
            }
            if (contract instanceof Rental){
                Rental contractRental = (Rental) contract;
                totalValue += this.commissionRate * contractRental.getAskingPrice() * contractRental.getTermInMonths();
            }
        }
        return totalValue;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets collection.
     *
     * @return the collection
     */
    public ArrayList<Listing<T, E>> getCollection() {
        return this.collection;
    }

    /**
     * Gets commission rate.
     *
     * @return the commission rate
     */
    public Double getCommissionRate() {
        return this.commissionRate;
    }

    /**
     * Gets total earnings.
     *
     * @return the total earnings
     */
    public Double getTotalEarnings() {
        return this.totalEarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent<?, ?> agent = (Agent<?, ?>) o;
        return Objects.equals(name, agent.name) && Objects.equals(collection, agent.collection) && Objects.equals(commissionRate, agent.commissionRate) && Objects.equals(totalEarnings, agent.totalEarnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, collection, commissionRate, totalEarnings);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "name='" + name + '\'' +
                ", collection=" + collection +
                ", commissionRate=" + commissionRate +
                ", totalEarnings=" + totalEarnings +
                '}';
    }
}
