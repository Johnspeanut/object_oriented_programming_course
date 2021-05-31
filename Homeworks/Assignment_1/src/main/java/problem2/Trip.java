package problem2;

import java.util.Objects;

/**
 * Trip class has start location, end location, start time, and end time.
 * */
public class Trip {
    private String startingLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;
    private static final int SEXAGESIMAL = 60;

    /**
     * Constructor that creates a new trip object with the specified start location, end location, start time,
     * and end time.
     * @param startingLocation - start location of the new Trip object.
     * @param endLocation - end location of the new Trip object.
     * @param startTime - start time of the new Trip.
     * @param endTime - end time of the new Trip.
     * */
    public Trip(String startingLocation, String endLocation, Time startTime, Time endTime){
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the starting location of the Trip.
     * @return the starting location of the Trip.
     * */
    public String getStartingLocation() {
        return startingLocation;
    }

    /**
     * Returns the end location of the Trip.
     * @return the end location of the Trip.
     * */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Returns the starting time of the Trip.
     * @return the starting time of the Trip.
     * */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time of the Trip.
     * @return the end time of the Trip.
     * */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets the start location of the Trip.
     * @param startingLocation - Set the starting location of the Trip object.
     * */
    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    /**
     * Sets the end location of the Trip.
     * @param endLocation - Set the ending location of the Trip object.
     * */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Sets the start time of the Trip.
     * @param startTime - Set the start time of the Trip object.
     * */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the end time of the Trip.
     * @param endTime - Set the end time of the Trip object.
     * */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * Returns the total time of the Trip.
     * @return the total time of the Trip.
     * */
    public Time getDuration(){
        Time endTime = this.getEndTime();
        Time startTime = this.getStartTime();
        int durHour = endTime.getHour() - startTime.getHour();
        int durMinute = timeDifference(endTime.getMinute(),startTime.getMinute());
        int durSecond = timeDifference(endTime.getSecond(),startTime.getSecond());
        return new Time(durHour, durMinute, durSecond);
    }

    /**
     * helper method.
     * @param start - the start time.
     * @param end - the end time.
     * Returns the time difference.
     * @return the time difference.
     * */
    private int timeDifference(int start, int end){
        if (end > start){
            return end - start;
        }else{
            return end + SEXAGESIMAL - start;
        }
    }

}
