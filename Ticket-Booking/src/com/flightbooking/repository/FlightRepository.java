package com.flightbooking.repository;

import com.flightbooking.model.Flight;

public class FlightRepository {
    // Fixed array capacity instead of a Collection List
    private Flight[] flights;
    private int flightCount;

    public FlightRepository() {
        flights = new Flight[10]; // Can store up to 10 flights
        flightCount = 0;
        seedMockFlights();
    }

    // Pre-load baseline flights into the array
    private void seedMockFlights() {
        addFlight(new Flight("AI101", "Air India", "DELHI", "MUMBAI", "06:00 AM", "4500", "5"));
        addFlight(new Flight("6E202", "IndiGo", "MUMBAI", "BANGALORE", "09:30 AM", "3800", "12"));
        addFlight(new Flight("UK303", "Vistara", "DELHI", "GOA", "02:15 PM", "6200", "0"));
        addFlight(new Flight("SG404", "SpiceJet", "BANGALORE", "KOLKATA", "07:45 PM", "5100", "8"));
    }

    // Helper method to insert a flight into the array
    public void addFlight(Flight flight) {
        if (flightCount < flights.length) {
            flights[flightCount] = flight;
            flightCount++;
        }
    }

    // Returns the raw array of flights
    public Flight[] getAllFlights() {
        return flights;
    }

    // Returns how many array positions contain actual flight data
    public int getFlightCount() {
        return flightCount;
    }

    // Loop through array to find a specific flight code match
    public Flight findByFlightNumber(String flightNumber) {
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getflightNumber().equalsIgnoreCase(flightNumber)) {
                return flights[i];
            }
        }
        return null;
    }
}
