package org.example;

import java.util.List;

// inheritance
public class Admin extends UserManagement {

    public Admin(int userID, String name, String email, String phoneNumber, String password) {
        super(userID, name, email, phoneNumber, password);
    }

    public void addTravelPackage(List<TravelPackage> packages, TravelPackage newPackage) {
        packages.add(newPackage);
        System.out.println("Travel package added successfully.");
    }

    public void updateTravelPackage(List<TravelPackage> packages,
                                    int packageID,
                                    double newPrice,
                                    int newSeats) {

        for (TravelPackage tp : packages) {
            if (tp.getPackageID() == packageID) {
                tp.setPrice(newPrice);
                tp.setAvailableSeats(newSeats);
                System.out.println("Travel package updated successfully.");
                return;
            }
        }
        System.out.println("Travel package not found.");
    }

    public void removeTravelPackage(List<TravelPackage> packages, int packageID) {
        packages.removeIf(tp -> tp.getPackageID() == packageID);
        System.out.println("Travel package removed successfully.");
    }
}
