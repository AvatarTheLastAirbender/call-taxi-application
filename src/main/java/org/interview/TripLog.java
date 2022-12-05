package org.interview;

public class TripLog {
    private static long id = 0;
    private final long tripNumber;
    private final long customerId;
    private final char pickUpLocation;
    private final char dropLocation;
    private final Taxi taxi;
    private int earning;
    private final int pickUpTime;

    public TripLog(Taxi taxi, long customerId, char pickUpLocation, char dropLocation, int pickUpTime) {
        this.pickUpTime = pickUpTime;
        this.tripNumber = ++id;
        this.taxi = taxi;
        this.customerId = customerId;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
    }

    public int getEarning() {
        int distanceBetweenPickUpAndDrop = Math.abs((this.pickUpLocation - '0') - (this.dropLocation - '0')) * 15;
        earning = ((distanceBetweenPickUpAndDrop - 5) * 10) + 100;
        return earning;
    }

    public int getTravelTime() {
        return Math.abs((this.pickUpLocation - '0') - (this.dropLocation - '0'));
    }

    @Override
    public String toString() {
        return "----------------------------------------------------\n" +
                "Trip Number = " + this.tripNumber + ",\n" +
                "Customer Id : " + this.customerId + ",\n" +
                "Taxi : " + this.taxi.getTaxiId() + ",\n" +
                "Pickup Location : " + this.pickUpLocation + ",\n" +
                "Drop Location : " + this.dropLocation + ",\n" +
                "PickUp Time : " + this.pickUpTime + ",\n" +
                "Earning : Rs." + this.earning + "\n" +
                "----------------------------------------------------";
    }
}
