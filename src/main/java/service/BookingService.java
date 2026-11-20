package service;

import model.Booking;
import model.Passenger;
import model.Train;
import util.PNRGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Coordinates reservations and indexes bookings by their unique PNR. */
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    private final Map<String, Booking> bookingsByPnr = new HashMap<>();
    private final SeatService seatService = new SeatService();

    public Booking bookConfirmed(Passenger passenger, Train train) {
        if (!seatService.reserveSeat(train)) return null;
        Booking booking = new Booking(PNRGenerator.nextPnr(), passenger, train, Booking.Status.CONFIRMED);
        bookings.add(booking); bookingsByPnr.put(booking.getPnr(), booking);
        return booking;
    }
    public Booking findByPnr(String pnr) { return bookingsByPnr.get(pnr); }
    public List<Booking> getAllBookings() { return new ArrayList<>(bookings); }
}
