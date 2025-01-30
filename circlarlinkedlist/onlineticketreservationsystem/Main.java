package linkedlist.circlarlinkedlist.onlineticketreservationsystem;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Booking some tickets
        system.bookTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.bookTicket(102, "Bob", "Interstellar", "B2", "12:30 PM");
        system.bookTicket(103, "Charlie", "Inception", "C3", "03:00 PM");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Inception");

        // Cancel a ticket
        system.cancelTicket(102);
        system.displayTickets();

        // Count total booked tickets
        System.out.println("Total tickets booked: " + system.countTickets());
    }
}
