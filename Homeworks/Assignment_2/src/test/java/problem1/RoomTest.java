package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Room room;

    @Before
    public void setUp() throws Exception {
        room = new Room(200);
    }

    @Test (expected = IllegalPriceException.class)
    public void invalidPrice() throws IllegalPriceException {
        Room roomInvalid = new Room(-5);
    }

    @Test
    public void getMaxOccupancy() {
        assertEquals(0,room.getMaxOccupancy());
    }

    @Test
    public void getPrice() {
        assertEquals(200.0f,room.getPrice(),0.0001f);
    }

    @Test
    public void getNumGuest() {
        assertEquals(0,room.getNumGuest());
    }

    @Test
    public void setMaxOccupancy() {
        room.setMaxOccupancy(2);
        assertEquals(2,room.getMaxOccupancy());
    }

    @Test(expected = IllegalBookException.class)
    public void invalidBookRoomUpperBound() throws IllegalBookException {
        room.bookRoom(3);
        assertEquals(3,room.getNumGuest());
    }

    @Test(expected = IllegalBookException.class)
    public void invalidBookRoomLowerBound() throws IllegalBookException {
        room.bookRoom(0);
        assertEquals(0,room.getNumGuest());
    }

    @Test
    public void validBookRoom() throws IllegalBookException {
        room.setMaxOccupancy(2);
        room.bookRoom(2);
        assertEquals(2,room.getNumGuest());
    }

    @Test(expected = IllegalBookException.class)
    public void invalidBookRoomOtherGuestAlreadyIn() throws IllegalBookException {
        room.setMaxOccupancy(2);
        room.bookRoom(1);
        room.bookRoom(1);
    }

}