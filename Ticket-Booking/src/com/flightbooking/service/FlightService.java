package com.flightbooking.service;

import com.flightbooking.model.Flight;
import com.flightbooking.repository.FlightRepository;

public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Prints available paths directly in terminal clean lists format
    public void displayAllFlights() {
        Flight[] allFlights = flightRepository.getAllFlights();
        int count = flightRepository.getFlightCount();

        System.out.println("\n--- AVAILABLE FLIGHT LIST ---");
        for (int i = 0; i < count; i++) {
            System.out.println(allFlights[i].toString());
        }
    }

    // Print routes filtering matching source and destination pairs
    public void searchFlights(String source, String destination) {
        Flight[] allFlights = flightRepository.getAllFlights();
        int count = flightRepository.getFlightCount();
        boolean found = false;

        System.out.println("\n--- SEARCH RESULTS (" + source + " -> " + destination + ") ---");
        for (int i = 0; i < count; i++) {
            if (allFlights[i].getsource().equalsIgnoreCase(source) &&
                allFlights[i].getdestination().equalsIgnoreCase(destination)) {
                System.out.println(allFlights[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching flight routes discovered.");
        }
    }

    // Check seating parameters limits conversion tracking
    public boolean isSeatAvailable(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight != null) {
            int seats = Integer.parseInt(flight.getAvailableSeats());
            return seats > 0;
        }
        return false;
    }

    // Deduct seats balance counts decrement operations
    public boolean decrementSeat(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight != null) {
            int currentSeats = Integer.parseInt(flight.getAvailableSeats());
            if (currentSeats > 0) {
                flight.setAvailableSeats(String.valueOf(currentSeats - 1));
                return true;
            }
        }
        return false;
    }

    // Increase seats capacity tracking values properties parameters increments
    public void incrementSeat(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight != null) {
            int currentSeats = Integer.parseInt(flight.getAvailableSeats());
            flight.setAvailableSeats(String.valueOf(currentSeats + 1));
        }
    }
}

