package com.flightbooking.repository;

import com.flightbooking.model.Ticket;

public class BookingRepository {
    private Ticket[] tickets;
    private int ticketCount;

    public BookingRepository() {
        this.tickets = new Ticket[50]; // System tracks up to 50 active system transactions
        this.ticketCount = 0;
    }

    // Store a ticket into the array buffer tracking current position index
    public void saveTicket(Ticket ticket) {
        if (ticketCount < tickets.length) {
            tickets[ticketCount] = ticket;
            ticketCount++;
        } else {
            System.out.println("❌ Database Full: Cannot issue more tickets.");
        }
    }

    public Ticket[] getAllTickets() {
        return tickets;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    // Locate matching PNR transaction block reference index mapping
    public Ticket findByPnr(String pnr) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getPnr().equalsIgnoreCase(pnr)) {
                return tickets[i];
            }
        }
        return null;
    }
}

