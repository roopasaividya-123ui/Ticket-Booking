package com.flightbooking.main;

import com.flightbooking.model.Passenger;
import com.flightbooking.model.Ticket;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.BookingService;
import com.flightbooking.service.FlightService;

public class Main {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        FlightService flightService = new FlightService(flightRepository);
        BookingRepository bookingRepository = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepository, flightRepository, flightService);

        System.out.println("=== Flight Booking System ===");
        flightService.displayAllFlights();

        Passenger passenger1 = new Passenger("P001", "Alice", 28, "alice@example.com");
        Passenger passenger2 = new Passenger("P002", "Bob", 35, "bob@example.com");

        Ticket bookedTicket = bookingService.bookTicket(passenger1, "AI101");
        if (bookedTicket != null) {
            System.out.println("\nBooked Ticket:\n" + bookedTicket);
        }

        Ticket secondBooking = bookingService.bookTicket(passenger2, "AI101");
        if (secondBooking != null) {
            System.out.println("\nBooked Ticket:\n" + secondBooking);
        }

        bookingService.displayAllBookings();

        if (bookedTicket != null) {
            bookingService.cancelTicket(bookedTicket.getPnr());
        }

        flightService.displayAllFlights();
    }
}
