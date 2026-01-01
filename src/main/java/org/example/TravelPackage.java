package org.example;

public class TravelPackage {

    // Attributes
    private int packageID;
    private String destination;
    private String startDate;
    private String endDate;
    private double price;
    private String description;
    private int availableSeats;

    // Constructor
    public TravelPackage(int packageID, String destination, String startDate,
                         String endDate, double price, String description, int availableSeats) {
        this.packageID = packageID;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.description = description;
        this.availableSeats = availableSeats;
    }

    // Getters
    public int getPackageID() {
        return packageID;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters (used by Admin)
    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Business methods
    public boolean checkAvailability(int seatsRequested) {
        return availableSeats >= seatsRequested;
    }

    public void updateDetails(String destination, String startDate, String endDate, double price) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Package ID: " + packageID +
                ", Destination: " + destination +
                ", Dates: " + startDate + " to " + endDate +
                ", Price: " + price +
                ", Available Seats: " + availableSeats;
    }
}

