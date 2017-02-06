package com.mayurphadte.checkerappiitb2017;

/**
 * Created by mayurphadte on 28/01/17.
 */

public class User {

    private String timeStamp;
    private String time2Stamp;
    private String boardingPoint;
    private String destination;
    private Boolean entered;

    public User() {
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTime2Stamp() {
        return time2Stamp;
    }

    public void setTime2Stamp(String time2Stamp) {
        this.time2Stamp = time2Stamp;
    }

    public String getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getEntered() {
        return entered;
    }

    public void setEntered(Boolean entered) {
        this.entered = entered;
    }

    public User(String timeStamp, String time2Stamp, String boardingPoint, String destination, Boolean entered) {

        this.timeStamp = timeStamp;
        this.time2Stamp = time2Stamp;
        this.boardingPoint = boardingPoint;
        this.destination = destination;
        this.entered = entered;
    }
}
