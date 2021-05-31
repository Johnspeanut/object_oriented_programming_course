package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    Time time;

    @Before
    public void setUp() throws Exception {
        time = new Time(10,39,50);

    }

    @Test
    public void getHour() {
        assertEquals(10,time.getHour());
    }

    @Test
    public void setHour() {
        time.setHour(12);
        assertEquals(12,time.getHour());
    }

    @Test
    public void getMinute() {
        assertEquals(39,time.getMinute());
    }

    @Test
    public void setMinute() {
        time.setMinute(00);
        assertEquals(00,time.getMinute());
    }

    @Test
    public void getSecond() {
        assertEquals(50,time.getSecond());
    }

    @Test
    public void setSecond() {
        time.setSecond(01);
        assertEquals(01,time.getSecond());
    }

}