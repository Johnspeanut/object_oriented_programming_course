package agent;


public interface IAgent {
    /**
     * Add listing to agent's current listing collection
     *
     * @param listing the listing
     */
    void addListing(Listing listing);

    /**
     * call this method when successfully make a sale/rental
     * remove this listing from current collection
     * add commission earnings to the total earning amount
     * @param listing the listing that is sold/rented
     */
    void completeListing(Listing listing);

    /**
     * Drop listing.
     * without adjusting earnings
     * @param listing the listing
     * @throws ListingNotFoundException when listing is not found in this collection
     */
    void dropListing(Listing listing) throws ListingNotFoundException;

    /**
     * Gets total portfolio value.
     *
     * @return the total portfolio value
     */
    double getTotalPortfolioValue();

}
