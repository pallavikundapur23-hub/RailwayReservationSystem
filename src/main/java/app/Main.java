package app;

import exceptions.BookingNotFoundException;
import exceptions.InvalidTrainException;
import model.Booking;
import model.Passenger;
import model.Train;
import service.ReservationService;
import service.TrainService;
import java.util.List;
import java.util.Scanner;

/** Entry point for the Railway Reservation System console application. */
public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final TrainService trainService = new TrainService();
    private final ReservationService reservationService = new ReservationService();

    public static void main(String[] args) { new Main().run(); }

    /** Repeatedly displays the menu until the user chooses Exit. */
    private void run() {
        System.out.println("Welcome to Railway Reservation System");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> showAllTrains();
                    case 2 -> searchTrain();
                    case 3 -> checkAvailability();
                    case 4 -> bookTicket();
                    case 5 -> viewPnr();
                    case 6 -> cancelTicket();
                    case 7 -> viewWaitingList();
                    case 8 -> viewAllBookings();
                    case 9 -> { running = false; System.out.println("Thank you for using the system."); }
                    default -> System.out.println("Invalid menu option. Choose 1 to 9.");
                }
            } catch (InvalidTrainException | BookingNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n========================================");
        System.out.println("       RAILWAY RESERVATION SYSTEM");
        System.out.println("========================================");
        System.out.println("1. View All Trains");
        System.out.println("2. Search Train");
        System.out.println("3. Check Seat Availability");
        System.out.println("4. Book Ticket");
        System.out.println("5. View Ticket Details (PNR)");
        System.out.println("6. Cancel Ticket");
        System.out.println("7. View Waiting List");
        System.out.println("8. View All Bookings");
        System.out.println("9. Exit");
    }

    private void showAllTrains() {
        for (Train train : trainService.getAllTrains()) System.out.println(train);
    }
    private void searchTrain() {
        String source = readText("Enter source: ");
        String destination = readText("Enter destination: ");
        List<Train> matches = trainService.searchByRoute(source, destination);
        if (matches.isEmpty()) System.out.println("No trains found for this route.");
        else matches.forEach(System.out::println);
    }
    private void checkAvailability() throws InvalidTrainException {
        int number = readInt("Enter train number: ");
        Train train = trainService.findByNumber(number);
        System.out.println("Available seats: " + train.getAvailableSeats());
    }
    private void bookTicket() throws InvalidTrainException {
        int number = readInt("Enter train number: ");
        Train train = trainService.findByNumber(number);
        String name = readText("Enter passenger name: ");
        String phone = readText("Enter phone number: ");
        if (name.isBlank() || phone.isBlank()) { System.out.println("Name and phone cannot be empty."); return; }
        Passenger passenger = new Passenger("U" + System.nanoTime(), name, phone);
        Booking booking = reservationService.book(passenger, train);
        System.out.println("Booking result: " + booking);
    }
    private void viewPnr() throws BookingNotFoundException {
        String pnr = readText("Enter PNR: ");
        System.out.println(reservationService.findBooking(pnr));
    }
    private void cancelTicket() throws BookingNotFoundException {
        String pnr = readText("Enter PNR to cancel: ");
        reservationService.cancel(pnr);
        System.out.println("Cancellation processed. Check booking status and waiting-list promotion.");
    }
    private void viewWaitingList() throws InvalidTrainException {
        int number = readInt("Enter train number: ");
        trainService.findByNumber(number);
        List<Booking> waiting = reservationService.getWaitingBookings(number);
        if (waiting.isEmpty()) System.out.println("Waiting list is empty.");
        else waiting.forEach(System.out::println);
    }
    private void viewAllBookings() {
        List<Booking> bookings = reservationService.getAllBookings();
        if (bookings.isEmpty()) System.out.println("No bookings have been made.");
        else bookings.forEach(System.out::println);
    }
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt); String value = scanner.nextLine().trim();
            try { return Integer.parseInt(value); }
            catch (NumberFormatException ex) { System.out.println("Please enter a valid whole number."); }
        }
    }
    private String readText(String prompt) { System.out.print(prompt); return scanner.nextLine().trim(); }
}
