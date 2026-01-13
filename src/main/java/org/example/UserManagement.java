package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {

    //Encapsulation
    private int userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    protected List<Booking> bookings;

    // Constructor class
    public UserManagement(int userID, String name, String email, String phoneNumber, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    // Register user: boolean for success or failure when registering

    public boolean registerUser(int userID, String name, String email, String phoneNumber, String password) {
        if (name == null || email == null || password == null) {
            return false;
        }
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

        return true;
    }

    // Login method: Abstraction and Encapsulation
    public boolean loginUser(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    // Update profile: Encapsulation
    public void updateProfile(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // View bookings
    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    // Add booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
