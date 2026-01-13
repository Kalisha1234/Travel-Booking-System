package org.example;

public class Booking {
    private int bookingId;
    private String bookingDate;
    private int numberOfSeats;
    private String status;

    public Booking(int bookingId, String bookingDate, int numberOfSeats, String status) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking Details \n" +
                "BookingId= " + bookingId +
                ", Booking Date:'" + bookingDate + '\'' +
                ", Number Of Seats: " + numberOfSeats +
                ", Status: '" + status + '\'' +
                '}';
    }
}

