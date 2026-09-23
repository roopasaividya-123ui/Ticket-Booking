package com.flightbooking.model;

public class Flight {
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String price;
    private String availableSeats;

    public Flight(String flightNumber, String airline, String source, String destination, String departureTime, String price, String availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getairline() {
        return airline;
    }
    public void setairline(String airline) {
        this.airline = airline;
    }

    public String getsource() {
        return source;
    }
    public void setsource(String source) {
        this.source = source;
    }

    public String getdestination() {
        return destination;
    }
    public void setdestination(String destination) {
        this.destination = destination;
    }

    public String getdepartureTime() {
        return departureTime;
    }
    public void setdepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Backward-compatible aliases used by the original project code
    public String getflightNumber() {
        return getFlightNumber();
    }
    public void setflightNumber(String flightNumber) {
        setFlightNumber(flightNumber);
    }

    public String getavailableSeats() {
        return getAvailableSeats();
    }
    public void getavailableSeats(String availableSeats) {
        setAvailableSeats(availableSeats);
    }

    @Override
    public String toString() {
        return "Flight [" + flightNumber + "] " + airline + " | " + source + " -> " + destination +
               " | Departs: " + departureTime + " | Price: ₹" + price + " | Seats Left: " + availableSeats;
    }
}

