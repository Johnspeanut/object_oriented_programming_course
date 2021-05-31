package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleRoomTest {
    SingleRoom singleRoom;

    @Before
    public void setUp() throws Exception {
        singleRoom = new SingleRoom(120);
    }

    @Test(expected = IllegalPriceException.class)
    public void invalidPrice() throws IllegalPriceException {
        SingleRoom invalidPriceRoom = new SingleRoom(-5);
    }

    @Test
    public void getMaxOccupancy() {
        assertEquals(1,singleRoom.getMaxOccupancy());
    }

    @Test
    public void getPrice() {
        assertEquals(120.0f,singleRoom.getPrice(),0.00001f);
    }

    @Test
    public void getNumGuest() {
        assertEquals(0,singleRoom.getNumGuest());
    }

    @Test
    public void setMaxOccupancy() {
        singleRoom.setMaxOccupancy(2);
        assertEquals(2,singleRoom.getMaxOccupancy());
    }

    @Test
    public void bookRoom() throws IllegalBookException {
        singleRoom.bookRoom(1);
        assertEquals(1,singleRoom.getNumGuest());
    }

    @Test(expected = IllegalBookException.class)
    public void inValidBookRoomUpperBound() throws IllegalBookException {
        singleRoom.bookRoom(2);
    }

    @Test(expected = IllegalBookException.class)
    public void inValidBookRoomLowerBoundZero() throws IllegalBookException {
        singleRoom.bookRoom(0);
    }

    @Test(expected = IllegalBookException.class)
    public void inValidBookRoomLowerBoundNeg() throws IllegalBookException {
        singleRoom.bookRoom(-1);
    }
}