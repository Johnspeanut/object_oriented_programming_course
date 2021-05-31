package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleRoomTest {
    DoubleRoom doubleRoom;

    @Before
    public void setUp() throws Exception {
        doubleRoom = new DoubleRoom(260);
    }

    @Test(expected = IllegalPriceException.class)
    public void invalidPrice() throws IllegalPriceException {
        DoubleRoom invalidPriceRoom = new DoubleRoom(-5);
    }

    @Test
    public void getMaxOccupancy() {
        assertEquals(2,doubleRoom.getMaxOccupancy());
    }

    @Test
    public void getPrice() {
        assertEquals(260.0f,doubleRoom.getPrice(),0.000001f);
    }

    @Test
    public void getNumGuest() {
        assertEquals(0,doubleRoom.getNumGuest());
    }

    @Test
    public void setMaxOccupancy() {
        doubleRoom.setMaxOccupancy(3);
        assertEquals(3,doubleRoom.getMaxOccupancy());
    }

    @Test
    public void bookRoom() throws IllegalBookException {
        doubleRoom.bookRoom(2);
        assertEquals(2,doubleRoom.getNumGuest());
    }

    @Test
    public void bookRoomOneGuest() throws IllegalBookException {
        doubleRoom.bookRoom(1);
        assertEquals(1,doubleRoom.getNumGuest());
    }

    @Test(expected = IllegalBookException.class)
    public void bookRoomZeroGuest() throws IllegalBookException {
        doubleRoom.bookRoom(0);
    }

    @Test(expected = IllegalBookException.class)
    public void bookRoomNegativeGuest() throws IllegalBookException {
        doubleRoom.bookRoom(-1);
    }

    @Test(expected = IllegalBookException.class)
    public void bookRoomGreaterGuest() throws IllegalBookException {
        doubleRoom.bookRoom(3);
    }
}