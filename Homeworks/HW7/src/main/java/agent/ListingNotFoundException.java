package agent;

class ListingNotFoundException extends Exception {
    ListingNotFoundException(){
        super("Listing not found in this collection");
    }
}
