package com.flightbooking.model;

public class Ticket {
    // 1. Private fields (Notice how we use Flight and Passenger objects directly as types)
    private String pnr;
    private Flight flight;
    private Passenger passenger;
    private String seatNumber;
    private String bookingStatus; // e.g., "CONFIRMED" or "CANCELLED"

    // 2. Default Constructor
    public Ticket() {
    }

    // 3. Parameterized Constructor
    public Ticket(String pnr, Flight flight, Passenger passenger, String seatNumber, String bookingStatus) {
        this.pnr = pnr;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.bookingStatus = bookingStatus;
    }

    // 4. Getters and Setters
    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }

    // 5. Overridden toString
    @Override
    public String toString() {
        return "====================================\n" +
               "          FLIGHT TICKET             \n" +
               "====================================\n" +
               "PNR: " + pnr + " | Status: " + bookingStatus + "\n" +
               "Seat Number: " + seatNumber + "\n" +
               "Passenger: " + passenger.getName() + " (Age: " + passenger.getAge() + ")\n" +
               "Flight: " + flight.getairline() + " (" + flight.getflightNumber() + ")\n" +
               "Route: " + flight.getsource() + " -> " + flight.getdestination() + "\n" +
               "Departure Time: " + flight.getdepartureTime() + "\n" +
               "Fare Paid: ₹" + flight.getprice() + "\n" +
               "====================================";
    }
}
