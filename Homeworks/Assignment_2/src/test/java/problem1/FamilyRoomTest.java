package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyRoomTest {
    FamilyRoom familyRoom;

    @Before
    public void setUp() throws Exception {
        familyRoom = new FamilyRoom(500);
    }

    @Test(expected = IllegalPriceException.class)
    public void invalidPrice() throws IllegalPriceException {
        FamilyRoom invalidFamilyRoom = new FamilyRoom(0);
    }

    @Test
    public void getMaxOccupancy() {
        assertEquals(4,familyRoom.getMaxOccupancy());
    }

    @Test
    public void getPrice() {
        assertEquals(500.0f,familyRoom.getPrice(),0.000001f);
    }

    @Test
    public void getNumGuest() {
        assertEquals(0,familyRoom.getNumGuest());
    }

    @Test
    public void setMaxOccupancy() {
        familyRoom.setMaxOccupancy(6);
        assertEquals(6,familyRoom.getMaxOccupancy());
    }

    @Test
    public void bookRoom() throws IllegalBookException {
        familyRoom.bookRoom(3);
        assertEquals(3,familyRoom.getNumGuest());
    }

    @Test(expected = IllegalBookException.class)
    public void invalidBookRoomLowerBound() throws IllegalBookException {
        familyRoom.bookRoom(0);
    }

    @Test(expected = IllegalBookException.class)
    public void invalidBookRoomUpperBound() throws IllegalBookException {
        familyRoom.bookRoom(6);
    }
}