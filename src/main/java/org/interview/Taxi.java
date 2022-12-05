package org.interview;

public class Taxi {
    private static long taxiCount = 0;
    private final long taxiId;
    private char currentLocation;
    private int freeTime;
    private int totalEarning;

    public Taxi() {
        this.currentLocation = 'A';
        this.freeTime = 6;
        this.taxiId = ++taxiCount;
        this.totalEarning = 0;
    }

    public long getTaxiId() {
        return taxiId;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------\n" +
                "Taxi : " + this.taxiId + ",\n" +
                "Current Location : " + this.currentLocation + ",\n" +
                "Next Free Time : " + this.freeTime + ",\n" +
                "Earning : " + this.totalEarning + "\n" +
                "-----------------------------------------------------";
    }
}
