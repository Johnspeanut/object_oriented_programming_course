package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    Trip trip;
    Time startTime;
    Time endTime;

    /**
     * Check if two Time objects are equal in data.
     * @return ture if two Time objects have the same data. Otherwise, false.
     * */
    public static boolean timeEquals(Time orignalTime, Object o) {
        if (orignalTime == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return orignalTime.getHour() == time.getHour() &&
                orignalTime.getMinute() == time.getMinute() &&
                orignalTime.getSecond() == time.getSecond();
    }

    @Before
    public void setUp() throws Exception {
        startTime = new Time(9,30,30);
        endTime = new Time(19,50,20);
        trip = new Trip("Seattle", "New York", startTime, endTime);
    }

    @Test
    public void getStartingLocation() {
        assertEquals("Seattle", trip.getStartingLocation());
    }

    @Test
    public void getEndLocation() {
        assertEquals("New York", trip.getEndLocation());
    }

    @Test
    public void getStartTime() {
        timeEquals(new Time(9,30,30), startTime);
    }

    @Test
    public void getEndTime() {
        timeEquals(new Time(19,50,20), endTime);
    }

    @Test
    public void setStartingLocation() {
        trip.setStartingLocation("Los Angeles");
        assertEquals("Los Angeles", trip.getStartingLocation());
    }

    @Test
    public void setEndLocation() {
        trip.setEndLocation("San Francisco");
        assertEquals("San Francisco",trip.getEndLocation());
    }

    @Test
    public void setStartTime() {
        trip.setStartTime(new Time(10,53,11));
        timeEquals(new Time(10,53,11), trip.getStartTime());
    }

    @Test
    public void setEndTime() {
        trip.setEndTime( new Time(16,22,15));
        timeEquals(new Time(16,22,15), trip.getEndTime());
    }

    @Test
    public void getDuration() {
        timeEquals(new Time(10,19,50),trip.getDuration());
    }
}