package org.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private static final List<Taxi> taxis = Arrays.stream(new int[4]).mapToObj(i -> new Taxi()).collect(Collectors.toList());
    private static final ArrayList<TripLog> tripLog = new ArrayList<>();
    private static long customerId = 0;

    private static List<Taxi> getFreeTaxis(char pickUpLocation, int pickUpTime) {
        return taxis.stream().filter(taxi ->
                taxi.getFreeTime() <= pickUpTime
                        && Math.abs((taxi.getCurrentLocation() - '0') - (pickUpLocation - '0')) <= pickUpTime - taxi.getFreeTime()
        ).sorted(Comparator.comparingInt(Taxi::getTotalEarning)).collect(Collectors.toList());
    }

    public static void bookTaxi(char pickUpLocation, char dropLocation, int pickUpTime) {
        List<Taxi> freeTaxis = getFreeTaxis(pickUpLocation, pickUpTime);
        if (freeTaxis.size() == 0) {
            System.out.println("Booking not available");
            return;
        }
        Taxi availableTaxi = null;

        int min = Integer.MAX_VALUE, distanceBetweenCurrentLocationToPickUpLocation;
        for (Taxi taxi : freeTaxis) {
            distanceBetweenCurrentLocationToPickUpLocation = Math.abs((taxi.getCurrentLocation() - pickUpLocation) - 'A') * 15;
            if (distanceBetweenCurrentLocationToPickUpLocation < min) {
                min = distanceBetweenCurrentLocationToPickUpLocation;
                availableTaxi = taxi;
            }
        }

        TripLog currentTripLog = new TripLog(availableTaxi, ++customerId, pickUpLocation, dropLocation, pickUpTime);
        Controller.tripLog.add(currentTripLog);
        availableTaxi.setTotalEarning(availableTaxi.getTotalEarning() + currentTripLog.getEarning());
        availableTaxi.setCurrentLocation(dropLocation);
        availableTaxi.setFreeTime(pickUpTime+currentTripLog.getTravelTime());
        System.out.println("Taxi " + availableTaxi.getTaxiId() + " allocated");
    }

    public static void locateAllTaxis() {
        System.out.println("---------------------------------------------------------------------------");
        taxis.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void printBookingLog() {
        System.out.println("---------------------------------------------------------------------------");
        tripLog.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");
    }
}
