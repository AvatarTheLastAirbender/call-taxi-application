package org.interview;

import java.util.Scanner;

/**
 * <h2>Design a Call taxi booking application</h2><br>
 * -There are n number of taxi’s. For simplicity, assume 4. But it should work for any
 * number of taxi’s.<br>
 * -The are 6 points(A,B,C,D,E,F)<br>
 * -All the points are in a straight line, and each point is 15kms away from the
 * adjacent points.<br>
 * -It takes 60 mins to travel from one point to another<br>
 * -Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the
 * subsequent kilometers.<br>
 * -For simplicity, time can be entered as absolute time. Eg: 9hrs, 15hrs etc.<br>
 * -All taxi’s are initially stationed at A.<br>
 * -When a customer books a Taxi, a free taxi at that point is allocated<br>
 * -If no free taxi is available at that point, a free taxi at the nearest point is
 * allocated.<br>
 * -If two taxi’s are free at the same point, one with lower earning is allocated<br>
 * -Note that the taxi only charges the customer from the pickup point to the drop<br>
 * point. Not the distance it travels from an adjacent point to pickup the customer.<br>
 * -If no taxi is free at that time, booking is rejected<br>
 * <br>
 * <h3>Design modules for</h3>
 * 1) Call taxi booking<br>
 * Input 1:<br>
 * Customer ID: 1<br>
 * Pickup Point: A<br>
 * Drop Point: B<br>
 * Pickup Time: 9<br>
 * Output 1:<br>
 * Taxi can be allotted.<br>
 * Taxi-1 is allotted<br>
 * Input 2:<br>
 * Customer ID: 2<br>
 * Pickup Point: B<br>
 * Drop Point: D<br>
 * Pickup Time: 9<br>
 * Output 1:<br>
 * Taxi can be allotted.<br>
 * Taxi-2 is allotted<br>
 * (Note: Since Taxi-1 would have completed its journey when second booking is done,<br>
 * so Taxi-2 from nearest point A which is free is allocated)<br>
 * Input 3:<br>
 * Customer ID: 3<br>
 * Pickup Point: B<br>
 * Drop Point: C<br>
 * Pickup Time: 12<br>
 * Output 1:<br>
 * Taxi can be allotted.<br>
 * Taxi-1 is allotted<br>
 * 2) Display the Taxi details<br>
 * Taxi No: Total Earnings:<br>
 * BookingID CustomerID From To PickupTime DropTime Amount<br>
 * <p>
 * Output:<br>
 * Taxi-1 Total Earnings: Rs. 400<br>
 * 1 1 A B 9 10 200<br>
 * 3 3 B C 12 13 200<br>
 * Taxi-2 Total Earnings: Rs. 350<br>
 * 2 2 B D 9 11 350<br>
 * These were just sample inputs. It should work for any input that they give.<br>
 * Those who finished both the modules within 3 hours and if it worked for all the<br>
 * inputs they give, those candidates were given extra modules to work with.<br>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- Welcome --------------");
        Scanner sc = new Scanner(System.in);
        char pickUpLocation, dropLocation;
        int pickUpTime;
        while (true) {
            System.out.println("1 -> Book Taxi \n" +
                    "2 -> Locate All Taxis\n" +
                    "3 -> Print all trips\n" +
                    "4 -> Exit");
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter PickUp location (A - B - C - D - E - F)");
                    pickUpLocation = sc.next().toUpperCase().charAt(0);
                    System.out.println("Enter PickUp location (A - B - C - D - E - F)");
                    dropLocation = sc.next().toUpperCase().charAt(0);
                    System.out.println("Enter PickUp time");
                    pickUpTime = sc.nextInt();
                    Controller.bookTaxi(pickUpLocation, dropLocation,pickUpTime);
                    break;
                case 2:
                    Controller.locateAllTaxis();
                    break;
                case 3:
                    Controller.printBookingLog();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}