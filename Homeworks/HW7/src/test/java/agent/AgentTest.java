package agent;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AgentTest {
    private Agent<Property, Contract> testcase1;
    private Agent<Property, Contract> testcase11;
    private Agent<Residential, Sale> testcase2;
    private Agent<Residential, Rental> testcase3;
    private Listing<Property,Contract> listing1;
    private Listing<Property,Contract> listing11;
    private Listing<Residential,Sale> listing2;
    private Listing<Residential,Rental> listing3;

    private Residential testResidential;
    private Commercial testCommercial;

    private Rental testRental;
    private Sale testSale;

    @Before
    public void setUp() throws Exception {
        testSale = new Sale(150.12,false);
        testRental = new Rental(400.2,true,12);
        testCommercial = new Commercial("address1",65,2,true);
        testResidential = new Residential("address2",130,5,2);

        listing3 = new Listing<>(testResidential,testRental);
        listing11 = new Listing<>(testResidential,testSale);
        listing1 = new Listing<>(testCommercial,testSale);


        ArrayList<Listing<Property,Contract>> testList1 = new ArrayList();
        ArrayList<Listing<Residential,Sale>> testList2 = new ArrayList<>();
        ArrayList<Listing<Residential,Rental>> testList3 = new ArrayList<>();
        testcase1 = new Agent<>("name1",testList1,0.03,105.0);
        testcase11 = new Agent<>("name1",testList1,0.03,105.0);
        testcase2 = new Agent<>("name2",testList2,0.03,199.5);
        testcase3 = new Agent<>("name3",testList3,0.02,1000.1);

        }

    @Test (expected = NotValidValueException.class)
    public void isValidCommission() throws NotValidValueException {
        ArrayList<Listing<Property,Contract>> testList1 = new ArrayList();
        Agent tempCase = new Agent<Property,Contract>("name1",testList1,5.0,105.0);
    }

    @Test (expected = NotValidValueException.class)
    public void isValidCommission2() throws NotValidValueException {
        ArrayList<Listing<Property,Contract>> testList1 = new ArrayList();
        Agent tempCase = new Agent<Property,Contract>("name1",testList1,-5.0,105.0);
    }

    @Test (expected = NotValidValueException.class)
    public void isValidCommission3() throws NotValidValueException {
        ArrayList<Listing<Property,Contract>> testList1 = new ArrayList();
        Agent tempCase = new Agent<Property,Contract>("name1",testList1,0.3,-105.0);
    }

    @Test
    public void addListing() {
        testcase1.addListing(listing1);
        assertTrue(testcase1.getCollection().contains(listing1));
    }

    @Test
    public void dropListing() throws ListingNotFoundException {
        testcase1.addListing(listing1);
        testcase1.addListing(listing11);
        testcase1.dropListing(listing1);
        assertFalse(testcase1.getCollection().contains(listing1));
    }

    @Test (expected = ListingNotFoundException.class)
    public void invalidDrop()throws ListingNotFoundException{
        testcase1.dropListing(listing11);
    }

    @Test
    public void getTotalPortfolioValue() throws ListingNotFoundException {
        testcase1.addListing(listing1);
        testcase1.addListing(listing11);
        assertEquals(9.0072,testcase1.getTotalPortfolioValue(),2);
        testcase3.addListing(listing3);
        assertEquals(96.048,testcase3.getTotalPortfolioValue(),2);
    }

    @Test
    public void testEquals() {
        assertTrue(testcase1.equals(testcase1));
        testcase1.addListing(listing1);
        testcase1.addListing(listing11);
        assertTrue(testcase1.equals(testcase11));
        assertFalse(testcase1.equals(null));
        assertFalse(testcase1.equals(""));

    }

    @Test
    public void testHashCode() {
        int testNum = testcase1.hashCode();
        assertEquals(testNum,testcase1.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Agent{name='name1', collection=[], commissionRate=0.03, totalEarnings=105.0}",testcase1.toString());
    }

    @Test
    public void getName() {
        assertEquals("name1",testcase1.getName());
    }

    @Test
    public void getCollection() {
        ArrayList<Listing<Property,Contract>> testList1 = new ArrayList();
        assertEquals(testList1,testcase1.getCollection());
    }

    @Test
    public void getCommissionRate() {
        assertEquals(0.03,testcase1.getCommissionRate(),2);
    }

    @Test
    public void getTotalEarnings() {
        assertEquals(105.0,testcase1.getTotalEarnings(),1);
    }

    @Test
    public void completeListing() throws ListingNotFoundException {
        testcase1.addListing(listing1);
        testcase1.addListing(listing11);
        testcase1.completeListing(listing11);
        assertEquals(109.5036,testcase1.getTotalEarnings(),2);
        testcase3.addListing(listing3);
        testcase3.completeListing(listing3);
        assertEquals(1096.1480,testcase3.getTotalEarnings(),2);
    }
}