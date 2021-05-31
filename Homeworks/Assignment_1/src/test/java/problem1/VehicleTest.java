package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Vehicle vehicle;
    Owner john = new Owner("John","Lee","9554684821");
    Owner amy = new Owner("Amy","Xu","9556984750");

    @Before
    public void setUp() throws Exception {
        vehicle = new Vehicle(123456,"WA1122",john);
    }

    @Test
    public void getVIN() {
        assertEquals(123456,vehicle.getVin());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("WA1122",vehicle.getLicensePlate());
    }

    @Test
    public void getOwner() {
        assertEquals(john, vehicle.getOwner());
    }

    @Test
    public void setVin() {
        vehicle.setVin(000000);
        assertEquals(000000,vehicle.getVin());
    }

    @Test
    public void setLicensePlate() {
        vehicle.setLicensePlate("WA0087");
        assertEquals("WA0087",vehicle.getLicensePlate());
    }

    @Test
    public void setOwner() {
        vehicle.setOwner(amy);
        assertEquals(amy,vehicle.getOwner());
    }
}