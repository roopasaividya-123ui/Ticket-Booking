package com.flightbooking.service;

import com.flightbooking.model.Flight;
import com.flightbooking.model.Passenger;
import com.flightbooking.model.Ticket;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;

public class BookingService {
    private BookingRepository bookingRepository;
    private FlightRepository flightRepository;
    private FlightService flightService;
    private int pnrCounter; // Simple integer counter to create easy PNR numbers

    public BookingService(BookingRepository bookingRepository, FlightRepository flightRepository, FlightService flightService) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.flightService = flightService;
        this.pnrCounter = 1000; // Starting baseline sequence key values identifiers
    }

    // Formulate a transaction entry object mapping structure
    public Ticket bookTicket(Passenger passenger, String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);

        if (flight == null) {
            System.out.println("❌ Booking Failed: Flight code does not exist.");
            return null;
        }

        if (!flightService.isSeatAvailable(flightNumber)) {
            System.out.println("❌ Booking Failed: No available seats on flight " + flightNumber);
            return null;
        }

        int seatsBeforeBooking = Integer.parseInt(flight.getAvailableSeats());
        flightService.decrementSeat(flightNumber);

        // Assign a seat based on the seat count before booking, then reduce inventory.
        String assignedSeat = "S" + seatsBeforeBooking;

        pnrCounter++;
        String generatedPnr = "PNR" + pnrCounter;

        Ticket newTicket = new Ticket(generatedPnr, flight, passenger, assignedSeat, "CONFIRMED");
        bookingRepository.saveTicket(newTicket);

        return newTicket;
    }

    // Process cancellations sequence checks parameter rollbacks
    public boolean cancelTicket(String pnr) {
        Ticket ticket = bookingRepository.findByPnr(pnr);
        
        if (ticket == null) {
            System.out.println("❌ Cancellation Failed: Invalid PNR reference sequence.");
            return false;
        }

        if (ticket.getBookingStatus().equalsIgnoreCase("CANCELLED")) {
            System.out.println("⚠️ Warning: Ticket is already marked as CANCELLED.");
            return false;
        }

        ticket.setBookingStatus("CANCELLED");
        
        // Return seat back to total available inventory count
        flightService.incrementSeat(ticket.getFlight().getFlightNumber());
        System.out.println("✅ Success: Ticket " + pnr + " has been successfully cancelled.");
        return true;
    }

    // Prints all booking transactions stored in system database buffer tracking metrics
    public void displayAllBookings() {
        Ticket[] allTickets = bookingRepository.getAllTickets();
        int count = bookingRepository.getTicketCount();

        System.out.println("\n--- SYSTEM BOOKING RECORD DATABASE ---");
        if (count == 0) {
            System.out.println("No tickets have been booked yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(allTickets[i].toString());
            System.out.println(); // Space between print layouts output logs windows elements
        }
    }
}

