package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<TravelPackage> packages = new ArrayList<>();
        Admin admin = new Admin(1, "Admin", "admin@gmail.com", "0240000000", "admin123");
        UserManagement user = new UserManagement(2, "User", "user@gmail.com", "0500000000", "user123");
        int choice;

        do {
            System.out.println("ADIME TRAVEL BOOKING SYSTEM ");
            System.out.println("1. Admin - Add Travel Package");
            System.out.println("2. Admin - Update Travel Package");
            System.out.println("3. Admin - Remove Travel Package");
            System.out.println("4. View Travel Packages");
            System.out.println("5. User - Login");
            System.out.println("6. User - View My Bookings");
            System.out.print("Enter choice (0-6): ");

            // Exception handling
            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1 -> { // Add Travel Package
                        try {
                            System.out.print("Package ID (integer): ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Destination (String): ");
                            String destination = sc.nextLine();

                            System.out.print("Start Date (YYYY-MM-DD): ");
                            String start = sc.nextLine();

                            System.out.print("End Date (YYYY-MM-DD): ");
                            String end = sc.nextLine();

                            System.out.print("Price (decimal, e.g., 1500.0): ");
                            double price = sc.nextDouble();

                            System.out.print("Available Seats (integer): ");
                            int seats = sc.nextInt();
                            sc.nextLine();

                            TravelPackage tp = new TravelPackage(id, destination, start, end, price, "N/A", seats);
                            admin.addTravelPackage(packages, tp);

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please follow the format:");
                            System.out.println("Integers for IDs/seats, decimals for price, strings for text.");
                            sc.nextLine(); // clear buffer
                        }
                    }

                    case 2 -> { // Update Travel Package
                        try {
                            System.out.print("Package ID to update (integer): ");
                            int id = sc.nextInt();

                            System.out.print("New Price (decimal, e.g., 1400.0): ");
                            double price = sc.nextDouble();

                            System.out.print("New Available Seats (integer): ");
                            int seats = sc.nextInt();
                            sc.nextLine();

                            admin.updateTravelPackage(packages, id, price, seats);

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter numbers correctly.");
                            sc.nextLine();
                        }
                    }

                    case 3 -> { // Remove Travel Package
                        try {
                            System.out.print("Package ID to remove (integer): ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            admin.removeTravelPackage(packages, id);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid integer.");
                            sc.nextLine();
                        }
                    }

                    case 4 -> { // View Packages
                        System.out.println("\nAvailable Travel Packages:");
                        if (packages.isEmpty()) {
                            System.out.println("No packages available.");
                        } else {
                            for (TravelPackage tp : packages) {
                                System.out.println(tp);
                            }
                        }
                    }

                    case 5 -> { // User Login
                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Password: ");
                        String pass = sc.nextLine();

                        if (user.loginUser(email, pass)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Invalid credentials!");
                        }
                    }

                    case 6 -> { // View Bookings
                        user.viewBookings();
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid menu choice! Enter an integer between 0 and 6.");
                sc.nextLine();
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}
