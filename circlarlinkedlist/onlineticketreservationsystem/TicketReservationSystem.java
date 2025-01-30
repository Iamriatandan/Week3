package linkedlist.circlarlinkedlist.onlineticketreservationsystem;

public class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket reservation at the end
    public void bookTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) { // If list is empty, initialize it
            head = tail = newTicket;
            tail.next = head; // Circular linking
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular structure
        }
        System.out.println("Ticket booked successfully! Ticket ID: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void cancelTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head, prev = null;

        // Traverse the list to find the ticket
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head) { // Removing head ticket
                    head = head.next;
                    tail.next = head; // Maintain circular link
                } else {
                    prev.next = temp.next;
                    if (temp == tail) { // If last ticket is removed
                        tail = prev;
                    }
                }
                System.out.println("Ticket " + ticketID + " cancelled successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found.");
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\nBooked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(key) || temp.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket Found: Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    // Count the total number of booked tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}
